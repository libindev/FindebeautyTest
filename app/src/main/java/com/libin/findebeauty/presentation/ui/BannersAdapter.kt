package com.libin.findebeauty.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.libin.findebeauty.databinding.ItemBannerBinding
import com.libin.findebeauty.domain.model.HomePageBanner
import com.libin.findebeauty.util.loadAppImage


class BannersAdapter(private val imageBaseUrl: String) :
    ListAdapter<HomePageBanner, BannersAdapter.ViewHolder>(BannerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), imageBaseUrl)
    }

    class ViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: HomePageBanner, imageBaseUrl: String) {
            val imageUrl = imageBaseUrl + banner.topBannerAndroid
            binding.bannerImage.loadAppImage(imageUrl)
        }
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<HomePageBanner>() {
    override fun areItemsTheSame(oldItem: HomePageBanner, newItem: HomePageBanner): Boolean {
        return oldItem.bannerId == newItem.bannerId
    }

    override fun areContentsTheSame(oldItem: HomePageBanner, newItem: HomePageBanner): Boolean {
        return oldItem == newItem
    }
}
