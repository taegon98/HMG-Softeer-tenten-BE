package softeer.tenten.dto.popup.area;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class VoteResponse {
    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class RegisterVote {
        private final Long id;
        private final String name;
        private final Integer result;
    }
}
