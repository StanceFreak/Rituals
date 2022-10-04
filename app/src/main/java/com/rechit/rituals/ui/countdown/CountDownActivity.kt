package com.rechit.rituals.ui.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rechit.rituals.R
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.random.RandomRitualViewModel

class CountDownActivity : AppCompatActivity() {

    private lateinit var viewModel: CountDownViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        supportActionBar?.title = "Count Down"

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(CountDownViewModel::class.java)
    }
}