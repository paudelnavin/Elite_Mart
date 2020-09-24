package com.example.emart.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.emart.entities.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(prod : Product)
    @Query("SELECT * FROM PRODUCT ORDER BY PID ASC")
    fun getAllProducts() : LiveData<List<Product>>
    @Query("SELECT * FROM PRODUCT WHERE :productId")
    fun getProduct(productId : Int) : Product
    @Insert
    suspend fun addMultipleProducts(vararg user : Product)
    @Update
    suspend fun updateProduct(prod: Product)
    @Delete
    suspend fun deleteProduct(prod: Product)
}