package com.example.emart

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.emart.entities.Product
import com.example.emart.ui.seller.ProductFragment
import com.example.emart.viewmodels.ProductViewModel
import kotlinx.android.synthetic.main.new_product_layout.*

class ProductActivity : AppCompatActivity() {

    private lateinit var pViewModel : ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_product_layout)
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

    fun createNewProduct(view: View) {
        val productName = pname.text
        val productPrice = price.text
        val productRating = rating.text
        val productDescription = desc.text
        val productQuantity = quantity.text
        val rg = findViewById(R.id.group) as RadioGroup
        val value = (findViewById(rg.getCheckedRadioButtonId()) as RadioButton)
            .getText()
        val productCategory = value

        if (inputCheck(
                productName.toString(),
                productPrice.toString(),
                productRating.toString(),
                productDescription.toString(),
                productCategory.toString(),
                productQuantity.toString()
            )
        ) {
            pViewModel.createNewProduct(
                Product(
                    productId = 0,
                    productName = productName.toString(),
                    price = Integer.parseInt(productPrice.toString()),
                    rating = Integer.parseInt(productRating.toString()),
                    desc = productDescription.toString(),
                    catagory = productCategory.toString(),
                    quantity = Integer.parseInt(productQuantity.toString()),
                    image = "@drawable/electronics"
                )
            )
//            val product = Product(0, productName.toString(), productPrice.toString(), Integer.parseInt(productRating.toString()),
//                productDescription.toString(),Integer.parseInt(productCategory.toString()),Integer.parseInt(productQuantity.toString()),
//                "@drawable/electronics")
//
//            val intent = Intent(this, RecycledListActivity::class.java)
//            intent.putExtra("product", product)
//            startActivity(intent)
            Toast.makeText(this, "Data are successfully added", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProductFragment::class.java)
            startActivity(intent)
        }
    }

}




