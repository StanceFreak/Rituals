package com.rechit.rituals.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rechit.rituals.R
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.random.RandomRitualViewModel

class AddRitualActivity : AppCompatActivity() {

    private lateinit var viewModel: AddRitualViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ritual)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(AddRitualViewModel::class.java)
    }
}