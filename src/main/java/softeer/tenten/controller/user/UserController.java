package softeer.tenten.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softeer.tenten.dto.user.UserRequest;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.user.UserService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserRequest.Login login){
        return ResponseEntity.ok(ApiResponse.onSuccess(userService.login(login)));
    }
}
