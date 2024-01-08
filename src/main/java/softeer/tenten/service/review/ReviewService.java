package softeer.tenten.service.review;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.review.ReviewResponse;
import softeer.tenten.entity.review.Review;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.review.ReviewMapper;
import softeer.tenten.repository.review.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    //리뷰 전체 조회
    public List<ReviewResponse.ReviewList> getReviewList(Long id) {
        Optional<Review> reviews = reviewRepository.findAllByPopupId(id);

        if (reviews.isEmpty()) {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return reviews.stream()
                .map(ReviewMapper::toReviewList)
                .toList();
    }
}
