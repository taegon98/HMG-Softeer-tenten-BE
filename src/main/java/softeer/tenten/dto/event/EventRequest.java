package softeer.tenten.dto.event;

import lombok.*;

public class EventRequest {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventParticipation {
        private String userId;
        private String code;
    }
}
