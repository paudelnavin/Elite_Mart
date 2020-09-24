package com.example.emart.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.emart.dao.ProductDao
import com.example.emart.entities.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductRepository(private val productDao: ProductDao ) {
    val readAllData : LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun addProduct(prod: Product) {
        productDao.addProduct(prod)
    }

    fun getProduct(productId: Int) : Product {
        return productDao.getProduct(productId)
    }

    suspend fun dropDatabase(){
          productDao.dropProduct()
        }
}