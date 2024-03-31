package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private final Lines lines;
    private final Users users;

    public static Ladder of(int floor, List<String> users, LineStrategy strategy) {
        return new Ladder(
                Floor.from(floor),
                Users.from(users),
                strategy
        );
    }

    private Ladder(Floor floor, Users users, LineStrategy strategy) {
        this.users = users;
        this.lines = Lines.of(floor, users.countOfUsers(), strategy);
    }

    public List<String> getParticipants() {
        return this.users.toNameList();
    }

    public List<Line> getLadderInfo() {
        return this.lines.toList();
    }
}
