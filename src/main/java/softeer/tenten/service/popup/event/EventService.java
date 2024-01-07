package softeer.tenten.service.popup.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softeer.tenten.dto.popup.event.EventResponse;
import softeer.tenten.entity.popup.event.Event;
import softeer.tenten.mapper.popup.event.EventMapper;
import softeer.tenten.repository.popup.event.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    public List<EventResponse.EventList> getEventList(Long id) {
        Optional<Event> events = eventRepository.findAllByPopupId(id);
        return events.stream()
                .map(EventMapper::toEventResponse)
                .toList();
    }
}
