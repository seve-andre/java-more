package com.mitch.javamore.range.integer;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * {@link Range} represents a range of integer values, that may have a step to skip certain values.
 *
 * <p>Usage examples:
 *  <ul>
 *      <li>Range.{@link #fromTo fromTo(1, 5)} produces range of [1, 2, 3, 4, 5]</li>
 *      <li>Range.{@link #fromTo fromTo(5, 1)} produces range of [5, 4, 3, 2, 1]</li>
 *      <li>Range.{@link #fromToWithStep fromToWithStep(1, 10, 3)} produces range of [1, 4, 7, 10]</li>
 *      <li>Range.{@link #evensFromTo evensFromTo(1, 10)} produces range of [2, 4, 6, 8, 10]</li>
 *      <li>Range.{@link #oddsFromTo  oddsFromTo(1, 10)} produces range of [1, 3, 5, 7, 9]</li>
 *      <li>Range.fromTo(1, 5).{@link #reverse reverse()} produces the same result as Range.{@link #fromTo fromTo(5, 1)}</li>
 *      <li>Range.fromTo(1, 5).{@link #stream stream()} produces a {@link Stream}{@code <Integer>} from Range [1, 2, 3, 4, 5]</li>
 *  </ul>
 * </p>
 */
@ToString
@EqualsAndHashCode
public final class Range {
    private final int from;
    private final int to;
    private final int step;

    private Range(int from, int to, int step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    /**
     * Creates {@link Range} with {@link #from} as start value and {@link #to} as final value. Both are included in the range.
     * <p>
     * If {@link #from} > {@link #to}, a descending order range will be created.
     * </p>
     * <p>
     * Usage examples:
     *      <ul>
     *          <li><pre>{@code Range.fromTo(1, 5)} produces range of [1, 2, 3, 4, 5]</li>
     *          <li><pre>{@code Range.fromTo(5, 1)} produces range of [5, 4, 3, 2, 1]</li>
     *      </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @return {@link Range} with step 1
     */
    public static Range fromTo(int from, int to) {
        return fromToWithStep(from, to, 1);
    }

    /**
     * Creates {@link Range} with 0 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.zeroTo(5)} produces range of [0, 1, 2, 3, 4, 5]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link Range} with step +1 or -1 depending on {@link #to} value
     */
    public static Range zeroTo(int to) {
        return fromTo(0, to);
    }

    /**
     * Creates {@link Range} with 1 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.oneTo(5)} produces range of [1, 2, 3, 4, 5]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link Range} with step +1 or -1 depending on {@link #to} value
     */
    public static Range oneTo(int to) {
        return fromTo(1, to);
    }

    /**
     * Creates {@link Range} with {@link #from} as start value and {@link #to} as final value with {@link #step} as step value. Both are included in the range.
     * <p>
     * If {@link #from} > {@link #to}, a descending order range will be created.
     * </p>
     * <p>
     * Usage examples:
     *      <ul>
     *          <li><pre>{@code Range.fromToWithStep(1, 15, 3)} produces range of [1, 4, 7, 10, 12, 15]</li>
     *          <li><pre>{@code Range.fromToWithStep(10, 1, 3)} produces range of [10, 7, 4, 1]</li>
     *      </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @param step to skip values
     * @return {@link Range} with {@link #step} value
     */
    public static Range fromToWithStep(int from, int to, int step) {
        if (
                (from == to && step < 0)
                        || (from > to && step > 0)
        ) {
            step = -step;
        }

        return new Range(from, to, step);
    }

    /**
     * Creates {@link Range} with 0 as start value and {@link #to} as final value with {@link #step} as step value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.zeroToWithStep(10, 4)} produces range of [0, 4, 8]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @param step to skip values
     * @return {@link Range} with {@link #step} value
     */
    public static Range zeroToWithStep(int to, int step) {
        return fromToWithStep(0, to, step);
    }

    /**
     * Creates {@link Range} with 1 as start value and {@link #to} as final value with {@link #step} as step value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.oneToWithStep(10, 4)} produces range of [1, 5, 9]</li>
     *  </ul>
     * </p>
     * @param to final value of the range (included)
     * @param step to skip values
     * @return {@link Range} with {@link #step} value
     */
    public static Range oneToWithStep(int to, int step) {
        return fromToWithStep(1, to, step);
    }

    /**
     * Creates {@link Range} with {@link #from} as start value and 1 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.downToOne(5)} produces range of [5, 4, 3, 2, 1]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @return {@link Range} with step -1
     */
    public static Range downToOne(int from) {
        checkArgument(from >= 1, "from must be >= 1");
        return fromToWithStep(from, 1, -1);
    }

    /**
     * Creates {@link Range} with {@link #from} as start value and 0 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.downToZero(5)} produces range of [5, 4, 3, 2, 1, 0]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @return {@link Range} with step -1
     */
    public static Range downToZero(int from) {
        checkArgument(from >= 0, "from must be >= 0");
        return fromToWithStep(from, 0, -1);
    }

    /**
     * Creates evens-only {@link Range} with {@link #from} as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.evensFromTo(1, 10)} produces range of [2, 4, 6, 8, 10]</li>
     *      <li><pre>{@code Range.evensFromTo(10, 1)} produces range of [10, 8, 6, 4, 2]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @return {@link Range} with step 2 if to > from else -2
     */
    public static Range evensFromTo(int from, int to) {
        if (from % 2 != 0) {
            if (from > to) {
                from--;
            } else if (from == to) {
                throw new IllegalStateException("no possible even values between " + from + " and " + to);
            } else {
                from++;
            }
        }

        return fromToWithStep(from, to, to > from ? 2 : -2);
    }

    /**
     * Creates evens-only {@link Range} with 0 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.evensFromZeroTo(10)} produces range of [0, 2, 4, 6, 8, 10]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link Range} with step 2
     */
    public static Range evensFromZeroTo(int to) {
        return evensFromTo(0, to);
    }

    /**
     * Creates evens-only {@link Range} with {@link #from} as start value and 0 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.evensDownToZero(10)} produces range of [10, 8, 6, 4, 2, 0]</li>
     *  </ul>
     * </p>
     *
     * @return {@link Range} with step -2
     */
    public static Range evensDownToZero(int from) {
        checkArgument(from >= 0, "from must be >= 0");
        return evensFromTo(from, 0);
    }

    /**
     * Creates odds-only {@link Range} with {@link #from} as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.oddsFromTo(1, 10)} produces range of [1, 3, 5, 7, 9]</li>
     *      <li><pre>{@code Range.oddsFromTo(10, 1)} produces range of [9, 7, 5, 3, 1]</li>
     *  </ul>
     * </p>
     *
     * @param from start value of the range (included)
     * @param to final value of the range (included)
     * @return {@link Range} with step 2 if to > from else -2
     */
    public static Range oddsFromTo(int from, int to) {
        if (from % 2 == 0) {
            if (from > to) {
                from--;
            } else if (from == to) {
                // Range.oddsFromTo(2, 2) -> error or should return empty?
                throw new IllegalStateException("no possible even values between " + from + " and " + to);
            } else {
                from++;
            }
        }

        return fromToWithStep(from, to, to > from ? 2 : -2);
    }

    /**
     * Creates odds-only {@link Range} with 1 as start value and {@link #to} as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.oddsFromOneTo(10)} produces range of [1, 3, 5, 7, 9]</li>
     *  </ul>
     * </p>
     *
     * @param to final value of the range (included)
     * @return {@link Range} with step 2
     */
    public static Range oddsFromOneTo(int to) {
        return oddsFromTo(1, to);
    }

    /**
     * Creates odds-only {@link Range} with {@link #from} as start value and 1 as final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.oddsDownToOne(10)} produces range of [9, 7, 5, 3, 1]</li>
     *  </ul>
     * </p>
     *
     * @return {@link Range} with step -2
     */
    public static Range oddsDownToOne(int from) {
        checkArgument(from >= 1, "from must be >= 1");
        return oddsFromTo(from, 1);
    }

    /**
     * Usage examples:
     * <pre>
     * {@code
     *  Stream<Integer> oneToTenStream = Range.oneTo(10).stream();
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
     * Reverses current Range, resulting in changing start value and final value.
     * <p>
     * Usage examples:
     *  <ul>
     *      <li><pre>{@code Range.from(1, 4).reverse()} produces range of [4, 3, 2, 1]</li>
     *  </ul>
     * </p>
     *
     * @return {@link Range} reversed
     */
    public Range reverse() {
        return fromToWithStep(to, from, -step);
    }
}
