package com.rechit.rituals.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rechit.rituals.R
import com.rechit.rituals.databinding.ActivityRitualListBinding
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.add.AddRitualActivity
import com.rechit.rituals.ui.random.RandomRitualViewModel

class RitualListActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var viewModel: RitualListViewModel
    private val binding by lazy { ActivityRitualListBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setupRecycler()

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(RitualListViewModel::class.java)

        binding.fab.setOnClickListener {
            val i = Intent(this, AddRitualActivity::class.java)
            startActivity(i)
        }
    }

    fun setupRecycler() {
        val layoutContent = binding.layoutContent
        val recyclerRitual = layoutContent.rvRitual
        val ritualAdapter = RitualAdapter()
        recyclerRitual.apply {
            layoutManager = LinearLayoutManager(
                this@RitualListActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = ritualAdapter
            setHasFixedSize(true)
        }
    }
}