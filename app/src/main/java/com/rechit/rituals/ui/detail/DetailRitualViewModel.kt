package com.rechit.rituals.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rechit.rituals.data.Ritual
import com.rechit.rituals.data.RitualRepository
import com.rechit.rituals.util.Resource
import kotlinx.coroutines.Dispatchers

class DetailRitualViewModel(private val ritualRepository: RitualRepository): ViewModel() {

    fun getRitualsById(ritualId: Int) : LiveData<Ritual> {
        return ritualRepository.getRitualsById(ritualId)
    }

}