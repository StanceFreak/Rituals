package com.rechit.rituals.ui.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rechit.rituals.R

class CountDownActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        supportActionBar?.title = "Count Down"
    }
}