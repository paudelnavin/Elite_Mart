package com.example.emart.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.emart.dao.UserDao
import com.example.emart.domains.User
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.emart.dao.ProductDao
import com.example.emart.domains.Product
import org.jetbrains.annotations.NotNull

@Database(entities = [User::class, Product::class], version = 3, exportSchema = false)
abstract class EliteDatabase : RoomDatabase(){
    abstract fun productDao() : ProductDao
    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE : EliteDatabase? = null

        fun getDatabase(context: Context) : EliteDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EliteDatabase::class.java,
                    "Elite_Database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}