package softeer.tenten.dto.waiting;

import lombok.*;

public class WaitingRequest {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterWaiting{
        private String userId;
    }
}
