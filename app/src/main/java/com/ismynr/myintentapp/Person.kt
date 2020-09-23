package com.ismynr.myintentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//  POJO CLASS (Plain Old Java Object)
@Parcelize
data class Person (
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable