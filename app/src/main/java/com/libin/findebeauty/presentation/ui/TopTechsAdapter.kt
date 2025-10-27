package com.libin.findebeauty.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.libin.findebeauty.databinding.ItemTopTechBinding
import com.libin.findebeauty.domain.model.TopTech
import com.libin.findebeauty.util.loadAppImage

class TopTechsAdapter(private val imageBaseUrl: String) :
    ListAdapter<TopTech, TopTechsAdapter.ViewHolder>(TopTechDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTopTechBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), imageBaseUrl)
    }

    class ViewHolder(private val binding: ItemTopTechBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tech: TopTech, imageBaseUrl: String) {
            binding.topTech = tech
            binding.techImage.loadAppImage(imageBaseUrl + tech.empEmployeeProfileImg)
            binding.executePendingBindings()
        }
    }
}

class TopTechDiffCallback : DiffUtil.ItemCallback<TopTech>() {
    override fun areItemsTheSame(oldItem: TopTech, newItem: TopTech): Boolean {
        return oldItem.techId == newItem.techId
    }

    override fun areContentsTheSame(oldItem: TopTech, newItem: TopTech): Boolean {
        return oldItem == newItem
    }
}
