package com.example.emart.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.emart.dao.ProductDao
import com.example.emart.database.EliteDatabase
import com.example.emart.domains.Product

import com.example.emart.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) :AndroidViewModel(application) {

    val getAllProduct: LiveData<List<Product>>
    val repository: ProductRepository

    lateinit var prod: Product
    var productDao: ProductDao = EliteDatabase.getDatabase(application).productDao()

    init {
        repository = ProductRepository(productDao)
        getAllProduct = repository.readAllData
    }

    fun addProduct(prod: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(prod)
        }
    }



}
