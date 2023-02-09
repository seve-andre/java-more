package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RangeReversedTest {

    @Test
    void testProduceSameResultReversed() {
        Range tenToOne = Range.downToOne(10);
        Range fromTenToOne = Range.fromTo(10, 1);

        Range tenToZero = Range.downToZero(10);
        Range fromTenToZero = Range.fromTo(10, 0);

        assertThat(tenToOne).isEqualTo(fromTenToOne);
        assertThat(tenToZero).isEqualTo(fromTenToZero);
    }

    @Test
    void testReversedRanges() {
        Range tenToOne = Range.downToOne(10);
        Range tenToZero = Range.downToZero(10);
        Range fiftyToTen = Range.fromTo(50, 10);

        assertThat(tenToOne.stream())
                .containsExactlyElementsOf(Stream.iterate(10, i -> i >= 1, i -> i - 1).toList());

        assertThat(tenToZero.stream())
                .containsExactlyElementsOf(Stream.iterate(10, i -> i >= 0, i -> i - 1).toList());

        assertThat(fiftyToTen.stream())
                .containsExactlyElementsOf(Stream.iterate(50, i -> i >= 10, i -> i - 1).toList());
    }

    @Test
    void testReversedRangesWithStep() {
        Range fiftyToTenStep5 = Range.fromToWithStep(50, 10, 5);

        assertThat(fiftyToTenStep5.stream())
                .containsExactlyElementsOf(Stream.iterate(50, i -> i >= 10, i -> i - 5).toList());
    }

    @Test
    void testReversedMethod() {
        Range oneToTen = Range.oneTo(10);
        Range tenToOne = Range.downToOne(10);

        assertThat(oneToTen).isEqualTo(tenToOne.reverse());
    }

}
