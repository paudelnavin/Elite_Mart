package com.example.assignment31.repository

import com.example.assignment31.domains.User

interface UserDatasource {
    fun save(user: User) : String?
    fun find(id:String) : User?
    fun edit(user:User) : String
    fun delete(user: User) : String
    fun findAll() : List<User>
}