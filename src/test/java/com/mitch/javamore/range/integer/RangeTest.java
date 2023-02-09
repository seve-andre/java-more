package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RangeTest {

    @Test
    void testForwardRanges() {
        assertThat(Range.fromTo(0, 10).stream())
                .containsExactlyElementsOf(IntStream.rangeClosed(0, 10).boxed().toList());

        assertThat(Range.fromToWithStep(0, 100, 10).stream())
                .containsExactlyElementsOf(Stream.iterate(0, i -> i <= 100, i -> i + 10).toList());
    }

    @Test
    void testReversedRanges() {
        assertThat(Range.fromTo(50, 10).stream())
                .containsExactlyElementsOf(Stream.iterate(50, i -> i >= 10, i -> i - 1).toList());

        assertThat(Range.fromToWithStep(50, 10, 5).stream())
                .containsExactlyElementsOf(Stream.iterate(50, i -> i >= 10, i -> i - 5).toList());
    }

    @Test
    void testReverseMethod() {
        Range oneToTen = Range.oneTo(10);
        Range tenToOne = Range.downToOne(10);

        assertThat(oneToTen).isEqualTo(tenToOne.reverse());
    }

    @Test
    void testEvensAndOdds() {
        assertThat(Range.evensFromTo(0, 10).stream())
                .containsExactlyElementsOf(Stream.iterate(0, i -> i <= 10, i -> i + 2).toList());

        assertThat(Range.evensDownToZero(10).stream())
                .containsExactlyElementsOf(Stream.iterate(10, i -> i >= 0, i -> i - 2).toList());

        assertThat(Range.oddsFromTo(0, 10).stream())
                .containsExactlyElementsOf(Stream.iterate(1, i -> i <= 9, i -> i + 2).toList());

        assertThat(Range.oddsDownToOne(10).stream())
                .containsExactlyElementsOf(Stream.iterate(9, i -> i >= 1, i -> i - 2).toList());
    }

    @Test
    void testSameParams() {
        assertThat(Range.fromTo(1, 1).stream()).containsExactly(1);
        assertThat(Range.fromToWithStep(1, 1, -1).stream()).containsExactly(1);
    }

    @Test
    void testIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Range.downToOne(-2));
        assertThatIllegalArgumentException().isThrownBy(() -> Range.downToZero(-2));
    }
}
