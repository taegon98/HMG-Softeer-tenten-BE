package softeer.tenten.service.event;

import com.amazonaws.services.s3.AmazonS3Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.event.EventResponse;
import softeer.tenten.entity.event.Event;
import softeer.tenten.entity.event.UserEvent;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.event.EventMapper;
import softeer.tenten.repository.event.EventRepository;
import softeer.tenten.repository.event.UserEventRepository;
import softeer.tenten.repository.popup.PopupRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventService {

    private final EventRepository eventRepository;
    private final UserEventRepository userEventRepository;

    //이벤트 전체 조회
    public List<EventResponse.EventList> getEventList(Long id) {
        List<Event> events = eventRepository.findAllByPopupId(id);

        if (events.isEmpty()) {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return events.stream()
                .map(EventMapper::toEventResponse)
                .toList();
    }

    //이벤트 상세 조회
    public EventResponse.EventDetail getEventDetail(Long id, Long eventId) {

        Optional<Event> event = eventRepository.findAllByPopupIdAndId(id, eventId);

        if (event.isEmpty()) {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        Optional<UserEvent> userEvent = userEventRepository.findByUserIdAndEventId(id, eventId);

        if (userEvent.isEmpty()) { //Event에 참여하지 않은 경우
            return EventMapper.toEventDetailResponse(event.get(), 0);
        }
        else { //Event에 참여한 경우
            return EventMapper.toEventDetailResponse(event.get(), 1);
        }
    }
}
