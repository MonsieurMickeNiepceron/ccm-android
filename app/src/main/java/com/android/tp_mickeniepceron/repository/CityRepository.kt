package com.android.tp_mickeniepceron.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.android.tp_mickeniepceron.architecture.CustomApplication
import com.android.tp_mickeniepceron.model.*

class CityRepository {

    private val mCityDao =
        CustomApplication.instance.mApplicationDatabase.mCityDao()

    fun selectAllCity(): LiveData<List<CityData>> {
        return mCityDao.selectAll().map { list ->
            list.toCityData()
        }
    }

    fun insertCity(cityData: CityData) {
        mCityDao.insert(cityData.toRoomObject())
    }

    fun deleteAllCity() {
        mCityDao.deleteAll()
    }

    private fun CityData.toRoomObject(): LocalDataSourceSample {
        return LocalDataSourceSample(
            cityName = cityName,
            country = cityCountry,
            image = image
        )
    }

    private fun List<LocalDataSourceSample>.toCityData(): List<CityData> {
        return map { eachItem ->
            CityData(
                cityName = eachItem.cityName,
                cityCountry = eachItem.country,
                image = eachItem.image
            )
        }
    }

    fun generateData(): MutableList<CityObjectForRecyclerView> {
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