package com.example.emart.repository

import com.example.emart.entities.User

interface UserDatasource {
    fun save(user: User) : String?
    fun find(id:String) : User?
    fun edit(user: User) : String
    fun delete(user: User) : String
    fun findAll() : List<User>
}