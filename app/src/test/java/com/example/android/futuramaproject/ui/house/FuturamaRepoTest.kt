package com.example.android.futuramaproject.ui.house

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.network.networkmodel.ServiceResult
import com.example.android.futuramaproject.network.repoImpl.FuturamaRepoImpl
import com.example.android.futuramaproject.ui.futuramacharacters.CharactersViewModel
import io.mockk.coEvery
import io.mockk.every
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
class FuturamaRepoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModelTest: CharactersViewModel
    private val testApp = mockk<Application>(relaxed = true)
    private val testRepo = mockk<FuturamaRepoImpl>(relaxed = true)
    private val testDispatchers = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(TestCoroutineDispatcher())
        viewModelTest =
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
    fun fetchFuturamaCharactersShouldReturnSUCCESSFUL() = runBlockingTest {
        //This sets up the mock data
        coEvery { testRepo.fetchFuturamaCharacters() } returns createSuccessfulStarkCall()

        //The test
        viewModelTest.getFuturamaCharacters()

        //Assert
        assertEquals(
            10, viewModelTest.characterFeed.value?.size
        )
        assertEquals(
            createSuccessfulStarkCall().data?.get(2)?.Name, viewModelTest.characterFeed.value?.get(2)?.Name
        )


    }

    private fun createSuccessfulStarkCall(): ServiceResult.Success<List<FuturamaCharacter>?> {
        return ServiceResult.Success(
            listOf(
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>() {
                    every { Species } returns "Ohyeayeah"
                    every { Age } returns "69"
                    every { Planet } returns "Hyperborea"
                    every { Profession } returns "Computer Monkey"
                    every { Status } returns "My eyelids heavy"
                    every { PicUrl } returns "bedbedbedbedbedbedbedbedbed"
                    every { Relatives } returns "Sweet Home Alabama"
                    every { Voicedby } returns "The crackhead at the local Waffle House"
                    every { Name } returns "your mom lul"
                },
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>(relaxed = true),
                mockk<FuturamaCharacter>(relaxed = true)
            )
        )
    }
}
