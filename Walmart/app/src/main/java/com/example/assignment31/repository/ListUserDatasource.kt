package com.example.assignment31.repository

import com.example.assignment31.domains.User
import java.lang.Exception

object ListUserDatasource : UserDatasource {

    private var storage: MutableList<User> = mutableListOf()

    override fun save(user: User): String? {
        return try {
            if(!storage.contains(user)) {
                storage.add(user)
                user.username
            } else null
        } catch (e: Exception) {
            "Couldn't save User"
        }
    }

    override fun find(username: String): User? {
        storage.forEach { when (it.username) { username -> return it } }
        return null
    }

    override fun edit(user: User): String {
        for ((index, aUser) in storage.withIndex()) {
            when (aUser.username) {
                user.username -> {
                    storage[index] = user
                    return user.username
                }
            }
        }
        return "Couldn't Edit User"
    }

    override fun delete(user: User): String {
        storage.forEach {
            when (it.username) {
                user.username -> {
                    storage.remove(it)
                    return user.username
                }
            }
        }
        return "Couldn't Delete User"
    }

    override fun findAll() : List<User> { return storage }

}