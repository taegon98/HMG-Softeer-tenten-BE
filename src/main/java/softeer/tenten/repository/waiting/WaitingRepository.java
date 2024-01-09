package softeer.tenten.repository.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import softeer.tenten.entity.waiting.Waiting;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WaitingRepository extends JpaRepository<Waiting, Long> {
    boolean existsByPopupIdAndUserUserIdAndStatus(Long popUpId, String userId, Integer status);
    Optional<Waiting> findByPopupIdAndUserUserIdAndStatus(Long popUpId, String userId, Integer status);
    Integer countAllByPopupIdAndCreatedAtBetween(Long popUpId, LocalDateTime lastDay, LocalDateTime waitingTime);
    Integer countAllByPopupIdAndStatusAndCreatedAtBefore(Long popUpId, Integer status, LocalDateTime waitingTime);
}
