package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UsersTest {

    @DisplayName("참여자 리스트를 List<String> 형태로 변환하여 반환 해준다.")
    @Test
    void getUsersStringListForPrint() {
        // given
        Users users = Users.from(List.of("poppy", "jetty"));

        // then
        assertThat(users.toNameList()).contains("poppy", "jetty");
    }

    @DisplayName("참여자가 2명 미만이면 인원부족으로 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenUserSizeIsLessThan2() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Users.from(List.of("one")));
    }

    @DisplayName("참여자의 수를 반환한다.")
    @Test
    void countParticipants() {
        // given
        Users users = Users.from(List.of("poppy", "jetty"));

        // then
        assertThat(users.countOfUsers()).isEqualTo(2);
    }
}
