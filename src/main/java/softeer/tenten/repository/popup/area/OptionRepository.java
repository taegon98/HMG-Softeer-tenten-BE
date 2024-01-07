package softeer.tenten.repository.popup.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeer.tenten.entity.popup.area.Option;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByPopup_Id(Long popUpId);
}
