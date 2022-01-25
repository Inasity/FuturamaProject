package com.example.android.futuramaproject.public

import com.example.android.futuramaproject.network.data.CharQuote
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.network.networkmodel.ServiceResult
import io.mockk.every
import io.mockk.mockk
import okhttp3.ResponseBody
import retrofit2.Response

object StarkCall {
    fun createSuccessfulStarkCallCharacters(): ServiceResult.Success<List<FuturamaCharacter>?> {
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

    fun createSuccessfulStarkCallQuotes(): ServiceResult.Success<List<CharQuote>?> {
        return ServiceResult.Success(
            listOf(
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>() {
                    every { character } returns "Pepito"
                    every { quote } returns "Orange juice after brushing your teeth hits different"
                    every { image } returns ":)"
                },
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>(relaxed = true),
                mockk<CharQuote>(relaxed = true)
            )
        )
    }

    fun createResponseStarkCallCharacters(): Response<List<FuturamaCharacter>?> {
        return mockk<Response<List<FuturamaCharacter>?>>(relaxed = true) {
            every { isSuccessful } returns true
            every { body() } returns
                    listOf(
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
                        }
                    )
        }
    }

    fun createResponseStarkCallQuotes(): Response<List<CharQuote>?> {
        return mockk<Response<List<CharQuote>?>>(relaxed = true) {
            every { isSuccessful } returns true
            every { body() } returns
                    listOf(
                        mockk<CharQuote>() {
                            every { character } returns "Pepito"
                            every { quote } returns "Orange juice after brushing your teeth hits different"
                            every { image } returns ":)"
                        }
                    )
        }
    }

    fun createResponseStarkCallCharactersError(): Response<List<FuturamaCharacter>?> {
        return mockk<Response<List<FuturamaCharacter>?>>() {
            every { isSuccessful } returns false
            every { errorBody().toString() } returns "Test Error"
        }
    }
}
