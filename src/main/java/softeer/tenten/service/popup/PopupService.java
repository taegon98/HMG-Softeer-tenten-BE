package softeer.tenten.service.popup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.entity.popup.Popup;
import softeer.tenten.entity.user.User;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.popup.PopupMapper;
import softeer.tenten.repository.popup.PopupRepository;
import softeer.tenten.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PopupService {

    private final PopupRepository popupRepository;
    private final UserRepository userRepository;

    //팝업 전체 조회
    public List<PopupResponse.PopupList> getPopupList() {
        List<Popup> popups = popupRepository.findAll();

        popups.forEach(popup -> {
            popup.calculateDistance(getDistance(popup));
        });

        List<Popup> popupList = popupRepository.findAllByOrderByDistanceAsc();

        if (popups.isEmpty()) {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return popupList.stream()
                .map(PopupMapper::toPopupResponse)
                .toList();
    }

    //팝업 상세 조회
    public PopupResponse.PopupDetail getPopupDetail(Long id) {
        Optional<Popup> popup = popupRepository.findById(id);

        if (popup.isEmpty()) {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return PopupMapper.toPopupDetailResponse(popup.get());
    }

    public Popup getPopUpByPopUpId(Long popUpId){
        return popupRepository.findById(popUpId).orElseThrow(() -> new GeneralException(StatusCode.NOT_FOUND));
    }

    public Double getDistance(Popup popup){
        Optional<User> userOptional = userRepository.findById(1L);

        if(userOptional.isEmpty()){
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        Double xCoord = userOptional.get().getXCoord();
        Double yCoord = userOptional.get().getYCoord();

        if (popup.getDestination().isEmpty()) {
            return 9999.9999;
        }

        return Math.sqrt(Math.pow(
                xCoord - popup.getDestination().get(0).getXCoord(), 2) + Math.pow(yCoord - popup.getDestination().get(0).getYCoord(), 2));
    }
}
