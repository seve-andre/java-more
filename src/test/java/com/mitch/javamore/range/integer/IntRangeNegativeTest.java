package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class IntRangeNegativeTest {

    @Test
    void testNegativeRange() {
        IntRange negativeRange = IntRange.fromTo(-3, 1);

        assertThat(negativeRange.stream())
                .containsAll(IntStream.rangeClosed(-3, 1).boxed().toList());
    }

    @Test
    void testNegativeExceptions() {
        assertThatIllegalStateException().isThrownBy(() -> IntRange.downToOne(-2));
        assertThatIllegalStateException().isThrownBy(() -> IntRange.downToZero(-2));
        assertThatIllegalStateException().isThrownBy(() -> IntRange.evensDownToZero(-2));
        assertThatIllegalStateException().isThrownBy(() -> IntRange.oddsDownToOne(-2));
    }
}
