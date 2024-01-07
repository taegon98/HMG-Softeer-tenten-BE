package softeer.tenten.mapper.waiting;

import softeer.tenten.entity.popup.Popup;
import softeer.tenten.entity.waiting.Waiting;
import softeer.tenten.entity.user.User;

public class WaitingMapper {
    public static Waiting toWaiting(User user, Popup popup){
        return Waiting.builder()
                .user(user)
                .popup(popup)
                .build();
    }
}
