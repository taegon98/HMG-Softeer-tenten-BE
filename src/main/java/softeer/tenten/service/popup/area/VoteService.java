package softeer.tenten.service.popup.area;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softeer.tenten.dto.popup.area.VoteResponse;
import softeer.tenten.entity.popup.area.Option;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.popup.area.VoteMapper;
import softeer.tenten.repository.popup.area.OptionRepository;
import softeer.tenten.repository.popup.area.VoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final OptionRepository optionRepository;

    public List<VoteResponse.VoteOption> getPopUpVoteOption(Long id){
        List<Option> options = getPopUpOption(id);

        if(options.isEmpty()){
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return options.stream()
                .map((option) -> VoteMapper.toVoteOption(option, getVoteResult(option.getId())))
                .toList();
    }

    private List<Option> getPopUpOption(Long id){
        return optionRepository.findAllByPopup_Id(id);
    }

    private Integer getVoteResult(Long id){
        return voteRepository.countAllByOption_Id(id);
    }
}
