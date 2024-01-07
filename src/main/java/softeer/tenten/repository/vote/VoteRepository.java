package softeer.tenten.repository.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import softeer.tenten.entity.vote.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Integer countAllByOption_Id(Long OptionId);
}
