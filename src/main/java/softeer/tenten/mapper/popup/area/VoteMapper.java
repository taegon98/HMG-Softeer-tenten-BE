package softeer.tenten.mapper.popup.area;

import softeer.tenten.dto.popup.area.VoteResponse;
import softeer.tenten.entity.popup.area.Option;

public class VoteMapper {
    public static VoteResponse.VoteOption toVoteOption(Option option, Integer result){
        return VoteResponse.VoteOption.builder()
                .id(option.getId())
                .name(option.getName())
                .result(result)
                .build();
    }
}
