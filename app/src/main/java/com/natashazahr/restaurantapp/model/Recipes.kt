package com.natashazahr.restaurantapp.model

import android.app.Notification
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipes(
    var name : String?,
    var category : String?,
    var description : String?,
    var ingredients : String?,
    var instructions : String?,
    var pictures : String?,
    var number: String?,
    var calories : String?,
    var carbo : String?,
    var protein : String?
) : Parcelable
// Parcelable untuk meng extend data class jadi
// data object biar bisa di consume sama android