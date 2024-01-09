package softeer.tenten.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ReviewResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewList {
        private final String nickname;
        private final String destination;
        private final String date;
        private final String content;
        private final String image;
    }
}
