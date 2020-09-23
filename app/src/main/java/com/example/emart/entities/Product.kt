package com.example.emart.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Product(
    var uid : Int,
    val name : String,
    var price : Double,
    val desc : String)  {
}