package softeer.tenten.mapper.vote;

import softeer.tenten.dto.vote.VoteResponse;
import softeer.tenten.entity.area.Option;
import softeer.tenten.entity.vote.Vote;
import softeer.tenten.entity.user.User;

import java.time.LocalDateTime;
import java.util.List;

public class VoteMapper {
    public static VoteResponse.VoteResult toVoteResult(Option option, Integer result){
        return VoteResponse.VoteResult.builder()
                .id(option.getId())
                .name(option.getName())
                .result(result)
                .build();
    }

    public static VoteResponse.VoteInformation toVoteInformation(List<VoteResponse.VoteResult> voteResults, Long myVoteNumber){
        return VoteResponse.VoteInformation.builder()
                .voteResults(voteResults)
                .myVoteNumber(myVoteNumber)
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
