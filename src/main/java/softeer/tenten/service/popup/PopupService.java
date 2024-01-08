package softeer.tenten.service.popup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Order;
import org.springframework.data.domain.Sort;
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

import java.util.Collections;
import java.util.Comparator;
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

        if (popups.isEmpty()) {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return popups.stream()
                .map(popup -> PopupMapper.toPopupResponse(popup, getDistance(popup)))
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
        Double xCoord = userOptional.get().getXCoord();
        Double yCoord = userOptional.get().getYCoord();

        Double distance = Math.sqrt(
                Math.pow(xCoord - popup.getDestination().get(0).getXCoord(), 2) + Math.pow(yCoord - popup.getDestination().get(0).getYCoord(), 2));

        return distance;
    }

    public List<PopupResponse.PopupList> sortPopupsByDistance(List<PopupResponse.PopupList> popups) {
        Comparator<PopupResponse.PopupList> distance = Comparator.comparingDouble(PopupResponse.PopupList::getDistance);

        Collections.sort(popups, distance);

        return popups;
    }
}
