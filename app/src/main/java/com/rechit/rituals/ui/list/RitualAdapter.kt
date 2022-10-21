package com.rechit.rituals.ui.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rechit.rituals.R
import com.rechit.rituals.data.Ritual
import com.rechit.rituals.databinding.ContentRitualBinding
import com.rechit.rituals.databinding.HabitItemBinding
import com.rechit.rituals.ui.detail.DetailRitualActivity
import com.rechit.rituals.util.Resource

class RitualAdapter : RecyclerView.Adapter<RitualAdapter.RitualViewHolder>() {

    private var ritualData = ArrayList<Ritual>()

    class RitualViewHolder(private val binding: HabitItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ritual: Ritual) {
            if (ritual.priorityLevel.equals(R.string.medium)) {
                binding.itemPriorityLevel.setBackgroundResource(R.drawable.ic_priority_medium)
            }
            if (ritual.priorityLevel.equals(R.string.low)) {
                binding.itemPriorityLevel.setBackgroundResource(R.drawable.ic_priority_low)
            } else {
                binding.itemPriorityLevel.setBackgroundResource(R.drawable.ic_priority_high)
            }
            binding.itemTvTitle.text = ritual.title
            binding.itemTvMinutes.text = ritual.minuteFocus
            binding.itemTvStartTime.text = ritual.startTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RitualViewHolder {
        val itemBinding = HabitItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RitualViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RitualViewHolder, position: Int) {
        val data = this.ritualData[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, DetailRitualActivity::class.java)
            i.putExtra(DetailRitualActivity.DETAIL_EXTRAS, data.id)
            holder.itemView.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return this.ritualData.size
    }

    private fun setData(ritualList: List<Ritual>) {
        this.ritualData.clear()
        this.ritualData.addAll(ritualList)
        notifyDataSetChanged()
    }

}