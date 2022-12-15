package com.android.tp_mickeniepceron.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.tp_mickeniepceron.chuckNorris.model.ChuckNorrisUi
import com.android.tp_mickeniepceron.databinding.ItemChuckNorrisBinding
import com.bumptech.glide.Glide

val diffUtils = object : DiffUtil.ItemCallback<ChuckNorrisUi>() {
    override fun areItemsTheSame(oldItem: ChuckNorrisUi, newItem: ChuckNorrisUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ChuckNorrisUi, newItem: ChuckNorrisUi): Boolean {
        return oldItem == newItem
    }

}

class ChuckNorrisAdapter : ListAdapter<ChuckNorrisUi, ChuckNorrisQuoteViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckNorrisQuoteViewHolder {
        return ChuckNorrisQuoteViewHolder(
            ItemChuckNorrisBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChuckNorrisQuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ChuckNorrisQuoteViewHolder(
    private val binding: ItemChuckNorrisBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: ChuckNorrisUi

    fun bind(chuckNorrisUi: ChuckNorrisUi) {
        ui = chuckNorrisUi
        Glide.with(itemView.context)
            .load("https://static.wikia.nocookie.net/charabattles/images/e/eb/Chuck_norris.jpg/revision/latest?cb=20170412123612&path-prefix=fr")
            .into(binding.itemChuckNorrisIcon)
        // chuck norris images are no longer available
        binding.itemChuckNorrisQuote.text = chuckNorrisUi.quote
    }
}