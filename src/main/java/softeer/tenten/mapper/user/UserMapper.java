package softeer.tenten.mapper.user;

import softeer.tenten.dto.user.UserRequest;
import softeer.tenten.dto.user.UserResponse;
import softeer.tenten.entity.user.User;

public class UserMapper {
    public static UserResponse.Login toLogin(User user){
        return UserResponse.Login.builder()
                .userId(user.getUserId())
                .build();
    }
}
