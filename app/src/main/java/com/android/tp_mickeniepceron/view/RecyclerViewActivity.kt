package com.android.tp_mickeniepceron.view

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.tp_mickeniepceron.databinding.ActivityRecyclerViewBinding
import com.android.tp_mickeniepceron.model.CityData
import com.android.tp_mickeniepceron.model.CityDataFooter
import com.android.tp_mickeniepceron.model.CityDataHeader
import com.android.tp_mickeniepceron.model.CityObjectForRecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CityAdapter { item, view ->
            onItemClick(item, view)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = adapter

        adapter.submitList(generateData())
    }

    private fun onItemClick(cityData: CityData, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, cityData.cityName, Toast.LENGTH_LONG).show()
    }


    private fun generateData(): MutableList<CityObjectForRecyclerView> {
        val result = mutableListOf<CityObjectForRecyclerView>()

        mutableListOf(
            CityData("Saumur", "France"),
            CityData("Angers", "France"),
            CityData("Souzay-Champigny", "France"),
            CityData("Montreuil-Bellay", "France"),
            CityData("Vivy", "France"),
            CityData("Chacé", "France"),
            CityData("Varrains", "France"),
            CityData("Bruxelles", "Belgique"),
            CityData("Munich", "Allemagne"),
        ).groupBy {
            it.cityCountry == "France"
        }.forEach { (b, cityData) ->
            result.add(CityDataHeader("Is a french city: $b"))
            result.addAll(cityData)
            result.add(CityDataFooter("Hello this is a footer"))
        }

        return result
    }
}