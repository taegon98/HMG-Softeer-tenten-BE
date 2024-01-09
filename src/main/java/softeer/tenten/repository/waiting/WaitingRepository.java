package softeer.tenten.repository.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import softeer.tenten.entity.waiting.Waiting;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WaitingRepository extends JpaRepository<Waiting, Long> {
    boolean existsByPopupIdAndUserUserId(Long popUpId, String userId);
    Optional<Waiting> findByPopupIdAndUserUserId(Long popUpId, String userId);
    Integer countAllByPopupIdAndCreatedAtBetween(Long popUpId, LocalDateTime lastDay, LocalDateTime waitingTime);
    Integer countAllByPopupIdAndStatusAndCreatedAtBefore(Long popUpId, Integer status, LocalDateTime waitingTime);
}
