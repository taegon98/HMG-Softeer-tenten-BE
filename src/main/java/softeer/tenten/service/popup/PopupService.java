package softeer.tenten.service.popup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.entity.popup.Popup;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.popup.PopupMapper;
import softeer.tenten.repository.popup.PopupRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PopupService {

    private final PopupRepository popupRepository;

    //팝업 전체 조회
    public List<PopupResponse.PopupList> getPopupList() {
        List<Popup> popups = popupRepository.findAll();

        if (popups.isEmpty()) {
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return popups.stream()
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
}
