package com.android.tp_mickeniepceron.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.tp_mickeniepceron.databinding.ItemCustomRecyclerBinding
import com.android.tp_mickeniepceron.model.CityData

private val diffItemUtils = object : DiffUtil.ItemCallback<CityData>() {

    override fun areItemsTheSame(oldItem: CityData, newItem: CityData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CityData, newItem: CityData): Boolean {
        return oldItem == newItem
    }
}

class CityAdapter : ListAdapter<CityData, CityViewHolder>(diffItemUtils){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            ItemCustomRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CityViewHolder(
    private val binding: ItemCustomRecyclerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(cityData: CityData) {
        binding.itemRecyclerViewCityName.text = cityData.cityName
        binding.itemRecyclerViewCityCountry.text = cityData.cityCountry
    }
}
