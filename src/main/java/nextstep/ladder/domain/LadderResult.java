package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Map<User, WinProduct> ladderResult;

    public LadderResult(Map<User, WinProduct> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String getUserWinProductOf(String userName) {
        for (Map.Entry<User, WinProduct> entry : this.ladderResult.entrySet()) {
            if (entry.getKey().name().equals(userName)) {
                return entry.getValue().getProductName();
            }
        }

        throw new IllegalArgumentException("해당 되는 이름이 없습니다.");
    }
}
