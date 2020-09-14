package com.example.emart

import com.example.emart.domains.User
import com.example.emart.repository.ListUserDatasource
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testCreateUser() {
        val user = User("Brook", "Yemerou", "bYemerou", "BrookY")
        assertEquals("bYemerou", ListUserDatasource.save(user))
    }

    @Test
    fun testReadUser() {
        val user = User("Brook", "Yemerou", "BrookYemerou", "BrookY")
        ListUserDatasource.save(user)
        assertEquals(user, ListUserDatasource.find("BrookYemerou"))
    }

    @Test
    fun testEditUser() {
        ListUserDatasource.edit(User("Brook", "Yemerou", "bYemerou", "ChangedPassword"))
        if(ListUserDatasource.find("bYemerou")?.password != null) {
            assertEquals( "ChangedPassword", ListUserDatasource.find("bYemerou")?.password)
        }
    }

    @Test
    fun findDeleteUser() {
        val user = User("Brook", "Yemerou", "bYemerou", "ChangedPassword")
        assertEquals("bYemerou", ListUserDatasource.delete(user) )
    }

}