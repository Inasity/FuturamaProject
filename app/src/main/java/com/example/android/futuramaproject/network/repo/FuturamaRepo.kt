package com.example.android.futuramaproject.network.repo

import com.example.android.futuramaproject.network.data.CharQuote
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.network.endpoint.FuturamaApiEndPoints
import com.example.android.futuramaproject.network.networkmodel.ServiceResult
import com.example.android.futuramaproject.network.repoImpl.FuturamaRepoImpl
import kotlinx.coroutines.Dispatchers

interface FuturamaRepo {

    suspend fun fetchFuturamaQuotes(): ServiceResult<List<CharQuote>?>

    suspend fun fetchFuturamaCharacters(): ServiceResult<List<FuturamaCharacter>?>
}
