package softeer.tenten.service.popup.area;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softeer.tenten.dto.popup.area.VoteRequest;
import softeer.tenten.dto.popup.area.VoteResponse;
import softeer.tenten.entity.popup.area.Option;
import softeer.tenten.entity.popup.area.Vote;
import softeer.tenten.entity.user.User;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.popup.area.VoteMapper;
import softeer.tenten.repository.popup.area.OptionRepository;
import softeer.tenten.repository.popup.area.VoteRepository;
import softeer.tenten.service.user.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final OptionRepository optionRepository;

    private final UserService userService;

    @Transactional
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
        if(existsOptionByPopUpIdAndOptionId(popUpId, voteOption.getOptionId())){
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        User user = userService.getUserByUserId(voteOption.getUserId());
        Option option = getOptionByOptionId(voteOption.getOptionId());

        Vote vote = VoteMapper.toVote(user, option);

        voteRepository.save(vote);

        return vote.getId();
    }

    private boolean existsOptionByPopUpIdAndOptionId(Long popUpId, Long optionId){
        return optionRepository.existsByPopup_IdAndId(popUpId, optionId);
    }
    private Option getOptionByOptionId(Long optionId){
        return optionRepository.findById(optionId).orElseThrow(() -> new GeneralException(StatusCode.NOT_FOUND));
    }

    private List<Option> getOptionsByPopUpId(Long id){
        return optionRepository.findAllByPopup_Id(id);
    }

    private Integer getVoteResult(Long id){
        return voteRepository.countAllByOption_Id(id);
    }
}
