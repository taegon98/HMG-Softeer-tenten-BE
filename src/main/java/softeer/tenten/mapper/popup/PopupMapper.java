package softeer.tenten.mapper.popup;

import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.entity.popup.area.Destination;
import softeer.tenten.entity.popup.criteria.Brand;
import softeer.tenten.entity.popup.criteria.Category;
import softeer.tenten.entity.popup.post.Popup;

import java.time.LocalDateTime;
import java.util.List;

public class PopupMapper {

    public static PopupResponse.PopupList toPopupResponse(Popup popup, Category category, List<Destination> destinations, Brand brand){
        LocalDateTime startedAt = popup.getStartedAt();
        LocalDateTime endedAt = popup.getEndedAt();
        String duration = startedAt.getMonthValue() + "월 " + startedAt.getDayOfMonth() + "일 ~ " + endedAt.getMonthValue() + "월 " + endedAt.getDayOfMonth() + "일";

        return PopupResponse.PopupList.builder()
                .category(category.getName())
                .brand(brand.getName())
                .title(popup.getTitle())
                .destination(destinations.stream()
                        .map(destination -> destination.getName())
                        .toList())
                .duration(duration)
                .build();
    }
}
