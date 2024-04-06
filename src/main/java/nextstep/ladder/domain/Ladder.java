package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private final Lines lines;

    private Ladder(Floor floor, int countPole, LineStrategy strategy) {
        this.lines = Lines.of(floor, countPole, strategy);
    }

    public static Ladder of(int floor, int countPole, LineStrategy strategy) {
        return new Ladder(
                Floor.from(floor),
                countPole,
                strategy
        );
    }

    public List<Line> getLadderInfo() {
        return this.lines.toList();
    }

    public int destinationPosition(int departPosition) {
        return this.lines.getUserWinLocation(departPosition);
    }
}
