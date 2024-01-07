package softeer.tenten.repository.waiting;

import org.springframework.data.jpa.repository.JpaRepository;
import softeer.tenten.entity.waiting.Waiting;

public interface WaitingRepository extends JpaRepository<Waiting, Long> {
    boolean existsByPopup_IdAndUser_UserId(Long popUpId, String userId);
}
