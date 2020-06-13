package com.example.renit.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(var id : String? = "" ,var title :String ="", var image: String = "") : Parcelable