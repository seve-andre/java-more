package range.string;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringRangeTest {

    @Test
    void testAlphabet() {
        StringRange alphabet = StringRange.alphabet();

        assertThat(alphabet.stream())
                .containsAll(IntStream.rangeClosed('a', 'z').mapToObj(c -> String.valueOf((char) c)).toList());
    }

    @Test
    void testNarrowAlphabet() {
        StringRange aToD = StringRange.fromTo('a', 'd');

        assertThat(aToD.stream()).containsExactly("a", "b", "c", "d");
    }

    @Test
    void testAlphabetReversed() {
        StringRange alphabetReversed = StringRange.alphabet().reversed();

        assertThat(alphabetReversed.stream())
                .containsAll(IntStream.rangeClosed('z', 'a').mapToObj(c -> String.valueOf((char) c)).toList());
    }

    @Test
    void testNarrowAlphabetReversed() {
        StringRange hToB = StringRange.fromTo('h', 'b');

        assertThat(hToB.stream()).containsExactly("h", "g", "f", "e", "d", "c", "b");
    }

    @Test
    void testIntParameter() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> StringRange.fromTo((char) 1, (char) 10));

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> StringRange.fromTo((char) 96, (char) 110));

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> StringRange.fromTo((char) 110, (char) 125));
    }
}
