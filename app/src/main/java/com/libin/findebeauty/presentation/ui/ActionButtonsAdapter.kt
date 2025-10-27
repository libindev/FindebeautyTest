package com.libin.findebeauty.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.libin.findebeauty.databinding.ItemActionButtonBinding

import com.libin.findebeauty.domain.model.ActionButton

class ActionButtonsAdapter(private val items: List<ActionButton>) :
    RecyclerView.Adapter<ActionButtonsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemActionButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemActionButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ActionButton) {
            binding.actionButton = item
            binding.actionIcon.setImageResource(item.icon)
            binding.executePendingBindings()
        }
    }
}
