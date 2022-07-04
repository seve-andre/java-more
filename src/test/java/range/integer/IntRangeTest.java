package range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class IntRangeTest {

    @Test
    void testSimpleRanges() {
        // given - when - then
        IntRange firstTenNumbers = IntRange.oneTo(10);
        IntRange evensToTen = IntRange.evensFromTo(1, 10);
        IntRange oddsToTen = IntRange.oddsFromTo(1, 10);

        assertThat(firstTenNumbers.stream().toList())
                .isEqualTo(IntStream.rangeClosed(1, 10).boxed().toList());

    }

    // check reverse() method
    @Test
    void testReversedRanges() {
        IntRange firstTenNumbersReversed = IntRange.downToOne(10);
        IntRange evensToTenReversed = IntRange.evensFromTo(10, 1);
        IntRange oddsToTenReversed = IntRange.oddsFromTo(10, 1);
    }

}
