package com.libin.findebeauty.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.libin.findebeauty.databinding.ItemSalonBinding
import com.libin.findebeauty.domain.model.FeaturedSalon
import com.libin.findebeauty.util.loadAppImage


class TrendingSalonsAdapter(private val imageBaseUrl: String) :
    ListAdapter<FeaturedSalon, TrendingSalonsAdapter.ViewHolder>(TrendingSalonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSalonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), imageBaseUrl)
    }

    class ViewHolder(private val binding: ItemSalonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(salon: FeaturedSalon, imageBaseUrl: String) {
            binding.salonName.text = salon.salonName
            binding.salonAreaName.text = salon.areaName
            binding.salonRating.rating = salon.salonRatingSummary.toFloat()
            binding.salonRatingCount.text = buildString {
                append("(")
                append(salon.totalCount.toString())
                append(")")
            }
            val imageUrl = imageBaseUrl + salon.salonBanner
            binding.salonBanner.loadAppImage(imageUrl)
        }
    }
}

class TrendingSalonDiffCallback : DiffUtil.ItemCallback<FeaturedSalon>() {
    override fun areItemsTheSame(oldItem: FeaturedSalon, newItem: FeaturedSalon): Boolean {
        return oldItem.salonId == newItem.salonId
    }

    override fun areContentsTheSame(oldItem: FeaturedSalon, newItem: FeaturedSalon): Boolean {
        return oldItem == newItem
    }
}
