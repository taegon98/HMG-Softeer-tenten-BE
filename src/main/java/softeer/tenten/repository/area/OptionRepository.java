package softeer.tenten.repository.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeer.tenten.entity.area.Option;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByPopup_Id(Long popUpId);
    boolean existsByPopup_IdAndId(Long popUpId, Long optionId);
}
