package com.rechit.rituals.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rechit.rituals.R
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.random.RandomRitualViewModel

class DetailRitualActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailRitualViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ritual)
        setSupportActionBar(findViewById(R.id.toolbar))

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(DetailRitualViewModel::class.java)
    }
}