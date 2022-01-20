package com.example.android.futuramaproject.network.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharQuote (
    val character: String,
    val quote: String,
    val image: String
        ): Parcelable
