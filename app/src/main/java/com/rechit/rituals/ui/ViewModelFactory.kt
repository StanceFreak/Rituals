package com.rechit.rituals.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rechit.rituals.data.RitualRepository
import com.rechit.rituals.ui.add.AddRitualViewModel
import com.rechit.rituals.ui.detail.DetailRitualViewModel
import com.rechit.rituals.ui.list.RitualListViewModel
import com.rechit.rituals.ui.random.RandomRitualViewModel

class ViewModelFactory private constructor(private val ritualRepository: RitualRepository): ViewModelProvider.Factory{
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    RitualRepository.getInstance(context)
                )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(RitualListViewModel::class.java) -> {
                RitualListViewModel(ritualRepository) as T
            }
            modelClass.isAssignableFrom(AddRitualViewModel::class.java) -> {
                AddRitualViewModel(ritualRepository) as T
            }
            modelClass.isAssignableFrom(DetailRitualViewModel::class.java) -> {
                DetailRitualViewModel(ritualRepository) as T
            }
            modelClass.isAssignableFrom(RandomRitualViewModel::class.java) -> {
                RandomRitualViewModel(ritualRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

}