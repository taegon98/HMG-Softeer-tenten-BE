package softeer.tenten.dto.event;

import lombok.*;

public class EventRequest {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventCode {
        private String code;
    }
}
