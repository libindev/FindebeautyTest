package com.libin.findebeauty.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.libin.findebeauty.databinding.ItemSalonBinding
import com.libin.findebeauty.domain.model.NearBySalon
import com.libin.findebeauty.util.loadAppImage


class NearbySalonsAdapter(private val imageBaseUrl: String) :
    ListAdapter<NearBySalon, NearbySalonsAdapter.ViewHolder>(NearbySalonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSalonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), imageBaseUrl)
    }

    class ViewHolder(private val binding: ItemSalonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(salon: NearBySalon, imageBaseUrl: String) {
            binding.salonName.text = salon.salonName
            binding.salonRating.rating = salon.salonRatingSummary.toFloat()
            binding.salonRatingCount.text = buildString {
                append("(")
                append(salon.count.toString())
                append(")")
            }
            binding.salonAreaName.text = salon.areaName
            val imageUrl = imageBaseUrl + salon.salonBanner
            binding.salonBanner.loadAppImage(imageUrl)

        }
    }
}

class NearbySalonDiffCallback : DiffUtil.ItemCallback<NearBySalon>() {
    override fun areItemsTheSame(oldItem: NearBySalon, newItem: NearBySalon): Boolean {
        return oldItem.salonId == newItem.salonId
    }

    override fun areContentsTheSame(oldItem: NearBySalon, newItem: NearBySalon): Boolean {
        return oldItem == newItem
    }
}
