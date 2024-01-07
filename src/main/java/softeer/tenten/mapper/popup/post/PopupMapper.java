package softeer.tenten.mapper.popup.post;

import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.entity.popup.area.Destination;
import softeer.tenten.entity.popup.criteria.Brand;
import softeer.tenten.entity.popup.criteria.Category;
import softeer.tenten.entity.popup.post.Popup;

import java.time.LocalDateTime;
import java.util.List;

public class PopupMapper {

    public static PopupResponse.PopupList toPopupResponse(Popup popup){
        LocalDateTime startedAt = popup.getStartedAt();
        LocalDateTime endedAt = popup.getEndedAt();
        String duration = startedAt.getMonthValue() + "월 " + startedAt.getDayOfMonth() + "일 ~ " + endedAt.getMonthValue() + "월 " + endedAt.getDayOfMonth() + "일";

        return PopupResponse.PopupList.builder()
                .category(popup.getCategory().getName())
                .brand(popup.getBrand().getName())
                .title(popup.getTitle())
                .destinations(popup.getDestination().stream()
                        .map(destination -> destination.getName())
                        .toList())
                .duration(duration)
                .build();
    }

    public static PopupResponse.PopupDetail toPopupDetailResponse(Popup popup){
        LocalDateTime startedAt = popup.getStartedAt();
        LocalDateTime endedAt = popup.getEndedAt();
        String duration = startedAt.getMonthValue() + "월 " + startedAt.getDayOfMonth() + "일 ~ " + endedAt.getMonthValue() + "월 " + endedAt.getDayOfMonth() + "일";

        return PopupResponse.PopupDetail.builder()
                .category(popup.getCategory().getName())
                .brand(popup.getBrand().getName())
                .title(popup.getTitle())
                .introduction(popup.getIntroduction())
                .tags(popup.getPopupTags().stream()
                        .map(tag -> tag.getTag().getName())
                        .toList())
                .status(popup.getStatus())
                .destination(popup.getDestination().stream()
                        .map(destination -> destination.getName())
                        .toList())
                .duration(duration)
                .capacity(popup.getCapacity())
                .carType(popup.getCarType())
                .contentImage(popup.getContentImage())
                .otherImage(popup.getOtherImage())
                .build();
    }
}
