package com.example.emart.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.emart.database.EliteDatabase

import com.example.emart.domains.User
import com.example.emart.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application) {

    private val getAllUsers : LiveData<List<User>>
    private val respository : UserRepository

    init {
        val userDao = EliteDatabase.getDatabase(application).userDao()
        respository = UserRepository(userDao)
        getAllUsers = respository.readAllData
    }

    fun addUser(user : User) {
        viewModelScope.launch(Dispatchers.IO) {
            respository.addUser(user)
        }
    }
}