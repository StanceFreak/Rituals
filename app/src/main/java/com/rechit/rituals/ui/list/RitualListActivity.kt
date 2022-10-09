package com.rechit.rituals.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.rechit.rituals.R
import com.rechit.rituals.databinding.ActivityRitualListBinding
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.random.RandomRitualViewModel

class RitualListActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var viewModel: RitualListViewModel
    private val binding by lazy { ActivityRitualListBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(RitualListViewModel::class.java)

    }
}