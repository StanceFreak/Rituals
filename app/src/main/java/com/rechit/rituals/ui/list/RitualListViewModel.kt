package com.rechit.rituals.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.paging.PagedList
import com.rechit.rituals.data.Ritual
import com.rechit.rituals.data.RitualRepository
import com.rechit.rituals.util.Resource
import com.rechit.rituals.util.RitualSortType
import kotlinx.coroutines.Dispatchers

class RitualListViewModel(private val ritualRepository: RitualRepository): ViewModel() {
//    fun getRituals(filter: RitualSortType) {
//        liveData(Dispatchers.IO) {
//            emit(Resource.loading(data = null))
//            try {
//                emit(Resource.success(data = ritualRepository.getRituals(filter)))
//            } catch (e: Exception) {
//                emit(Resource.error(data = null, message = e.message ?: "Error Occured!"))
//            }
//        }
//    }
    fun getRitualsList(filter: RitualSortType) : LiveData<PagedList<Ritual>> {
        return ritualRepository.getRituals(filter)
    }
}