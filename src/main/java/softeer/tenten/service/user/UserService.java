package softeer.tenten.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softeer.tenten.dto.user.UserRequest;
import softeer.tenten.dto.user.UserResponse;
import softeer.tenten.entity.user.User;
import softeer.tenten.global.api.status.StatusCode;
import softeer.tenten.global.exception.GeneralException;
import softeer.tenten.mapper.user.UserMapper;
import softeer.tenten.repository.user.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserResponse.Login login(UserRequest.Login login){
        User user = getUserByUserId(login.getUserId());

        if(isLoginFailure(user, login.getPassword())){
            throw new GeneralException(StatusCode.NOT_FOUND);
        }

        return UserMapper.toLogin(user);
    }

    public User getUserByUserId(String userId){
        return userRepository.findUserByUserId(userId).orElseThrow(() -> new GeneralException(StatusCode.NOT_FOUND));
    }

    private boolean isLoginFailure(User user, String password){
        return !user.getPassword().equals(password);
    }
}
