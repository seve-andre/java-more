package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RangeForwardTest {

    @Test
    void testProduceSameResult() {
        Range oneToTen = Range.oneTo(10);
        Range fromOneToTen = Range.fromTo(1, 10);

        Range zeroToTen = Range.zeroTo(10);
        Range fromZeroToTen = Range.fromTo(0, 10);

        assertThat(oneToTen).isEqualTo(fromOneToTen);
        assertThat(zeroToTen).isEqualTo(fromZeroToTen);
    }

    @Test
    void testProduceSameResultWithStep() {
        Range oneToTenStep3 = Range.oneToWithStep(10, 3);
        Range fromOneToTenStep3 = Range.fromToWithStep(1, 10, 3);

        Range zeroToTenStep3 = Range.zeroToWithStep(10, 3);
        Range fromZeroToTenStep3 = Range.fromToWithStep(0, 10, 3);

        assertThat(oneToTenStep3).isEqualTo(fromOneToTenStep3);
        assertThat(zeroToTenStep3).isEqualTo(fromZeroToTenStep3);
    }

    @Test
    void testForwardRanges() {
        Range oneToTen = Range.oneTo(10);
        Range zeroToTen = Range.zeroTo(10);
        Range fourToTen = Range.fromTo(4, 10);

        assertThat(oneToTen.stream())
                .containsExactlyElementsOf(IntStream.rangeClosed(1, 10).boxed().toList());

        assertThat(zeroToTen.stream())
                .containsExactlyElementsOf(IntStream.rangeClosed(0, 10).boxed().toList());

        assertThat(fourToTen.stream())
                .containsExactlyElementsOf(IntStream.rangeClosed(4, 10).boxed().toList());
    }

    @Test
    void testForwardRangesWithStep() {
        Range oneToThirtyStep5 = Range.oneToWithStep(30, 5);
        Range zeroToOneHundredStep10 = Range.zeroToWithStep(100, 10);
        Range fromOneToFifteenStep4 = Range.fromToWithStep(1, 15, 4);

        assertThat(oneToThirtyStep5.stream())
                .containsExactlyElementsOf(Stream.iterate(1, i -> i <= 30, i -> i + 5).toList());

        assertThat(zeroToOneHundredStep10.stream())
                .containsExactlyElementsOf(Stream.iterate(0, i -> i <= 100, i -> i + 10).toList());

        assertThat(fromOneToFifteenStep4.stream())
                .containsExactlyElementsOf(Stream.iterate(1, i -> i <= 15, i -> i + 4).toList());
    }
}
