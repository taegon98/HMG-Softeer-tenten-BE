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

    public static EventResponse.EventDetail toEventDetailResponse(Event event, Integer status){
        return EventResponse.EventDetail.builder()
                .name(event.getName())
                .title(event.getTitle())
                .content(event.getContent())
                .image(event.getImage())
                .status(status)
                .build();
    }
}
