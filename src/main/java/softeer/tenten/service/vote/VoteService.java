package softeer.tenten.service.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.vote.VoteRequest;
import softeer.tenten.dto.vote.VoteResponse;
import softeer.tenten.entity.area.Option;
import softeer.tenten.entity.vote.Vote;
import softeer.tenten.entity.user.User;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.vote.VoteMapper;
import softeer.tenten.repository.area.OptionRepository;
import softeer.tenten.repository.vote.VoteRepository;
import softeer.tenten.service.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VoteService {
    private final VoteRepository voteRepository;
    private final OptionRepository optionRepository;

    private final UserService userService;

    @Transactional(readOnly = false)
    public List<VoteResponse.RegisterVote> getPopUpVoteOption(Long id){
        List<Option> options = getOptionsByPopUpId(id);

        if(options.isEmpty()){
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return options.stream()
                .map((option) -> VoteMapper.toVoteOption(option, getVoteResult(option.getId())))
                .toList();
    }

    @Transactional
    public Long createPopUpVote(Long popUpId, VoteRequest.VoteOption voteOption){
        List<Option> options = optionRepository.findAllByPopupId(popUpId);

        for(Option option: options) {
            if (existsVote(option.getId(), voteOption.getUserId())) {
                throw new GeneralException(StatusCode.BAD_REQUEST);
            }
        }

        User user = userService.getUserByUserId(voteOption.getUserId());
        Option option = getOptionByOptionId(voteOption.getOptionId());

        Vote vote = VoteMapper.toVote(user, option);

        voteRepository.save(vote);

        return vote.getId();
    }

    private boolean existsVote(Long optionId, String userId){
        return voteRepository.existsByOptionIdAndUserUserId(optionId, userId);
    }

    private Option getOptionByOptionId(Long optionId){
        return optionRepository.findById(optionId).orElseThrow(() -> new GeneralException(StatusCode.NOT_FOUND));
    }

    private List<Option> getOptionsByPopUpId(Long id){
        return optionRepository.findAllByPopupId(id);
    }

    private Integer getVoteResult(Long id){
        return voteRepository.countAllByOptionId(id);
    }
}
