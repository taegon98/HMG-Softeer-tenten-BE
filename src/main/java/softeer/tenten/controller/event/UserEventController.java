package softeer.tenten.controller.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softeer.tenten.dto.event.EventRequest;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.event.UserEventService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserEventController {

    private final UserEventService userEventService;

    @PostMapping("/pop-up/{id}/events/{eventId}")
    public ResponseEntity<Object> participateEvent(@PathVariable Long id, @PathVariable Long eventId, @RequestBody EventRequest.EventParticipation eventParticipation) {
        userEventService.participateEvent(id, eventId, eventParticipation);
        return ResponseEntity.ok(ApiResponse.onSuccess("참여 성공"));
    }
}
