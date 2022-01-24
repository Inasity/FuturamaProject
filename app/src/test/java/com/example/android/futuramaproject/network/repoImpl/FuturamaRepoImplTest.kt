package com.example.android.futuramaproject.network.repoImpl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Rule

@ExperimentalCoroutinesApi
class FuturamaRepoImplTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var futuramaRepoImplTest: FuturamaRepoImpl
    private val testDispatchers = TestCoroutineDispatcher()

}
