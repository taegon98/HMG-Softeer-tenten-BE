package softeer.tenten.repository.popup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeer.tenten.entity.popup.Popup;

import java.util.List;

@Repository
public interface PopupRepository extends JpaRepository<Popup, Long> {
    List<Popup> findAllByOrderByDistanceAsc();
}
