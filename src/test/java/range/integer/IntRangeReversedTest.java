package range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntRangeReversedTest {

    @Test
    void testProduceSameResultReversed() {
        IntRange tenToOne = IntRange.downToOne(10);
        IntRange fromTenToOne = IntRange.fromTo(10, 1);

        IntRange tenToZero = IntRange.downToZero(10);
        IntRange fromTenToZero = IntRange.fromTo(10, 0);

        assertThat(tenToOne).isEqualTo(fromTenToOne);
        assertThat(tenToZero).isEqualTo(fromTenToZero);
    }

    @Test
    void testReversedRanges() {
        IntRange tenToOne = IntRange.downToOne(10);
        IntRange tenToZero = IntRange.downToZero(10);
        IntRange fiftyToTen = IntRange.fromTo(50, 10);

        assertThat(tenToOne.stream())
                .containsAll(Stream.iterate(10, i -> i >= 1, i -> i - 1).toList());

        assertThat(tenToZero.stream())
                .containsAll(Stream.iterate(10, i -> i >= 0, i -> i - 1).toList());

        assertThat(fiftyToTen.stream())
                .containsAll(Stream.iterate(50, i -> i >= 10, i -> i - 1).toList());
    }

    @Test
    void testReversedRangesWithStep() {
        IntRange fiftyToTenStep5 = IntRange.fromToWithStep(50, 10, 5);

        assertThat(fiftyToTenStep5.stream())
                .containsAll(Stream.iterate(50, i -> i >= 10, i -> i - 5).toList());
    }

    @Test
    void testReversedMethod() {
        IntRange oneToTen = IntRange.oneTo(10);
        IntRange tenToOne = IntRange.downToOne(10);

        assertThat(oneToTen).isEqualTo(tenToOne.reverse());
    }

}
