package com.example.android.futuramaproject.network.repoImpl

import com.example.android.futuramaproject.network.data.CharQuote
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.network.endpoint.FuturamaApiEndPoints
import com.example.android.futuramaproject.network.networkmodel.ServiceResult
import com.example.android.futuramaproject.network.repo.FuturamaRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class FuturamaRepoImpl @Inject constructor(
    private val dispatcher: Dispatchers,
    private val retroObject: FuturamaApiEndPoints
) : FuturamaRepo {

    override suspend fun fetchFuturamaQuotes(): ServiceResult<List<CharQuote>?> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getQuotes()

            Timber.d("Got the quotes baby. $dataResponse")

            if(dataResponse.isSuccessful) {
                ServiceResult.Success(dataResponse.body())
            }
            else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }

    override suspend fun fetchFuturamaCharacters(): ServiceResult<List<FuturamaCharacter>?> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getCharacters()

            Timber.d("Got the characters baby. $dataResponse")

            if(dataResponse.isSuccessful) {
                ServiceResult.Success(dataResponse.body())
            }
            else {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }
}
