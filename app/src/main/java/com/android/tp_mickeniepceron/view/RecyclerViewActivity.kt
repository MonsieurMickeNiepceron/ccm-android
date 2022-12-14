package com.android.tp_mickeniepceron.view

import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.tp_mickeniepceron.databinding.ActivityRecyclerViewBinding
import com.android.tp_mickeniepceron.model.CityData
import com.android.tp_mickeniepceron.model.CityDataFooter
import com.android.tp_mickeniepceron.model.CityDataHeader
import com.android.tp_mickeniepceron.model.CityObjectForRecyclerView
import com.android.tp_mickeniepceron.viewmodel.CityViewModel
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: CityAdapter
    private lateinit var viewModel: CityViewModel


    private val cityListObserver = Observer<List<CityObjectForRecyclerView>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CityViewModel::class.java]

        adapter = CityAdapter { item, view ->
            onItemClick(item, view)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        binding.addItemButton.setOnClickListener { addRandomAndroidVersion() }
        binding.deleteAllItemButton.setOnClickListener { deleteAndroidVersion() }

        adapter.submitList(generateData())
    }

    override fun onStart() {
        super.onStart()
        viewModel.cityList.observe(this, cityListObserver)
    }

    override fun onStop() {
        super.onStop()
        viewModel.cityList.removeObserver(cityListObserver)
    }

    private fun onItemClick(cityData: CityData, view : View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        Toast.makeText(this, cityData.cityName, Toast.LENGTH_LONG).show()
    }

    private fun addRandomAndroidVersion() {
        val random = Random.nextInt(0, 1000)
        viewModel.insertCity("Saumur", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC")
    }

    private fun deleteAndroidVersion() {
        viewModel.deleteAllCity()
    }

    private fun generateData(): MutableList<CityObjectForRecyclerView> {
        val result = mutableListOf<CityObjectForRecyclerView>()

        mutableListOf(
            CityData("Saumur", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC"),
            CityData("Angers", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC"),
            CityData("Souzay-Champigny", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC"),
            CityData("Montreuil-Bellay", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC"),
            CityData("Vivy", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC"),
            CityData("Chacé", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC"),
            CityData("Varrains", "France", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAACWCAMAAAAfSh8xAAAAD1BMVEXOESb///8AJlR/kqnzxMlwvJaeAAAApUlEQVR4nO3PQREAIAgAMAT6ZzYEeOdja7DIuTpbOh4wNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0/GJ4AUOofWVeGcMdAAAAAElFTkSuQmCC"),
            CityData("Bruxelles", "Belgique", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Flag_of_Belgium_%28civil%29.svg/langfr-225px-Flag_of_Belgium_%28civil%29.svg.png"),
            CityData("Munich", "Allemagne", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/langfr-225px-Flag_of_Germany.svg.png"),
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