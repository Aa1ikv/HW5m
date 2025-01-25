package com.example.lesson4.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson4.R
import com.example.lesson4.data.model.Character
import com.example.lesson4.databinding.ItemCharacterBinding

class CartoonAdapter : ListAdapter<Character, CartoonAdapter.CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character?) {
            character?.let {
                binding.tvName.text = it.name
                binding.tvStatus.text = "${it.status} - ${it.species}"
                binding.tvLocation.text = it.location?.name ?: "Unknown"
                binding.tvFirstSeen.text = it.origin?.name ?: "Unknown"

                // Load image using Glide
                Glide.with(binding.ivAvatar.context)
                    .load(it.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivAvatar)

                // Set status indicator color
                val statusColor = when (it.status?.lowercase()) {
                    "alive" -> R.color.green
                    "dead" -> R.color.red
                    else -> R.color.gray
                }
                binding.viewStatusIndicator.setBackgroundResource(statusColor)
            }
        }
    }

    class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem == newItem
    }
}
