package softeer.tenten.controller.event;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softeer.tenten.dto.event.EventRequest;
import softeer.tenten.dto.event.EventResponse;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.S3.AwsS3Service;
import softeer.tenten.service.event.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventController {

    private final EventService eventService;
    private final AwsS3Service awsS3Service;

    @GetMapping("/pop-up/{id}/events")
    public ResponseEntity<Object> getEventList(@PathVariable Long id) {
        List<EventResponse.EventList> events = eventService.getEventList(id);
        return ResponseEntity.ok(ApiResponse.onSuccess(events));
    }

    @GetMapping("/pop-up/{id}/events/{eventId}")
    public ResponseEntity<Object> getEventDetail(@PathVariable Long id, @PathVariable Long eventId) {
        EventResponse.EventDetail event = eventService.getEventDetail(id, eventId);
        return ResponseEntity.ok(ApiResponse.onSuccess(event));
    }
}
