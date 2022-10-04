package com.rechit.rituals.ui.random

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rechit.rituals.R
import com.rechit.rituals.ui.ViewModelFactory

class RandomRitualActivity : AppCompatActivity() {

    private lateinit var viewModel: RandomRitualViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ritual_list)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(RandomRitualViewModel::class.java)
    }
}