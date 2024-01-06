package softeer.tenten.global.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import softeer.tenten.global.api.status.StatusCode;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {
    private final Boolean success;
    private final String code;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> of(Boolean success, String code, String message, T data){
        return new ApiResponse<>(success, code, message, data);
    }

    public static <T> ApiResponse<T> of(Boolean success, StatusCode statusCode, T data){
        return of(success, statusCode.getCode(), statusCode.getMessage(), data);
    }

    public static <T> ApiResponse<T> onSuccess(T data){
        StatusCode statusCode = StatusCode.OK;

        return of(true, statusCode, data);
    }
}
