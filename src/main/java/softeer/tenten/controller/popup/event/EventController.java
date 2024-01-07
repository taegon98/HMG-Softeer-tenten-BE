package softeer.tenten.controller.popup.event;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softeer.tenten.dto.popup.event.EventResponse;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.popup.event.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventController {

    private final EventService eventService;

    @GetMapping("/pop-up/{id}/events")
    public ResponseEntity<Object> getEventList(@PathVariable Long id) {
        List<EventResponse.EventList> events = eventService.getEventList(id);
        return ResponseEntity.ok(ApiResponse.onSuccess(events));
    }
}
