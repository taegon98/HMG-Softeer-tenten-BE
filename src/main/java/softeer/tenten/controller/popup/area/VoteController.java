package softeer.tenten.controller.popup.area;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.popup.area.VoteService;

@RestController
@RequestMapping("/api/pop-up")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @GetMapping("/{id}/vote")
    public ResponseEntity<Object> getPopUpVote(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.onSuccess(voteService.getPopUpVoteOption(id)));
    }
}
