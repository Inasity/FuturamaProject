package com.example.android.futuramaproject.ui.futuramacharacters

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
class CharactersViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var charactersViewModelTest: CharactersViewModel
    private val testApp = mockk<Application>(relaxed = true)
    private val testRepo = mockk<FuturamaRepoImpl>(relaxed = true)
    private val testDispatchers = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(TestCoroutineDispatcher())
        charactersViewModelTest =
            CharactersViewModel(
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
    fun fetchFuturamaCharactersShouldReturnSuccessfully() = runBlockingTest {
        //This sets up the mock data
        coEvery { testRepo.fetchFuturamaCharacters() } returns StarkCall.createSuccessfulStarkCallCharacters()

        //The test
        charactersViewModelTest.getFuturamaCharacters()

        //Assert
        assertEquals(
            10, charactersViewModelTest.characterFeed.value?.size
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Name, charactersViewModelTest.characterFeed.value?.get(1)?.Name
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Voicedby, charactersViewModelTest.characterFeed.value?.get(1)?.Voicedby
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Relatives, charactersViewModelTest.characterFeed.value?.get(1)?.Relatives
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.PicUrl, charactersViewModelTest.characterFeed.value?.get(1)?.PicUrl
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Status, charactersViewModelTest.characterFeed.value?.get(1)?.Status
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Profession, charactersViewModelTest.characterFeed.value?.get(1)?.Profession
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Planet, charactersViewModelTest.characterFeed.value?.get(1)?.Planet
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Age, charactersViewModelTest.characterFeed.value?.get(1)?.Age
        )
        assertEquals(
            StarkCall.createSuccessfulStarkCallCharacters().data?.get(1)?.Species, charactersViewModelTest.characterFeed.value?.get(1)?.Species
        )


    }
}
