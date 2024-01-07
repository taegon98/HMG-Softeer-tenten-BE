package softeer.tenten.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class EventRequest {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class EventCode {
        private final String code;
    }
}
