package softeer.tenten.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
    @Builder
    @Getter
    @AllArgsConstructor
    public static class Login{
        private final String userId;
        private final String password;
    }
}
