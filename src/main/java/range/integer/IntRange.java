package range.integer;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.stream.Stream;

/**
 * {@link IntRange} represents a range of integer values, that may have a step to skip certain values.
 *
 * <p>Usage examples:
 *  <ul>
 *      <li>{@link IntRange#fromTo IntRange.fromTo(1, 5)} produces range of [1, 2, 3, 4, 5]</li>
 *      <li>{@link IntRange#fromTo IntRange.fromTo(5, 1)} produces range of [5, 4, 3, 2, 1]</li>
 *      <li>{@link IntRange#fromToWithStep IntRange.fromToWithStep(1, 10, 3)} produces range of [1, 4, 7, 10]</li>
 *      <li>{@link IntRange#evensFromTo IntRange.evensFromTo(1, 10)} produces range of [2, 4, 6, 8, 10]</li>
 *      <li>{@link IntRange#oddsFromTo  IntRange.oddsFromTo(1, 10)} produces range of [1, 3, 5, 7, 9]</li>
 *      <li>{@link IntRange#reverse() IntRange.fromTo(1, 5).reverse()} produces the same result as {@link IntRange#fromTo IntRange.fromTo(5, 1)}</li>
 *      <li>{@link IntRange#stream IntRange.fromTo(1, 5).stream()} produces a {@link Stream}{@code <Integer>} from IntRange [1, 2, 3, 4, 5]</li>
 *  </ul>
 */
@ToString
@EqualsAndHashCode
public final class IntRange {
    private final int from;
    private final int to;
    private final int step;

    private IntRange(int from, int to, int step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public static IntRange fromTo(int from, int to) {
        if (from > to) {
            return new IntRange(from, to, -1);
        }

        return new IntRange(from, to, 1);
    }

    public static IntRange zeroTo(int to) {
        return new IntRange(0, to, 1);
    }

    public static IntRange oneTo(int to) {
        return new IntRange(1, to, 1);
    }

    public static IntRange fromToWithStep(int from, int to, int step) {
        if (from > to) {
            return new IntRange(from, to, -step);
        }

        return new IntRange(from, to, step);
    }

    public static IntRange zeroToWithStep(int to, int step) {
        return new IntRange(0, to, step);
    }

    public static IntRange oneToWithStep(int to, int step) {
        return new IntRange(1, to, step);
    }

    public static IntRange downToOne(int from) {
        return new IntRange(from, 1, -1);
    }

    public static IntRange downToZero(int from) {
        return new IntRange(from, 0, -1);
    }

    public static IntRange evensFromTo(int from, int to) {
        if (from % 2 != 0) {
            if (from > to) {
                from--;
            } else {
                from++;
            }
        }

        return new IntRange(from, to, to > from ? 2 : -2);
    }

    public static IntRange evensFromZeroTo(int to) {
        return new IntRange(0, to, 2);
    }

    public static IntRange evensDownToZero(int from) {
        if (from % 2 != 0) {
            from++;
        }

        return new IntRange(from, 0, -2);
    }

    public static IntRange oddsFromTo(int from, int to) {
        if (from % 2 == 0) {
            if (from > to) {
                from--;
            } else {
                from++;
            }
        }

        return new IntRange(from, to, to > from ? 2 : -2);
    }

    public static IntRange oddsDownToOne(int from) {
        if (from % 2 == 0) {
            from++;
        }

        return new IntRange(from, 1, -2);
    }

    public static IntRange oddsFromOneTo(int to) {
        return new IntRange(1, to, 2);
    }

    public Stream<Integer> stream() {
        if (from > to) {
            return Stream.iterate(from, i -> i >= to, i -> i + step);
        }

        return Stream.iterate(from, i -> i <= to, i -> i + step);
    }

    public IntRange reverse() {
        return IntRange.fromToWithStep(to, from, -step);
    }
}
