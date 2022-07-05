package range.string;


import range.integer.IntRange;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// TODO: support multi-language alphabet - NOW ENGLISH ONLY

public final class StringRange {
    private final char start;
    private final char end;

    private StringRange(char start, char end) {
        List<Integer> uppercaseAscii = IntRange.fromTo(65, 90).stream().toList();
        List<Integer> lowercaseAscii = IntRange.fromTo(97, 122).stream().toList();

        if (
                (!uppercaseAscii.contains((int) start) || !uppercaseAscii.contains((int) end))
                && (!lowercaseAscii.contains((int) start) || !lowercaseAscii.contains((int) end))
        ) {
            throw new IllegalStateException("StringRange can only contain letters from the alphabet");
        }

        this.start = start;
        this.end = end;
    }

    public static StringRange fromTo(char start, char end) {
        return new StringRange(start, end);
    }

    public static StringRange alphabet() {
        return new StringRange('a', 'z');
    }

    public StringRange reversed() {
        return new StringRange(end, start);
    }

    public Stream<String> stream() {
        if (start > end) {
            return IntStream.iterate(start, i -> i - 1)
                    .limit(start - end + 1L)
                    .mapToObj(i -> (char) i)
                    .map(String::valueOf);
        }

        return IntStream.rangeClosed(start, end)
                .mapToObj(i -> (char) i)
                .map(String::valueOf);
    }
}
