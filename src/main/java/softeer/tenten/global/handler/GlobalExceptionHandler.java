package softeer.tenten.global.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;

@RestControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleGeneralException(GeneralException generalException, WebRequest webRequest){
        return handleExceptionInternal(
                generalException,
                generalException.getStatusCode(),
                HttpHeaders.EMPTY,
                webRequest);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest webRequest){
        StatusCode statusCode = StatusCode.INTERNAL_SERVER_ERROR;

        return handleExceptionInternal(
                e,
                statusCode,
                HttpHeaders.EMPTY,
                webRequest);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, StatusCode statusCode,
                                                           HttpHeaders headers, WebRequest webRequest){
        ApiResponse<Object> body = ApiResponse.of(false, statusCode, null);

        return super.handleExceptionInternal(
                e,
                body,
                headers,
                statusCode.getHttpStatus(),
                webRequest);
    }
}
