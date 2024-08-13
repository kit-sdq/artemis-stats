/* Licensed under EPL-2.0 2023-2024. */
package edu.kit.kastel.sdq.scorestats.core.report;

import java.util.Collection;

/**
 * A report visitor describing a frequency of occurrence.
 *
 * @param <T> the element {@link #count} will be called with
 * @param <U> the elements {@link #count} returns
 *
 * @author Moritz Hertler
 * @version 1.0
 */
public interface ReportFrequencyVisitor<T, U> {
    Iterable<T> iterable(Report.ReportData data);

    /**
     * Returns the elements based of the current {@code value} to add to the
     * frequency.
     *
     * @return the elements to add to the frequency
     */
    Collection<U> count(T value);

    /**
     * The maximum value the frequency could be.
     *
     * @param data the data
     * @return the maximum value
     */
    int max(Report.ReportData data);
}
