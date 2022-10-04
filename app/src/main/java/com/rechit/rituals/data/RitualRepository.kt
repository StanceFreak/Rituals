package com.rechit.rituals.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rechit.rituals.util.RitualSortType
import com.rechit.rituals.util.SortUtils
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class RitualRepository(private val ritualDao: RitualDao, private val executor: ExecutorService) {

    companion object {

        @Volatile
        private var instance: RitualRepository? = null

        fun getInstance(context: Context): RitualRepository {
            return instance ?: synchronized(this) {
                if(instance == null) {
                    val database = RitualDatabase.getInstance(context)
                    instance = RitualRepository(
                        database.ritualDao(),
                        Executors.newSingleThreadExecutor()
                    )
                }
                return instance as RitualRepository
            }
        }

    }

    fun getRituals(filter: RitualSortType): LiveData<PagedList<Ritual>> {
        val sortableQuery = ritualDao.getRituals(SortUtils.getSorteredQuery(filter))
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(30)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(sortableQuery, config).build()
    }

    fun getRitualsById(ritualId: Int): LiveData<Ritual> {
        return ritualDao.getRitualsById(ritualId)
    }

    fun insertRitual(newRitual: Ritual): Long {
        return ritualDao.insertRitual(newRitual)
    }

    fun deleteRitual(ritual: Ritual) {
        executor.execute {
            ritualDao.deleteRitual(ritual)
        }
    }

    fun getRandomRitualByPriorityLevel(level: String): LiveData<Ritual> {
        return ritualDao.getRandomRitualByPriorityLevel(level)
    }
}