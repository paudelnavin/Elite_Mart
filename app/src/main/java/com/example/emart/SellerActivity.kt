package com.example.emart


import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.emart.adapters.SellerFragmentsAdapter
import com.example.emart.entities.Product
import com.example.emart.entities.User
import com.example.emart.ui.seller.OrderFragment
import com.example.emart.ui.seller.ProductFragment
import com.example.emart.ui.seller.ShippingFragment
import com.example.emart.viewmodels.ProductViewModel
import com.example.emart.viewmodels.UserViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_seller.*
import kotlinx.android.synthetic.main.activity_seller.tabs
import java.nio.Buffer

class SellerActivity : AppCompatActivity() {
//    lateinit var prod : Product

    private lateinit var pViewModel: ProductViewModel

    private var product = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller)
        pViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

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



    fun addNewProduct(view: View) {
        pViewModel.dropDatabase()
        pViewModel.addProduct(Product(1, "Burger", "@drawable/food", 4, "Food", 4, 34, "Tasty Burger with beef meat"))
        pViewModel.addProduct(Product(2, "Pizza", "@drawable/food1", 10, "Food", 4, 35, "Pizza with butter and maze on top"))
        pViewModel.addProduct(Product(3, "Sandwich", "@drawable/food2", 5, "Food", 4, 43, "Veg sandwich with mushroom"))
        pViewModel.addProduct(Product(4, "Pasta", "@drawable/food3", 8, "Food", 4, 56, "Italian Pasta"))
        pViewModel.addProduct(Product(5, "Chowmein", "@drawable/food4", 22, "Food", 4, 58, "Cooked chowmein with mushroom"))
        pViewModel.addProduct(Product(6, "Chicken Fry", "@drawable/food5", 12, "Food", 4, 78, "Deep fry and taste is better than KFC"))
        pViewModel.addProduct(Product(7, "Beef", "@drawable/food6", 23, "Food", 4, 88, "Beef Toast"))
        pViewModel.addProduct(Product(8, "Salad", "@drawable/food7", 7, "Food", 4, 67, "Cucumber, Carrot salad"))
        pViewModel.addProduct(Product(9, "Coke", "@drawable/food8", 29, "Food", 4, 69, "Zero sugar coke"))
        pViewModel.addProduct(Product(10, "Sprite", "@drawable/food9", 40, "Food", 4, 45, "Normal sprite"))

        pViewModel.addProduct(Product(11, "Steel hand wear", "@drawable/beauty", 12, "Beauty", 3, 18, "Designed hand wear"))
        pViewModel.addProduct(Product(12, "Leather hand wear", "@drawable/beauty1", 56, "Beauty", 3, 56, "Hand wear made from elephant leather"))
        pViewModel.addProduct(Product(13, "Neckles", "@drawable/beauty2", 76, "Beauty", 3, 58, "Diamond necles with 24 carrot"))
        pViewModel.addProduct(Product(14, "Powder", "@drawable/beauty3", 45, "Beauty", 3, 23, "Cool fairness powder"))
        pViewModel.addProduct(Product(15, "Oil", "@drawable/beauty4", 32, "Beauty", 3, 121, "Coconut hair oil"))
        pViewModel.addProduct(Product(16, "Eye lid", "@drawable/beauty5", 33, "Beauty", 3, 35, "24 hour proof eye lid"))
        pViewModel.addProduct(Product(17, "Lipstick", "@drawable/beauty6", 23, "Beauty", 3, 37, "Red color lipstick"))
        pViewModel.addProduct(Product(18, "Blushing powder", "@drawable/beauty7", 12, "Beauty", 4, 47, "Wear this and you look blushing everyday"))
        pViewModel.addProduct(Product(19, "Don Bosco", "@drawable/beauty8", 99, "Beauty", 3, 57, "New product to be launched with mystery"))
        pViewModel.addProduct(Product(20, "Hamilton", "@drawable/beauty9", 25, "Beauty", 3, 88, "Wear hamilton item, you feel superior"))

        pViewModel.addProduct(Product(21, "T-shirt", "@drawable/clothing1", 8, "Clothing", 3, 10, "Unisex thsirt"))
        pViewModel.addProduct(Product(22, "Round Neck T-shirt", "@drawable/clothing2", 56, "Clothing", 3, 101, "Round neck tshirt for male"))
        pViewModel.addProduct(Product(23, "Inner wear", "@drawable/clothing3", 12, "Clothing", 3, 20, "Inner wear for female"))
        pViewModel.addProduct(Product(24, "Women T-shirt", "@drawable/clothing4", 34, "Clothing", 3, 19, "Round neck tshiirt for female"))
        pViewModel.addProduct(Product(25, "Socks", "@drawable/clothing5", 39, "Clothing", 3, 18, "unisex socks"))
        pViewModel.addProduct(Product(26, "Women tops", "@drawable/clothing6", 35, "Clothing", 3, 16, "Best top for women and gaurantee for no color dismantel"))
        pViewModel.addProduct(Product(27, "Vest", "@drawable/clothing7", 30, "Clothing", 3, 23, "Bigboss vest for men"))
        pViewModel.addProduct(Product(28, "Underware", "@drawable/clothing8", 42, "Clothing", 3, 200, "Bigboss underware for male"))
        pViewModel.addProduct(Product(29, "Formal pant", "@drawable/clothing9", 32, "Clothing", 3, 14, "Wear this and feel like James Bond"))
        pViewModel.addProduct(Product(30, "Jeans Pant", "@drawable/clothing10", 13, "Clothing", 3, 5, "Never torn away Heans pant for man and women"))

        pViewModel.addProduct(Product(31, "Apple 11", "@drawable/electronics1", 121, "Electronics", 5, 6, "Price is sharply decreased so make your dream true to hold Apple samrtphone"))
        pViewModel.addProduct(Product(32, "Ipad 12", "@drawable/electronics2", 200, "Electronics", 5, 9, "Buy Ipad and take wherever you want anytime"))
        pViewModel.addProduct(Product(33, "Samsung Smartphone", "@drawable/electronics3", 599, "Electronics", 4, 52, "Android version 10 smartphone"))
        pViewModel.addProduct(Product(34, "MI K20", "@drawable/electronics4", 624, "Electronics", 5, 56, "Buy high rating smartphone in low price"))
        pViewModel.addProduct(Product(35, "Apple Ipad 13", "@drawable/electronics5", 423, "Electronics", 5, 88, "New Apple phone for you"))
        pViewModel.addProduct(Product(36, "Music Player", "@drawable/electronics6", 323, "Electronics", 5, 19, "Listen once from it and you will listen it for everyday every seconds"))
        pViewModel.addProduct(Product(37, "IPod", "@drawable/electronics7", 443, "Electronics", 5, 20, "Long battery music player"))
        pViewModel.addProduct(Product(38, "Camera Lens", "@drawable/electronics8", 890, "Electronics", 5, 25, "If you want to change lens then change it"))
        pViewModel.addProduct(Product(39, "Digital Camera", "@drawable/electronics9", 1021, "Electronics", 5, 26, "Local Brand digital camera in low price"))
        pViewModel.addProduct(Product(40, "Nikon Camera", "@drawable/electronics10", 1400, "Electronics", 5, 57, "Best 5k video digital cmaera by Nikon"))


        Toast.makeText(this, "Successfully added to Database", Toast.LENGTH_SHORT).show()
//        startActivity(Intent(this, ProductActivity::class.java))
    }

    fun clearDialog(view: View) = finish()

    fun loadAllData(view: View) {

        if(pViewModel.getAllProduct == null){
            val toast: Toast =
                Toast.makeText(this, "No Database", Toast.LENGTH_SHORT)
            toast.show()
        }else{
            pViewModel.getAllProduct.observe(this, Observer { users ->
                users.forEach {
                    product.add(it)
                }
            })
        }

    }


}
