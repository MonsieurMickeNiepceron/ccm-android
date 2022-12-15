package com.android.tp_mickeniepceron.chuckNorris.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChuckNorrisUi(
    val quote: String,
    val iconUrl: String
)

@Entity(tableName = "chuck_norris_quote")
data class ChuckNorrisRoom(
    @ColumnInfo(name = "quote_text")
    val quote: String,

    @ColumnInfo(name = "quote_icon_url")
    val iconUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

data class ChuckNorrisRetrofit(
    @Expose
    @SerializedName("value")
    val quote: String,

    @Expose
    @SerializedName("icon_url")
    val iconUrl: String
)