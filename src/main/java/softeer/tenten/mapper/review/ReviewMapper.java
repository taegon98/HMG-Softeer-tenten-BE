package softeer.tenten.mapper.review;

import lombok.extern.slf4j.Slf4j;
import softeer.tenten.dto.review.ReviewResponse;
import softeer.tenten.entity.area.Destination;
import softeer.tenten.entity.review.Review;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class ReviewMapper {

    public static ReviewResponse.ReviewList toReviewList(Review review) {
        List<Destination> destinations = review.getPopup().getDestination();

        LocalDate visitDate = getLocalDateTime(review, destinations).getStartedAt();
        String visitPlace = getLocalDateTime(review, destinations).getName();

        String date = visitDate.getYear() + "." + visitDate.getMonthValue() + "." + visitDate.getDayOfMonth() + "." + visitDate.getDayOfWeek();

        return ReviewResponse.ReviewList.builder()
                .nickname(review.getUser().getNickname())
                .destination(visitPlace)
                .date(date)
                .content(review.getContent())
                .image(review.getImage())
                .build();
    }

    private static Destination getLocalDateTime(Review review, List<Destination> destinations) {

        log.info(review.getVisitedAt().toString());
        for (Destination destination : destinations) {
            if (review.getVisitedAt().isBefore(destination.getStartedAt())
            || review.getVisitedAt().isEqual(destination.getStartedAt())
            || review.getVisitedAt().isAfter(destination.getStartedAt())) {
                return destination;
            }
        }
        throw new GeneralException(StatusCode.NOT_FOUND);
    }
}
