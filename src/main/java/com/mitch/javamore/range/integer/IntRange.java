package com.mitch.javamore.range.integer;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.stream.Stream;

/**
 * {@link IntRange} represents a range of integer values, that may have a step to skip certain values.
 *
 * <p>Usage examples:
 *  <ul>
 *      <li>IntRange.{@link #fromTo fromTo(1, 5)} produces range of [1, 2, 3, 4, 5]</li>
 *      <li>IntRange.{@link #fromTo fromTo(5, 1)} produces range of [5, 4, 3, 2, 1]</li>
 *      <li>IntRange.{@link #fromToWithStep fromToWithStep(1, 10, 3)} produces range of [1, 4, 7, 10]</li>
 *      <li>IntRange.{@link #evensFromTo evensFromTo(1, 10)} produces range of [2, 4, 6, 8, 10]</li>
 *      <li>IntRange.{@link #oddsFromTo  oddsFromTo(1, 10)} produces range of [1, 3, 5, 7, 9]</li>
 *      <li>IntRange.fromTo(1, 5).{@link #reverse reverse()} produces the same result as IntRange.{@link #fromTo fromTo(5, 1)}</li>
 *      <li>IntRange.fromTo(1, 5).{@link #stream stream()} produces a {@link Stream}{@code <Integer>} from IntRange [1, 2, 3, 4, 5]</li>
 *  </ul>
 * </p>
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

    /**
     * Creates {@link IntRange} with {@link #from} as start value and {@link #to} as final value. Both are included in the range.
     * <p>
     * If {@link #from} > {@link #to}, a descending order range will be created.
     * </p>
     * <p>
     * Usage examples:
     *      <ul>
     *          <li><pre>{@code IntRange.fromTo(1, 5)} produces range of [1, 2, 3, 4, 5]</li>
     *          <li><pre>{@code IntRange.fromTo(5, 1)} produces range of [5, 4, 3, 2, 1]</li>
     *      </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @return {@link IntRange} with step 1
     */
    public static IntRange fromTo(int from, int to) {
        if (from > to) {
            return new IntRange(from, to, -1);
        }

        return new IntRange(from, to, 1);
    }

    /**
     * Creates {@link IntRange} with 0 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.zeroTo(5)} produces range of [0, 1, 2, 3, 4, 5]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link IntRange} with step +1 or -1 depending on {@link #to} value
     */
    public static IntRange zeroTo(int to) {
        return fromTo(0, to);
    }

    /**
     * Creates {@link IntRange} with 1 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.oneTo(5)} produces range of [1, 2, 3, 4, 5]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link IntRange} with step +1 or -1 depending on {@link #to} value
     */
    public static IntRange oneTo(int to) {
        return fromTo(1, to);
    }

    /**
     * Creates {@link IntRange} with {@link #from} as start value and {@link #to} as final value with {@link #step} as step value. Both are included in the range.
     * <p>
     * If {@link #from} > {@link #to}, a descending order range will be created.
     * </p>
     * <p>
     * Usage examples:
     *      <ul>
     *          <li><pre>{@code IntRange.fromToWithStep(1, 15, 3)} produces range of [1, 4, 7, 10, 12, 15]</li>
     *          <li><pre>{@code IntRange.fromToWithStep(10, 1, 3)} produces range of [10, 7, 4, 1]</li>
     *      </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @param step to skip values
     * @return {@link IntRange} with {@link #step} value
     */
    public static IntRange fromToWithStep(int from, int to, int step) {
        if (from > to) {
            return new IntRange(from, to, -step);
        }

        return new IntRange(from, to, step);
    }

    /**
     * Creates {@link IntRange} with 0 as start value and {@link #to} as final value with {@link #step} as step value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.zeroToWithStep(10, 4)} produces range of [0, 4, 8]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @param step to skip values
     * @return {@link IntRange} with {@link #step} value
     */
    public static IntRange zeroToWithStep(int to, int step) {
        return fromToWithStep(0, to, step);
    }

    /**
     * Creates {@link IntRange} with 1 as start value and {@link #to} as final value with {@link #step} as step value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.oneToWithStep(10, 4)} produces range of [1, 5, 9]</li>
     *  </ul>
     * </p>
     * @param to final value of the range (included)
     * @param step to skip values
     * @return {@link IntRange} with {@link #step} value
     */
    public static IntRange oneToWithStep(int to, int step) {
        return fromToWithStep(1, to, step);
    }

    /**
     * Creates {@link IntRange} with {@link #from} as start value and 1 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.downToOne(5)} produces range of [5, 4, 3, 2, 1]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @return {@link IntRange} with step -1
     */
    public static IntRange downToOne(int from) {
        if (from <= 0) {
            throw new IllegalStateException("from must be >= 1");
        } else if (from == 1) {
            return oneTo(1);
        }

        return new IntRange(from, 1, -1);
    }

    /**
     * Creates {@link IntRange} with {@link #from} as start value and 0 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.downToZero(5)} produces range of [5, 4, 3, 2, 1, 0]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @return {@link IntRange} with step -1
     */
    public static IntRange downToZero(int from) {
        if (from < 0) {
            throw new IllegalStateException("from must be >= 0");
        } else if (from == 0) {
            return zeroTo(0);
        }

        return new IntRange(from, 0, -1);
    }

    /**
     * Creates evens-only {@link IntRange} with {@link #from} as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.evensFromTo(1, 10)} produces range of [2, 4, 6, 8, 10]</li>
     *      <li><pre>{@code IntRange.evensFromTo(10, 1)} produces range of [10, 8, 6, 4, 2]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @return {@link IntRange} with step 2 if to > from else -2
     */
    public static IntRange evensFromTo(int from, int to) {
        if (from % 2 != 0) {
            if (from > to) {
                from--;
            } else if (from == to) {
                throw new IllegalStateException("no possible even values between " + from + " and " + to);
            } else {
                from++;
            }
        } else if (from == to) {
            return fromTo(from, to);
        }

        return new IntRange(from, to, to > from ? 2 : -2);
    }

    /**
     * Creates evens-only {@link IntRange} with 0 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.evensFromZeroTo(10)} produces range of [0, 2, 4, 6, 8, 10]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link IntRange} with step 2
     */
    public static IntRange evensFromZeroTo(int to) {
        return evensFromTo(0, to);
    }

    /**
     * Creates evens-only {@link IntRange} with {@link #from} as start value and 0 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.evensDownToZero(10)} produces range of [10, 8, 6, 4, 2, 0]</li>
     *  </ul>
     * </p>
     *
     * @return {@link IntRange} with step -2
     */
    public static IntRange evensDownToZero(int from) {
        if (from < 0) {
            throw new IllegalStateException("from must be >= 0");
        }

        if (from % 2 != 0) {
            from++;
        }

        return new IntRange(from, 0, -2);
    }

    /**
     * Creates odds-only {@link IntRange} with {@link #from} as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.oddsFromTo(1, 10)} produces range of [1, 3, 5, 7, 9]</li>
     *      <li><pre>{@code IntRange.oddsFromTo(10, 1)} produces range of [9, 7, 5, 3, 1]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @return {@link IntRange} with step 2 if to > from else -2
     */
    public static IntRange oddsFromTo(int from, int to) {
        if (from % 2 == 0) {
            if (from > to) {
                from--;
            } else if (from == to) {
                throw new IllegalStateException("no possible even values between " + from + " and " + to);
            } else {
                from++;
            }
        } else if (from == to) {
            return fromTo(from, to);
        }

        return new IntRange(from, to, to > from ? 2 : -2);
    }

    /**
     * Creates odds-only {@link IntRange} with 1 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.oddsFromOneTo(10)} produces range of [1, 3, 5, 7, 9]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link IntRange} with step 2
     */
    public static IntRange oddsFromOneTo(int to) {
        return oddsFromTo(1, to);
    }

    /**
     * Creates odds-only {@link IntRange} with {@link #from} as start value and 1 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.oddsDownToOne(10)} produces range of [9, 7, 5, 3, 1]</li>
     *  </ul>
     * </p>
     *
     * @return {@link IntRange} with step -2
     */
    public static IntRange oddsDownToOne(int from) {
        if (from <= 0) {
            throw new IllegalStateException("from must be >= 1");
        }

        if (from % 2 == 0) {
            from++;
        }

        return new IntRange(from, 1, -2);
    }

    /**
     * Usage examples:
     * <pre>
     * {@code
     *  Stream<Integer> oneToTenStream = IntRange.oneTo(10).stream();
     * }
     * </pre>
     *
     * @return {@link Stream}{@code <Integer>} with all values of the range
     */
    public Stream<Integer> stream() {
        if (from > to) {
            return Stream.iterate(from, i -> i >= to, i -> i + step);
        }

        return Stream.iterate(from, i -> i <= to, i -> i + step);
    }

    /**
     * Reverses current IntRange, resulting in changing start value and final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code IntRange.from(1, 4).reverse()} produces range of [4, 3, 2, 1]</li>
     *  </ul>
     * </p>
     *
     * @return {@link IntRange} reversed
     */
    public IntRange reverse() {
        return IntRange.fromToWithStep(to, from, -step);
    }
}
