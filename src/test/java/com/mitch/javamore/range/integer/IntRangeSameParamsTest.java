package com.mitch.javamore.range.integer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeSameParamsTest {

    @Test
    void testSameParams() {
        assertThat(Range.fromTo(1, 1).stream()).containsExactly(1);
        assertThat(Range.oneTo(1).stream()).containsExactly(1);
        assertThat(Range.zeroTo(0).stream()).containsExactly(0);
        assertThat(Range.downToOne(1).stream()).containsExactly(1);
        assertThat(Range.downToZero(0).stream()).containsExactly(0);
        assertThat(Range.evensFromTo(2, 2).stream()).containsExactly(2);
        assertThat(Range.oddsFromTo(1, 1).stream()).containsExactly(1);
    }
}
