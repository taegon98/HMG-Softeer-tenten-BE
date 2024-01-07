package softeer.tenten.repository.popup.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeer.tenten.entity.popup.event.Event;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findAllByPopupId(Long popupId);
}
