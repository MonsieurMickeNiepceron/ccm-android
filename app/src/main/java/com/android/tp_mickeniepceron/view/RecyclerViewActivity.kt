package com.android.tp_mickeniepceron.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.tp_mickeniepceron.databinding.ActivityRecyclerViewBinding
import com.android.tp_mickeniepceron.model.CityData

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CityAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = adapter

        adapter.submitList(generateData())
    }

    private fun generateData(): ArrayList<CityData> {
        return arrayListOf(
            CityData("Saumur", "France"),
            CityData("Angers", "France"),
            CityData("Souzay-Champigny", "France"),
            CityData("Montreuil-Bellay", "France"),
            CityData("Vivy", "France"),
            CityData("Chacé", "France"),
            CityData("Varrains", "France"),
        )
    }
}