package softeer.tenten.controller.waiting;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softeer.tenten.dto.waiting.WaitingRequest;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.waiting.WaitingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pop-up")
public class WaitingController {
    private final WaitingService waitingService;

    @PostMapping("/{id}/waiting")
    public ResponseEntity<Object> createWaiting(@PathVariable Long id, @RequestBody WaitingRequest.RegisterWaiting registerWaiting){
        return ResponseEntity.ok(ApiResponse.onSuccess(waitingService.createWaiting(id, registerWaiting)));
    }
}
