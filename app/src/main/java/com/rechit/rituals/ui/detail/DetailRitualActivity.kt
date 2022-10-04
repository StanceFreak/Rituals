package com.rechit.rituals.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rechit.rituals.R

class DetailRitualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ritual)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}