package com.example.emart.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.emart.domains.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : User)
    @Query("SELECT * FROM USER ORDER BY UID ASC")
    fun getAllUser() : LiveData<List<User>>
    @Insert
    suspend fun addMultipleUsers(vararg user : User)
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
}