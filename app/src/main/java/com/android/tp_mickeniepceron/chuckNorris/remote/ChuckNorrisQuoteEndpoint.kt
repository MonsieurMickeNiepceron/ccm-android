package com.android.tp_mickeniepceron.chuckNorris.remote

import com.android.tp_mickeniepceron.chuckNorris.model.ChuckNorrisRetrofit
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {
    @GET("random/")
    suspend fun getRandomQuote() : ChuckNorrisRetrofit
}
