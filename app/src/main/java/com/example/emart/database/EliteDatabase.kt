package com.example.emart.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.emart.dao.UserDao
import com.example.emart.domains.User

@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class EliteDatabase : RoomDatabase(){
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
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}