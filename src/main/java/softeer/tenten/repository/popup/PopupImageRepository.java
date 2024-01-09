package softeer.tenten.repository.popup;

import org.springframework.data.jpa.repository.JpaRepository;
import softeer.tenten.entity.popup.PopupImage;

import java.util.List;
import java.util.Optional;

public interface PopupImageRepository extends JpaRepository<PopupImage, Long> {
    Optional<PopupImage> findFirstByPopupId(Long popupId);
    List<PopupImage> findAllByPopupId(Long popupId);
}
