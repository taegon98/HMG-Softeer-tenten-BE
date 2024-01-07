package softeer.tenten.mapper.popup.event;

import softeer.tenten.dto.popup.event.EventResponse;
import softeer.tenten.entity.popup.event.Event;

public class EventMapper {

    public static EventResponse.EventList toEventResponse(Event event){
        return EventResponse.EventList.builder()
                .name(event.getName())
                .title(event.getTitle())
                .image(event.getImage())
                .build();
    }
}
