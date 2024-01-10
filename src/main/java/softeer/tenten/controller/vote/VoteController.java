package softeer.tenten.controller.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softeer.tenten.dto.vote.VoteRequest;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.vote.VoteService;

@RestController
@RequestMapping("/api/pop-up")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @GetMapping("/{id}/vote")
    public ResponseEntity<Object> getPopUpVote(@PathVariable Long id, @RequestParam String userId){
        return ResponseEntity.ok(ApiResponse.onSuccess(voteService.getVoteInformation(id, userId)));
    }

    @PostMapping("{id}/vote")
    public ResponseEntity<Object> createPopUpVote(@PathVariable Long id, @RequestBody VoteRequest.VoteOption voteOption){
        return ResponseEntity.ok(ApiResponse.onSuccess(voteService.createPopUpVote(id, voteOption)));
    }
}
