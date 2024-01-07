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
        private final List<String> destinations;
        private final String duration;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PopupDetail {
        private final String category;
        private final String brand;
        private final String title;
        private final String introduction;
        private final List<String> tags;
        private final Integer status;
        private final List<String> destination;
        private final String duration;
        private final Integer capacity;
        private final String carType;
        private final String contentImage;
        private final String otherImage;
    }
}
