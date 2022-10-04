package com.rechit.rituals.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery


@Dao
interface RitualDao {
    @RawQuery(observedEntities = [Ritual::class])
    fun getRituals(query: SupportSQLiteQuery): DataSource.Factory<Int, Ritual>

    @Query("SELECT * FROM rituals WHERE id=:ritualId")
    fun getRitualsById(ritualId: Int): LiveData<Ritual>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRitual(ritual: Ritual): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg ritual: Ritual)

    @Delete
    fun deleteRitual(ritual: Ritual)

    @Query("SELECT * FROM rituals WHERE priorityLevel=:level")
    fun getRandomRitualByPriorityLevel(level: String): LiveData<Ritual>

}