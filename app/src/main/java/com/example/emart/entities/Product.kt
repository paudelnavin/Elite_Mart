package com.example.emart.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.emart.R
import com.example.emart.entities.User
import kotlinx.android.synthetic.main.new_product_layout.view.*

@Entity
class Product (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "PID")
        var productId:Int,
        @ColumnInfo(name = "PNAME")
        val productName:String,
        @ColumnInfo(name = "IMAGE")
        val image:String?,
        @ColumnInfo(name = "PRICE")
        val price:Int,
        @ColumnInfo(name = "CATEGORY")
        val catagory:String,
        @ColumnInfo(name = "RATING")
        val rating:Int,
        @ColumnInfo(name = "QUANTITY")
        var quantity:Int,
        @ColumnInfo(name = "DESC")
        var desc : String
){
}