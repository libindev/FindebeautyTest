package com.libin.findebeauty.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.libin.findebeauty.databinding.ItemTopServiceBinding
import com.libin.findebeauty.domain.model.TopService
import com.libin.findebeauty.util.loadAppImage


class TopServicesAdapter(private val imageBaseUrl: String) :
    ListAdapter<TopService, TopServicesAdapter.ViewHolder>(TopServiceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemTopServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), imageBaseUrl)
    }

    class ViewHolder(private val binding: ItemTopServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(service: TopService, imageBaseUrl: String) {
            binding.service = service
            val imageUrl = imageBaseUrl + service.serviceImage
            binding.serviceImage.loadAppImage(imageUrl)
            binding.executePendingBindings()
        }
    }
}

class TopServiceDiffCallback : DiffUtil.ItemCallback<TopService>() {
    override fun areItemsTheSame(oldItem: TopService, newItem: TopService): Boolean {
        return oldItem.topServiceId == newItem.topServiceId
    }

    override fun areContentsTheSame(oldItem: TopService, newItem: TopService): Boolean {
        return oldItem == newItem
    }
}
