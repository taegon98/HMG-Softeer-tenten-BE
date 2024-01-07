package softeer.tenten.service.popup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.entity.popup.post.Popup;
import softeer.tenten.mapper.popup.post.PopupMapper;
import softeer.tenten.repository.popup.post.PopupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class PopupService {

    private final PopupRepository popupRepository;

    public List<PopupResponse.PopupList> getPopupList() {
        List<Popup> popups = popupRepository.findAll();
        return popups.stream()
                .map(PopupMapper::toPopupResponse)
                .toList();
    }

    public PopupResponse.PopupDetail getPopupDetail(Long id) {
        Popup popup = popupRepository.findById(id).orElseThrow();
        return PopupMapper.toPopupDetailResponse(popup);
    }
}
