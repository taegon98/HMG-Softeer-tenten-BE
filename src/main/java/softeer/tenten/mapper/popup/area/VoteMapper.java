package softeer.tenten.mapper.popup.area;

import softeer.tenten.dto.popup.area.VoteResponse;
import softeer.tenten.entity.popup.area.Option;
import softeer.tenten.entity.popup.area.Vote;
import softeer.tenten.entity.user.User;

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
                .build();
    }
}
