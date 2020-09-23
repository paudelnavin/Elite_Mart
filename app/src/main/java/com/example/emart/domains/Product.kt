package com.example.emart.domains

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Product (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "PID")
        var productId:Int,
        @ColumnInfo(name = "PNAME")
        val productName:String,
        @ColumnInfo(name = "IMAGE")
        val image:Int,
        @ColumnInfo(name = "PRICE")
        val price:Int,
        @ColumnInfo(name = "CATEGORY")
        val catagory:Int,
        @ColumnInfo(name = "QUANTITY")
        var quantity:Int,
        @ColumnInfo(name = "DESC")
        var desc : String
){
}