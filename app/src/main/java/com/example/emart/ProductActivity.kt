package com.example.emart

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.emart.entities.Product
import com.example.emart.viewmodels.ProductViewModel
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    private lateinit var pViewModel : ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        setSupportActionBar(findViewById(R.id.toolbar))

        pViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

    }


    private fun inputCheck(
        pname: String,
        price: String,
        rating: String,
        desc: String,
        radio: String,
        quantity: String
    ): Boolean {
        return !(TextUtils.isEmpty(pname) && TextUtils.isEmpty(price) && TextUtils.isEmpty(rating) && TextUtils.isEmpty(
            desc
        ) && TextUtils.isEmpty(radio) && TextUtils.isEmpty(quantity))
    }

    fun addProduct(view: View) {
        var prodName = pname.text.toString()
        var prodPrice = Integer.parseInt(price.text.toString())
        var prodRating = Integer.parseInt(rating.text.toString())
        var prodQuantity = Integer.parseInt(quantity.text.toString())
        var prodDesc = desc.text.toString()
        var prodCategory = view.findViewById<RadioButton>(group.checkedRadioButtonId).text.toString()
        println(prodCategory)

        if (inputCheck(
                prodName,
                prodPrice.toString(),
                prodRating.toString(),
                prodDesc,
                prodCategory,
                prodQuantity.toString()
            )
        ) {
            pViewModel.addProduct(
                Product(
                    productId = 0,
                    productName = prodName,
                    price = prodPrice,
                    rating = prodRating,
                    desc = prodDesc,
                    catagory = prodCategory,
                    quantity = prodQuantity,
                    image = "@drawable/electronics"
                )
            )
        }
    }


}




