package com.example.android.futuramaproject.di.network

import com.example.android.futuramaproject.network.endpoint.FuturamaApiEndPoints
import com.example.android.futuramaproject.network.repo.FuturamaRepo
import com.example.android.futuramaproject.network.repoImpl.FuturamaRepoImpl
import com.example.android.futuramaproject.network.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object FuturamaNetworkModule {
    private const val FuturamaBaseUrl = "https://futuramaapi.herokuapp.com/"

    @Singleton
    @Provides
    fun provideFuturamaRetrofit(): FuturamaApiEndPoints {
        return RetrofitFactory.retrofitProvider(
            FuturamaApiEndPoints::class.java,
            FuturamaBaseUrl
        )
    }

    @Singleton
    @Provides
    fun provideFuturamaRepo(
        dispatcher: CoroutineDispatcher,
        retroObject: FuturamaApiEndPoints
    ): FuturamaRepo {
        return FuturamaRepoImpl(dispatcher, retroObject)
    }
}
