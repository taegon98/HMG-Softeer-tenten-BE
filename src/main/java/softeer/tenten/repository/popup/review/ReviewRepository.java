package softeer.tenten.repository.popup.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeer.tenten.entity.popup.review.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
