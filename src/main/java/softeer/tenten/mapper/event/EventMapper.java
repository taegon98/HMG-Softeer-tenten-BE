package softeer.tenten.mapper.event;

import softeer.tenten.dto.event.EventResponse;
import softeer.tenten.entity.event.Event;

public class EventMapper {

    public static EventResponse.EventList toEventResponse(Event event){
        return EventResponse.EventList.builder()
                .name(event.getName())
                .title(event.getTitle())
                .image(event.getImage())
                .build();
    }
}
