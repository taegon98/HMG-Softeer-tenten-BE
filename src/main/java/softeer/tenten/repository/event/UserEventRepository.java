package softeer.tenten.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeer.tenten.entity.event.UserEvent;

import java.util.Optional;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
    Optional<UserEvent> findByUserUserIdAndEventId(String userId, Long eventId);
}
