package com.rechit.rituals.util

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {

    fun getSorteredQuery(filter: RitualSortType): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM habits ")
        when (filter) {
            RitualSortType.START_TIME -> {
                simpleQuery.append("ORDER BY time(startTime) ASC")
            }
            RitualSortType.MINUTES_FOCUS -> {
                simpleQuery.append("ORDER BY minutesFocus ASC")
            }
            RitualSortType.TITLE_NAME -> {
                simpleQuery.append("ORDER BY title ASC")
            }
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}