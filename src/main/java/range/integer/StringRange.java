package range.integer;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringRange {
    private final char start;
    private final char end;

    public StringRange(char start, char end) {
        this.start = start;
        this.end = end;
    }

    public static StringRange fromTo(char start, char end) {
        return new StringRange(start, end);
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
