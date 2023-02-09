package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RangeEvensOddsTest {

    @Test
    void testEvensProduceSameResult() {
        Range evensToTen = Range.evensFromTo(0, 10);
        Range evensFromZeroToTen = Range.evensFromZeroTo(10);

        assertThat(evensToTen).isEqualTo(evensFromZeroToTen);
    }

    @Test
    void testEvensRange() {
        Range evensToTen = Range.evensFromTo(0, 10);

        assertThat(evensToTen.stream())
                .containsAll(Stream.iterate(0, i -> i <= 10, i -> i + 2).toList());
    }

    @Test
    void testEvensReversedRange() {
        Range evensFromTenToZero = Range.evensDownToZero(10);

        assertThat(evensFromTenToZero.stream())
                .containsAll(Stream.iterate(10, i -> i >= 0, i -> i - 2).toList());
    }

    @Test
    void testOddsProduceSameResult() {
        Range oddsToTen = Range.oddsFromTo(0, 10);
        Range oddsFromOneToTen = Range.oddsFromOneTo(10);

        assertThat(oddsToTen).isEqualTo(oddsFromOneToTen);
    }

    @Test
    void testOddsRange() {
        Range oddsToTen = Range.oddsFromTo(0, 10);

        assertThat(oddsToTen.stream())
                .containsAll(Stream.iterate(1, i -> i <= 9, i -> i + 2).toList());
    }

    @Test
    void testOddsReversedRange() {
        Range oddsFromTenToOne = Range.oddsDownToOne(10);

        assertThat(oddsFromTenToOne.stream())
                .containsAll(Stream.iterate(9, i -> i >= 1, i -> i - 2).toList());
    }
}
