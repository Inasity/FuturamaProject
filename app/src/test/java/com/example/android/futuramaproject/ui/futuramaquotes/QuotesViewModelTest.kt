package com.example.android.futuramaproject.ui.futuramaquotes

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.futuramaproject.network.repoImpl.FuturamaRepoImpl
import com.example.android.futuramaproject.public.StarkCall
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuotesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var quotesViewModelTest: QuotesViewModel
    private val testApp = mockk<Application>(relaxed = true)
    private val testRepo = mockk<FuturamaRepoImpl>(relaxed = true)
    private val testDispatchers = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(TestCoroutineDispatcher())
        quotesViewModelTest =
            QuotesViewModel(
                application = testApp,
                futuramaRepo = testRepo,
                dispatchers = testDispatchers
            )

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun fetchFuturismQuotesShouldReturnSuccessfully() = runBlockingTest {
        coEvery { testRepo.fetchFuturamaQuotes() } returns StarkCall.createSuccessfulStarkCallQuotes()

        quotesViewModelTest.getQuotes()

        assertEquals(
            10, quotesViewModelTest.quoteFeed.value?.size
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallQuotes().data?.get(1)?.character, quotesViewModelTest.quoteFeed.value?.get(1)?.character
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallQuotes().data?.get(1)?.quote, quotesViewModelTest.quoteFeed.value?.get(1)?.quote
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallQuotes().data?.get(1)?.image, quotesViewModelTest.quoteFeed.value?.get(1)?.image
        )



    }
}
