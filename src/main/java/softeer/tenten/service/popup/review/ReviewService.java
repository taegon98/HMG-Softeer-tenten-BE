package softeer.tenten.service.popup.review;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.popup.review.ReviewResponse;
import softeer.tenten.entity.popup.review.Review;
import softeer.tenten.mapper.popup.review.ReviewMapper;
import softeer.tenten.repository.popup.review.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewResponse.ReviewList> getReviewList() {
        List<Review> reviews = reviewRepository.findAll();

        return reviews.stream()
                .map(ReviewMapper::toReviewList)
                .toList();
    }

}
