package com.example.android.futuramaproject.ui.futuramaquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.futuramaproject.databinding.ListItemQuoteBinding
import com.example.android.futuramaproject.network.data.CharQuote

class QuoteAdapter: ListAdapter<CharQuote, QuoteAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: ListItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(charQuote: CharQuote) {
                binding.quote = charQuote
                binding.executePendingBindings()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemQuoteBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quoteFeed = getItem(position)
        holder.bind(quoteFeed)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CharQuote>() {
        override fun areItemsTheSame(oldItem: CharQuote, newItem: CharQuote): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CharQuote, newItem: CharQuote): Boolean {
            return oldItem.quote == newItem.quote
        }
    }
}
