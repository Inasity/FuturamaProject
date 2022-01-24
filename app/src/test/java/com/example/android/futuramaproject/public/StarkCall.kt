package com.example.android.futuramaproject.public

import com.example.android.futuramaproject.network.data.CharQuote
import com.example.android.futuramaproject.network.data.FuturamaCharacter
import com.example.android.futuramaproject.network.networkmodel.ServiceResult
import io.mockk.every
import io.mockk.mockk

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
}
