package com.rechit.rituals.util

/**
 * Used with the filter spinner in the habit list.
 */
enum class RitualSortType {
    /**
     * Ordered by the first start time.
     */
    START_TIME,

    /**
     * Ordered by the lowest minutes focus.
     */
    MINUTES_FOCUS,

    /**
     * Ordered by the alphabetical title name.
     */
    TITLE_NAME
}
