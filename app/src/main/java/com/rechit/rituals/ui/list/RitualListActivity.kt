package com.rechit.rituals.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.rechit.rituals.R
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.random.RandomRitualViewModel

private lateinit var recycler: RecyclerView
private lateinit var viewModel: RitualListViewModel

class RitualListActivity : AppCompatActivity() {

    private lateinit var viewModel: RitualListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContentView(R.layout.activity_ritual_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(RitualListViewModel::class.java)

    }
}