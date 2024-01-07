package softeer.tenten.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class EventResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class EventList {
        private final String name;
        private final String title;
        private final String image;
    }
}
