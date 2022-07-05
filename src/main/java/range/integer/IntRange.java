package range.integer;

import lombok.EqualsAndHashCode;

import java.util.stream.Stream;

/**
 *
 */
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

        return new IntRange(from, 1,-2);
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
