package softeer.tenten.repository.popup.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import softeer.tenten.entity.popup.waiting.Waiting;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WaitingRepository extends JpaRepository<Waiting, Long> {
    boolean existsByPopup_IdAndUser_UserId(Long popUpId, String userId);
    Optional<Waiting> findByPopup_IdAndUser_UserId(Long popUpId, String userId);
    Integer countAllByPopup_IdAndCreatedAtBetween(Long popUpId, LocalDateTime lastDay, LocalDateTime waitingTime);
    Integer countAllByPopup_IdAndStatusAndCreatedAtBefore(Long popUpId, Integer status, LocalDateTime waitingTime);
}
