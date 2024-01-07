package softeer.tenten.dto.popup.waiting;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class WaitingResponse {
    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class WaitingInformation{
        private final Long id;
        private final Integer waitingNumber;
        private final Integer orderNumber;
    }
}
