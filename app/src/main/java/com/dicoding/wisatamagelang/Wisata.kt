package com.dicoding.wisatamagelang

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val name: String,
    val description: String,
    val photo: Int,
    val ticket: String,
    val schedule: String,
    val address: String,
    val googleAddress: String
):Parcelable
