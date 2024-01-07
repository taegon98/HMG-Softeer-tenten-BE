package softeer.tenten.controller.popup;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softeer.tenten.dto.popup.PopupResponse;
import softeer.tenten.global.api.ApiResponse;
import softeer.tenten.service.popup.PopupService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PopupController {

    private final PopupService popupService;

    @GetMapping("/pop-up")
    public ResponseEntity<Object> popup(){
        List<PopupResponse.PopupList> popups = popupService.getPopupList();
        return ResponseEntity.ok(ApiResponse.onSuccess(popups));
    }
}
