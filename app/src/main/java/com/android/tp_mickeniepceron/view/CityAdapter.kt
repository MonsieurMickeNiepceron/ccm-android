package com.android.tp_mickeniepceron.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.tp_mickeniepceron.R
import com.android.tp_mickeniepceron.databinding.ItemCustomRecyclerBinding
import com.android.tp_mickeniepceron.databinding.ItemCustomRecyclerHeaderBinding
import com.android.tp_mickeniepceron.model.CityData
import com.android.tp_mickeniepceron.model.CityDataFooter
import com.android.tp_mickeniepceron.model.CityDataHeader
import com.android.tp_mickeniepceron.model.CityObjectForRecyclerView
import com.bumptech.glide.Glide

private val diffItemUtils = object : DiffUtil.ItemCallback<CityObjectForRecyclerView>() {

    override fun areItemsTheSame(oldItem: CityObjectForRecyclerView, newItem: CityObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CityObjectForRecyclerView, newItem: CityObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
}

class CityAdapter(
        private val onItemClick: (quoteUi: CityData, view: View) -> Unit,
    ): ListAdapter<CityObjectForRecyclerView, RecyclerView.ViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {

            MyItemType.ROW.type -> {
                CityViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onItemClick
                )
            }

            MyItemType.HEADER.type -> {
                CityHeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            MyItemType.FOOTER.type -> {
                CityFooterViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw RuntimeException("Wrong view type received $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as CityViewHolder).bind(getItem(position) as CityData)

            MyItemType.HEADER.type -> (holder as CityHeaderViewHolder).bind(getItem(position) as CityDataHeader)
            MyItemType.FOOTER.type -> (holder as CityFooterViewHolder).bind(getItem(position) as CityDataFooter)

            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is CityData -> MyItemType.ROW.type
            is CityDataHeader -> MyItemType.HEADER.type
            is CityDataFooter -> MyItemType.FOOTER.type
        }
    }
}

class CityViewHolder(
    private val binding: ItemCustomRecyclerBinding,
    onItemClick: (cityData: CityData, view: View) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: CityData

    init {
        binding.root.setOnClickListener {
            onItemClick(ui, itemView)
        }
    }

    fun bind(cityData: CityData) {
        ui = cityData
        binding.itemRecyclerViewCityName.text = cityData.cityName
        binding.itemRecyclerViewCityCountry.text = cityData.cityCountry
        Glide.with(itemView.context)
            .load(cityData.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.itemRecyclerViewVersionImage)
    }
}

class CityHeaderViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cityDataHeader: CityDataHeader) {
        binding.itemRecyclerViewHeader.text = cityDataHeader.header
    }
}

class CityFooterViewHolder(
    private val binding: ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cityDataFooter: CityDataFooter) {
        binding.itemRecyclerViewHeader.text = cityDataFooter.footer
    }
}

enum class MyItemType(val type: Int) {
    ROW(0),
    HEADER(1),
    FOOTER(2)
}
