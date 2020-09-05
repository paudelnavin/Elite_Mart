package com.example.assignment31

import com.example.assignment31.domains.User
import com.example.assignment31.repository.Datasource
import com.example.assignment31.repository.ListDatasource
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
        assertEquals("bYemerou", ListDatasource.save(user))
    }

    @Test
    fun testReadUser() {
        val user = User("Brook", "Yemerou", "BrookYemerou", "BrookY")
        ListDatasource.save(user)
        assertEquals(user, ListDatasource.find("BrookYemerou"))
    }

    @Test
    fun testEditUser() {
        ListDatasource.edit(User("Brook", "Yemerou", "bYemerou", "ChangedPassword"))
        if(ListDatasource.find("bYemerou")?.password != null) {
            assertEquals( "ChangedPassword", ListDatasource.find("bYemerou")?.password)
        }
    }

    @Test
    fun findDeleteUser() {
        val user = User("Brook", "Yemerou", "bYemerou", "ChangedPassword")
        assertEquals("bYemerou", ListDatasource.delete(user) )
    }

}