package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntRangeSimpleTest {

    // TODO: check negative ranges and ranges with "from" and "to" with same value

    @Test
    void testProduceSameResult() {
        IntRange oneToTen = IntRange.oneTo(10);
        IntRange fromOneToTen = IntRange.fromTo(1, 10);

        IntRange zeroToTen = IntRange.zeroTo(10);
        IntRange fromZeroToTen = IntRange.fromTo(0, 10);

        assertThat(oneToTen).isEqualTo(fromOneToTen);
        assertThat(zeroToTen).isEqualTo(fromZeroToTen);
    }

    @Test
    void testProduceSameResultWithStep() {
        IntRange oneToTenStep3 = IntRange.oneToWithStep(10, 3);
        IntRange fromOneToTenStep3 = IntRange.fromToWithStep(1, 10, 3);

        IntRange zeroToTenStep3 = IntRange.zeroToWithStep(10, 3);
        IntRange fromZeroToTenStep3 = IntRange.fromToWithStep(0, 10, 3);

        assertThat(oneToTenStep3).isEqualTo(fromOneToTenStep3);
        assertThat(zeroToTenStep3).isEqualTo(fromZeroToTenStep3);
    }

    @Test
    void testSimpleRanges() {
        IntRange oneToTen = IntRange.oneTo(10);
        IntRange zeroToTen = IntRange.zeroTo(10);
        IntRange fourToTen = IntRange.fromTo(4, 10);

        assertThat(oneToTen.stream())
                .containsAll(IntStream.rangeClosed(1, 10).boxed().toList());

        assertThat(zeroToTen.stream())
                .containsAll(IntStream.rangeClosed(0, 10).boxed().toList());

        assertThat(fourToTen.stream())
                .containsAll(IntStream.rangeClosed(4, 10).boxed().toList());
    }

    @Test
    void testRangeWithStep() {
        IntRange oneToThirtyStep5 = IntRange.oneToWithStep(30, 5);
        IntRange zeroToOneHundredStep10 = IntRange.zeroToWithStep(100, 5);
        IntRange fromOneToFifteenStep4 = IntRange.fromToWithStep(1, 15, 4);

        assertThat(oneToThirtyStep5.stream())
                .containsAll(Stream.iterate(1, i -> i <= 30, i -> i + 5).toList());

        assertThat(zeroToOneHundredStep10.stream())
                .containsAll(Stream.iterate(0, i -> i <= 100, i -> i + 10).toList());

        assertThat(fromOneToFifteenStep4.stream())
                .containsAll(Stream.iterate(1, i -> i <= 15, i -> i + 4).toList());
    }
}
