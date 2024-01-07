package softeer.tenten.repository.popup.area;

import org.springframework.data.jpa.repository.JpaRepository;
import softeer.tenten.entity.popup.area.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Integer countAllByOption_Id(Long OptionId);
}
