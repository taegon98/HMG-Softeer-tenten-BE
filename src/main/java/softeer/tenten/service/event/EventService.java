package softeer.tenten.service.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softeer.tenten.dto.event.EventResponse;
import softeer.tenten.entity.event.Event;
import softeer.tenten.mapper.event.EventMapper;
import softeer.tenten.repository.event.EventRepository;

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

    public EventResponse.EventDetail getEventDetail(Long id) {
        Event event = eventRepository.findById(id).orElseThrow();
        return EventMapper.toEventDetailResponse(event);
    }
}
