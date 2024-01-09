package softeer.tenten.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeer.tenten.entity.event.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByPopupId(Long id);

    Optional<Event> findAllByPopupIdAndId(Long id, Long eventId);
}
