package softeer.tenten.dto.popup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class PopupResponse {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class PopupList {
        private final String category;
        private final String brand;
        private final String title;
        private final List<String> destination;
        private final String duration;
    }
}
