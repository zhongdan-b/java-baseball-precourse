package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @Test
    void 문자열로_숫자야구_숫자를_생성한다() {
        BaseballNumber baseballNumber = new BaseballNumber("123");

        assertThat(baseballNumber.getNumbers()).containsExactly(1, 2, 3);
    }

    @Test
    void 길이가_3이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BaseballNumber("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리");
    }

    @Test
    void 숫자가_아닌_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BaseballNumber("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만");
    }

    @Test
    void 범위를_벗어난_숫자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BaseballNumber("120"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9");
    }

    @Test
    void 중복_숫자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BaseballNumber("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른");
    }

    @Test
    void 비교_결과로_스트라이크와_볼을_계산한다() {
        BaseballNumber answer = new BaseballNumber("425");
        BaseballNumber user = new BaseballNumber("456");

        GameResult gameResult = answer.compare(user);

        assertThat(gameResult.getStrike()).isEqualTo(1);
        assertThat(gameResult.getBall()).isEqualTo(1);
    }
}
