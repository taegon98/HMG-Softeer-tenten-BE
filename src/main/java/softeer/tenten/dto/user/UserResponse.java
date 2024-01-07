package softeer.tenten.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserResponse {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class Login{
        private final String userId;
    }
}
