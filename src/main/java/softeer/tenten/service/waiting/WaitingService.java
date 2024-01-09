package softeer.tenten.service.waiting;

import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import softeer.tenten.dto.waiting.WaitingRequest;
import softeer.tenten.entity.popup.Popup;
import softeer.tenten.entity.waiting.Waiting;
import softeer.tenten.dto.popup.waiting.WaitingResponse;
import softeer.tenten.entity.user.User;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.waiting.WaitingMapper;
import softeer.tenten.repository.waiting.WaitingRepository;
import softeer.tenten.service.popup.PopupService;
import softeer.tenten.service.user.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class WaitingService {
    private final WaitingRepository waitingRepository;

    private final UserService userService;
    private final PopupService popupService;

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_READ)
    public Long createWaiting(Long popUpId, WaitingRequest.RegisterWaiting registerWaiting){
        if(existsWaiting(popUpId, registerWaiting.getUserId())){
            throw new GeneralException(StatusCode.BAD_REQUEST);
        }

        User user = userService.getUserByUserId(registerWaiting.getUserId());
        Popup popUp = popupService.getPopUpByPopUpId(popUpId);

        Waiting waiting = WaitingMapper.toWaiting(user, popUp);

        waitingRepository.save(waiting);

        return waiting.getId();
    }

    @Transactional
    public WaitingResponse.WaitingInformation getWaitingInformation(Long popUpId, String userId){
        Waiting waiting = getWaiting(popUpId, userId);

        LocalDateTime waitingTime = waiting.getCreatedAt();
        LocalDateTime lastDay = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIDNIGHT);

        Integer waitingNumber = waitingRepository.countAllByPopupIdAndCreatedAtBetween(popUpId, lastDay, waitingTime);
        Integer orderNumber = waitingRepository.countAllByPopupIdAndStatusAndCreatedAtBefore(popUpId, 1, waitingTime);

        return WaitingMapper.toWaitingInformation(waiting.getId(), waitingNumber, orderNumber);
    }

    public Waiting getWaiting(Long popUpId, String userId){
        return waitingRepository.findByPopupIdAndUserUserId(popUpId, userId).orElseThrow(() -> new GeneralException(StatusCode.NOT_FOUND));
    }

    private boolean existsWaiting(Long popUpId, String userId){
        return waitingRepository.existsByPopupIdAndUserUserId(popUpId, userId);
    }
}
