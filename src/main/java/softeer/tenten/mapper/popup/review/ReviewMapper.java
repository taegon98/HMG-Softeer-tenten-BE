package softeer.tenten.mapper.popup.review;

import softeer.tenten.dto.popup.review.ReviewResponse;
import softeer.tenten.entity.popup.area.Destination;
import softeer.tenten.entity.popup.review.Review;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewMapper {

    public static ReviewResponse.ReviewList toReviewList(Review review) {
        List<Destination> destinations = review.getPopup().getDestination();

        LocalDateTime visitDate = getLocalDateTime(review, destinations).getStartedAt();
        String visitPlace = getLocalDateTime(review, destinations).getName();

        String date = visitDate.getYear() + "." + visitDate.getMonthValue() + "." + visitDate.getDayOfMonth() + "." + visitDate.getDayOfWeek();

        return ReviewResponse.ReviewList.builder()
                .title(review.getTitle())
                .destination(visitPlace)
                .date(date)
                .content(review.getContent())
                .image(review.getImage())
                .build();
    }

    private static Destination getLocalDateTime(Review review, List<Destination> destinations) {
        for (Destination destination : destinations) {
            if (review.getVisitedAt().equals(destination.getStartedAt())) {
                return destination;
            }
        }
        return null;
    }
}
