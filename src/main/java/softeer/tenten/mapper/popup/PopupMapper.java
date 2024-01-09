package softeer.tenten.mapper.popup;

import lombok.extern.slf4j.Slf4j;
import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.entity.area.Destination;
import softeer.tenten.entity.popup.Popup;

import java.time.LocalDate;

@Slf4j
public class PopupMapper {

    public static PopupResponse.PopupList toPopupResponse(Popup popup) {
        String duration = getString(popup);

        return PopupResponse.PopupList.builder()
                .category(popup.getCategory().getName())
                .brand(popup.getBrand().getName())
                .title(popup.getTitle())
                .destinations(popup.getDestination().stream()
                        .map(Destination::getName)
                        .toList())
                .duration(duration)
                .build();
    }

    public static PopupResponse.PopupDetail toPopupDetailResponse(Popup popup){
        String duration = getString(popup);

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
                        .map(Destination::getName)
                        .toList())
                .duration(duration)
                .capacity(popup.getCapacity())
                .carType(popup.getCarType())
                .contentImage(popup.getContentImage())
                .otherImage(popup.getOtherImage())
                .build();
    }

    private static String getString(Popup popup) {
        LocalDate startedAt = popup.getStartedAt();
        LocalDate endedAt = popup.getEndedAt();
        return startedAt.getMonthValue() + "월 " + startedAt.getDayOfMonth() + "일 ~ " + endedAt.getMonthValue() + "월 " + endedAt.getDayOfMonth() + "일";
    }
}
