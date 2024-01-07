package softeer.tenten.service.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import softeer.tenten.dto.event.EventResponse;
import softeer.tenten.entity.event.Event;
import softeer.tenten.entity.event.UserEvent;
import softeer.tenten.entity.user.User;
import softeer.tenten.mapper.event.EventMapper;
import softeer.tenten.repository.event.EventRepository;
import softeer.tenten.repository.event.UserEventRepository;
import softeer.tenten.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserEventRepository userEventRepository;

    public List<EventResponse.EventList> getEventList(Long id) {
        Optional<Event> events = eventRepository.findAllByPopupId(id);
        return events.stream()
                .map(EventMapper::toEventResponse)
                .toList();
    }

    public EventResponse.EventDetail getEventDetail(Long id, Long eventId) {

        Event event = eventRepository.findById(eventId).orElseThrow();
        Optional<UserEvent> userEvent = userEventRepository.findByUserIdAndEventId(id, eventId);

        if (userEvent.isEmpty()) { //Event에 참여하지 않은 경우
            return EventMapper.toEventDetailResponse(event, 0);
        }
        else { //Event에 참여한 경우
            return EventMapper.toEventDetailResponse(event, 1);
        }
    }
}
