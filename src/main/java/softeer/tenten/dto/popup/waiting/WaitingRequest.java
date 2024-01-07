package softeer.tenten.dto.popup.waiting;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class WaitingRequest {
    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class RegisterWaiting{
        private final String userId;
    }
}
