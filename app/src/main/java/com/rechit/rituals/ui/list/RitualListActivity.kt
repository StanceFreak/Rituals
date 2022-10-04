package com.rechit.rituals.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.rechit.rituals.R

private lateinit var recycler: RecyclerView
private lateinit var viewModel: RitualListViewModel

class RitualListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ritual_list)
        setSupportActionBar(findViewById(R.id.toolbar))

    }
}