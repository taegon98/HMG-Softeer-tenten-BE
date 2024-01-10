package softeer.tenten.dto.vote;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class VoteResponse {
    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class VoteResult {
        private final Long id;
        private final String name;
        private final Integer result;
    }

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class VoteInformation {
        private final List<VoteResult> voteResults;
        private final Long myVoteNumber;
    }
}
