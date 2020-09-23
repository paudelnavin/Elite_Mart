package com.example.emart.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.emart.dao.UserDao
import com.example.emart.database.EliteDatabase

import com.example.emart.domains.User
import com.example.emart.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application) {

    val getAllUsers : LiveData<List<User>>
    val repository : UserRepository
    lateinit var user : User
    var userDao : UserDao = EliteDatabase.getDatabase(application).userDao()

    init {
        repository = UserRepository(userDao)
        getAllUsers = repository.readAllData
//        user = repository.getUser("byemerou@miu.edu")
    }

    fun addUser(user : User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun getUser(username : String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            user = repository.getUser(username)
//        }
        userDao.getUser(username)
    }

}