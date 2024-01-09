package softeer.tenten.service.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.entity.event.Event;
import softeer.tenten.entity.event.UserEvent;
import softeer.tenten.entity.user.User;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.repository.event.EventRepository;
import softeer.tenten.repository.event.UserEventRepository;
import softeer.tenten.repository.user.UserRepository;

import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class UserEventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final UserEventRepository userEventRepository;

    //이벤트 참여
    @Transactional(readOnly = false)
    public void participateEvent(Long id, Long eventId, String code) {
        if (code.equals("938-203-103")) {
            Optional<User> user = userRepository.findById(id);
            Optional<Event> event = eventRepository.findById(eventId);

            if (user.isEmpty() || event.isEmpty()) {
                throw new GeneralException(StatusCode.NOT_FOUND);
            }

            UserEvent userEvent = UserEvent.builder()
                    .user(user.get())
                    .event(event.get())
                    .build();

            userEventRepository.save(userEvent);
        }
        else {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }
    }
}
