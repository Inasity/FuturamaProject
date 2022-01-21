package com.example.android.futuramaproject.network.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FuturamaCharacter(
    val Species: String,
    val Age: String,
    val Planet: String,
    val Profession: String,
    val Status: String,
    val PicUrl: String,
    val Relatives: String,
    val Voicedby: String,
    val Name: String
): Parcelable
