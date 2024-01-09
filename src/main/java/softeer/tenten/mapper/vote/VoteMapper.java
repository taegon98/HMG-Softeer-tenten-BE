package softeer.tenten.mapper.vote;

import softeer.tenten.dto.vote.VoteResponse;
import softeer.tenten.entity.area.Option;
import softeer.tenten.entity.vote.Vote;
import softeer.tenten.entity.user.User;

import java.time.LocalDateTime;

public class VoteMapper {
    public static VoteResponse.RegisterVote toVoteOption(Option option, Integer result){
        return VoteResponse.RegisterVote.builder()
                .id(option.getId())
                .name(option.getName())
                .result(result)
                .build();
    }

    public static Vote toVote(User user, Option option){
        return Vote.builder()
                .user(user)
                .option(option)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
