package com.example.emart.repository

import androidx.lifecycle.LiveData
import com.example.emart.dao.UserDao
import com.example.emart.entities.User

class UserRepository(private val userDao : UserDao) {
    val readAllData : LiveData<List<User>> = userDao.getAllUser()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun getUser(username: String) : User {
        return userDao.getUser(username)
    }


}