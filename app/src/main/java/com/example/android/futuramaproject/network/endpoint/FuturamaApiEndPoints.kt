package com.example.android.futuramaproject.network.endpoint

import com.example.android.futuramaproject.network.data.CharQuote
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import retrofit2.Response
import retrofit2.http.GET

interface FuturamaApiEndPoints {
    @GET("/api/quotes")
    suspend fun getQuotes(): Response<List<CharQuote>?>

    @GET("/api/v2/characters")
    suspend fun getCharacters(): Response<List<FuturamaCharacter>?>
}
