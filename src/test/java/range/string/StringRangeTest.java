package range.string;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class StringRangeTest {

    // TODO: check what happens if (char) number is passed as parameter

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
}
