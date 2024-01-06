package softeer.tenten.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import softeer.tenten.global.api.status.StatusCode;

@Getter
@RequiredArgsConstructor
public class GeneralException extends RuntimeException{
    private final StatusCode statusCode;

}
