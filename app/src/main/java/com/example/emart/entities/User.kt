package com.example.emart.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UID")
    var uid : Int,
    @ColumnInfo(name = "FIRSTNAME")
    var firstname: String,
    @ColumnInfo(name = "LASTNAME")
    var lastname: String,
    @ColumnInfo(name = "USERNAME")
    var username: String,
    @ColumnInfo(name = "PASSWORD")
    var password: String,
    @ColumnInfo(name = "TYPE")
    var userType: String) {
}