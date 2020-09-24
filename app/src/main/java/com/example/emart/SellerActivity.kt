package com.example.emart


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.emart.adapters.SellerFragmentsAdapter
import com.example.emart.ui.seller.OrderFragment
import com.example.emart.ui.seller.ProductFragment
import com.example.emart.ui.seller.ShippingFragment
import com.example.emart.viewmodels.ProductViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_seller.*
import kotlinx.android.synthetic.main.activity_seller.tabs

class SellerActivity : AppCompatActivity() {
//    lateinit var prod : Product

    private lateinit var pViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller)
//        setSupportActionBar(toolbar)
        val adapter = SellerFragmentsAdapter(supportFragmentManager)
        adapter.addFragment(ProductFragment(), "Products")
        adapter.addFragment(OrderFragment(), "Orders")
        adapter.addFragment(ShippingFragment(), "Shipping")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.setIcon(R.drawable.products)
        tabs.getTabAt(1)!!.setIcon(R.drawable.orders)
        tabs.getTabAt(2)!!.setIcon(R.drawable.shipping)



//        prod = Product(12, "laptop", "red", 100.0, R.drawable.orders,3)
//        val addFloat = findViewById<FloatingActionButton>(R.id.add_button)
//        val removeFloat = findViewById<FloatingActionButton>(R.id.remove_button)
//
//        addFloat.setOnClickListener(this)
//        removeFloat.setOnClickListener(this)
    }

    //    override fun onClick(v: View) {
//        if (v != null) {
//            lateinit var prod :Products
//            when(v.id){
//                R.id.add_button-> {
//                    if (prod.productId!=null){
//                        prod.productQuantity++
//                    }
//                }
//                R.id.remove_button->{
//                    if(prod.productId!=null && prod.productQuantity>0){
//                        prod.productQuantity--
//                    }
//                }
//
//            }
//       }
//        Toast.makeText(this,"btn clicked",Toast.LENGTH_LONG).show()
//
//    }

    fun addItem(view: View) {

//        prod.productQuantity++

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        val tab = tabLayout.getTabAt(1)
        tab!!.select()
        val tab1 = tabLayout.getTabAt(0)
        tab1!!.select()
    }

    fun removeItem(view: View) {
//        if (prod.productQuantity>0){
//            prod.productQuantity--
//        }
    }



    fun addNewProduct(view: View) = startActivity(Intent(this, ProductActivity::class.java))

    fun clearDialog(view: View) = finish()



}
