package com.rechit.rituals.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rechit.rituals.R
import com.rechit.rituals.databinding.ActivityDetailRitualBinding
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.random.RandomRitualViewModel

class DetailRitualActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailRitualViewModel
    private lateinit var binding: ActivityDetailRitualBinding

    companion object {
        const val DETAIL_EXTRAS = "detail_extras"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailRitualBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(DetailRitualViewModel::class.java)

        setupView()
    }

    private fun setupView() {

        val layout = binding.detailContentLayout

        val data = intent.extras?.getInt(DETAIL_EXTRAS)

        if (data != null) {
            viewModel.getRitualsById(data).observe(this) {
                layout.apply {
                    detailEdStartTime.setText(it.startTime)
                    detailEdTimeMinutes.setText(it.minuteFocus)
                }
            }
        }

    }
}