package range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntRangeEvensOddsTest {

    @Test
    void testEvensProduceSameResult() {
        IntRange evensToTen = IntRange.evensFromTo(0, 10);
        IntRange evensFromZeroToTen = IntRange.evensFromZeroTo(10);

        assertThat(evensToTen).isEqualTo(evensFromZeroToTen);
    }

    @Test
    void testEvensRange() {
        IntRange evensToTen = IntRange.evensFromTo(0, 10);

        assertThat(evensToTen.stream())
                .containsAll(Stream.iterate(0, i -> i <= 10, i -> i + 2).toList());
    }

    @Test
    void testEvensReversedRange() {
        IntRange evensFromTenToZero = IntRange.evensDownToZero(10);

        assertThat(evensFromTenToZero.stream())
                .containsAll(Stream.iterate(10, i -> i >= 0, i -> i - 2).toList());
    }

    @Test
    void testOddsProduceSameResult() {
        IntRange oddsToTen = IntRange.oddsFromTo(0, 10);
        IntRange oddsFromOneToTen = IntRange.oddsFromOneTo(10);

        assertThat(oddsToTen).isEqualTo(oddsFromOneToTen);
    }

    @Test
    void testOddsRange() {
        IntRange oddsToTen = IntRange.oddsFromTo(0, 10);

        assertThat(oddsToTen.stream())
                .containsAll(Stream.iterate(1, i -> i <= 9, i -> i + 2).toList());
    }

    @Test
    void testOddsReversedRange() {
        IntRange oddsFromTenToOne = IntRange.oddsDownToOne(10);

        assertThat(oddsFromTenToOne.stream())
                .containsAll(Stream.iterate(9, i -> i >= 1, i -> i - 2).toList());
    }
}
