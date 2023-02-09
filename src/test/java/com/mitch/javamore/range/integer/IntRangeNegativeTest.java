package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RangeNegativeTest {

    @Test
    void testNegativeRange() {
        Range negativeRange = Range.fromTo(-3, 1);

        assertThat(negativeRange.stream())
                .containsAll(IntStream.rangeClosed(-3, 1).boxed().toList());
    }

    @Test
    void testNegativeExceptions() {
        assertThatIllegalArgumentException().isThrownBy(() -> Range.downToOne(-2));
        assertThatIllegalArgumentException().isThrownBy(() -> Range.downToZero(-2));
        assertThatIllegalArgumentException().isThrownBy(() -> Range.evensDownToZero(-2));
        assertThatIllegalArgumentException().isThrownBy(() -> Range.oddsDownToOne(-2));
    }
}
