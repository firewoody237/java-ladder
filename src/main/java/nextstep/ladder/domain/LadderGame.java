package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private final GameInfo gameInfo;
    private final Ladder ladder;
    private final LadderResult ladderResult;

    public LadderGame(List<String> users, int floor, List<String> winProducts, LineStrategy lineStrategy) {
        this.gameInfo = GameInfo.of(Users.from(users), WinProducts.from(winProducts));
        this.ladder = Ladder.of(floor, users.size(), lineStrategy);
        this.ladderResult = new LadderResult(getResultLadderGame());
    }

    private Map<User, WinProduct> getResultLadderGame() {
        return this.gameInfo.getUsersList().stream()
                .collect(Collectors.toMap(user -> user, user -> calculateUserWinProduct(user.name())));
    }

    private WinProduct calculateUserWinProduct(String name) {
        int destinationPosition = this.ladder.destinationPosition(this.gameInfo.getUserDepartPosition(name));

        return this.gameInfo.getWinProductsOf(destinationPosition);
    }

    public List<String> getParticipants() {
        return gameInfo.getParticipantsList();
    }

    public List<Line> getLadderInfo() {
        return this.ladder.getLadderInfo();
    }

    public String getWinProduct(String name) {
        validateParticipant(name);
        return this.ladderResult.getUserWinProductOf(name);
    }

    private void validateParticipant(String name) {
        if (!this.gameInfo.hasUserName(name)) {
            throw new IllegalArgumentException("조회하려는 참여자가 존재하지 않습니다.");
        }
    }
}
