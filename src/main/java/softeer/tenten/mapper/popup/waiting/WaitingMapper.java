package softeer.tenten.mapper.popup.waiting;

import softeer.tenten.dto.popup.waiting.WaitingRequest;
import softeer.tenten.entity.popup.post.Popup;
import softeer.tenten.entity.popup.waiting.Waiting;
import softeer.tenten.entity.user.User;

public class WaitingMapper {
    public static Waiting toWaiting(User user, Popup popup){
        return Waiting.builder()
                .user(user)
                .popup(popup)
                .build();
    }
}
