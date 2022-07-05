package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntRangeSameParamsTest {

    @Test
    void testSameParams() {
        assertThat(IntRange.fromTo(1, 1).stream()).containsExactly(1);
        assertThat(IntRange.oneTo(1).stream()).containsExactly(1);
        assertThat(IntRange.zeroTo(0).stream()).containsExactly(0);
        assertThat(IntRange.downToOne(1).stream()).containsExactly(1);
        assertThat(IntRange.downToZero(0).stream()).containsExactly(0);
        assertThat(IntRange.evensFromTo(2, 2).stream()).containsExactly(2);
        assertThat(IntRange.oddsFromTo(1, 1).stream()).containsExactly(1);
    }
}
