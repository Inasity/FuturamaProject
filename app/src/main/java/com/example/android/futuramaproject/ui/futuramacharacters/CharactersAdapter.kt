package com.example.android.futuramaproject.ui.futuramacharacters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.futuramaproject.databinding.ListItemCharacterBinding
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.ui.futuramaquotes.QuoteAdapter

class CharactersAdapter : ListAdapter<FuturamaCharacter, CharactersAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: ListItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(futuramaCharacter: FuturamaCharacter) {
            binding.character = futuramaCharacter
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemCharacterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CharactersAdapter.ViewHolder, position: Int) {
        val characterFeed = getItem(position)
        holder.bind(characterFeed)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FuturamaCharacter>() {
        override fun areItemsTheSame(oldItem: FuturamaCharacter, newItem: FuturamaCharacter)
        : Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FuturamaCharacter, newItem: FuturamaCharacter
        ): Boolean {
            return oldItem.Name == newItem.Name
        }
    }


}
