package softeer.tenten.service.popup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.entity.popup.area.Destination;
import softeer.tenten.entity.popup.criteria.Brand;
import softeer.tenten.entity.popup.criteria.Category;
import softeer.tenten.entity.popup.post.Popup;
import softeer.tenten.mapper.popup.PopupMapper;
import softeer.tenten.repository.popup.PopupRepository;

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
                .map(popup -> {
                    Category category = popup.getCategory();
                    List<Destination> destinations = popup.getDestination();
                    Brand brand = popup.getBrand();
                    return PopupMapper.toPopupResponse(popup, category, destinations, brand);
                })
                .toList();
    }
}
