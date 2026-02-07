package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    void 생성된_숫자는_3자리다() {
        NumberGenerator numberGenerator = new NumberGenerator();

        BaseballNumber baseballNumber = numberGenerator.generate();

        assertThat(baseballNumber.getNumbers()).hasSize(3);
    }

    @Test
    void 생성된_숫자는_1부터_9_사이이고_중복이_없다() {
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = numberGenerator.generate().getNumbers();
            assertThat(numbers).hasSize(3);
            assertThat(numbers).doesNotHaveDuplicates();
            assertThat(isRange(numbers)).isTrue();
        }
    }

    private boolean isRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number < 1 || number > 9) return false;
        }
        return true;
    }
}
