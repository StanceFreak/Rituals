package com.rechit.rituals.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.rechit.rituals.R
import com.rechit.rituals.databinding.ActivityAddRitualBinding
import com.rechit.rituals.ui.ViewModelFactory
import com.rechit.rituals.ui.random.RandomRitualViewModel

class AddRitualActivity : AppCompatActivity() {

    private lateinit var viewModel: AddRitualViewModel
    private lateinit var binding: ActivityAddRitualBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddRitualBinding.inflate(layoutInflater)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(AddRitualViewModel::class.java)

//        viewModel.insertRitual()

        setContentView(binding.root)
    }

    fun addRitual() {
        binding.btnStartTime.setOnClickListener {
            val ritualTitle = binding.addEdTitle.text
            val ritualTimeInMinute = binding.addEdMinutesFocus.text
            val ritualPriorityLevel = binding.spPriorityLevel

            val level = resources.getStringArray(R.array.priority_level)


            if (ritualTitle.isNullOrBlank()) {
                Toast.makeText(
                    this@AddRitualActivity,
                    "Title cannot be empty!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (ritualTimeInMinute.isNullOrBlank()) {
                Toast.makeText(
                    this@AddRitualActivity,
                    "Please input time in minute!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            else {
                if (ritualPriorityLevel != null) {
                    val spAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, level)
                    ritualPriorityLevel.adapter = spAdapter

                    ritualPriorityLevel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                            TODO("Not yet implemented")
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            TODO("Not yet implemented")
                        }

                    }
                }
            }
        }
    }
}