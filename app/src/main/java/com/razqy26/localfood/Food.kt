package com.razqy26.localfood

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    var name: String,
    var description: String,
    var photo: Int,
):Parcelable
