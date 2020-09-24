package com.example.emart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emart.R
import com.example.emart.entities.Product
import kotlin.coroutines.coroutineContext

class CustomerProductAdapter(private var productList: ArrayList<Product>) : RecyclerView.Adapter<CustomerProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerProductAdapter.ProductHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card, parent, false)
        return ProductHolder(view)
    }




    override fun onBindViewHolder(holder: CustomerProductAdapter.ProductHolder, position: Int) {
//        productList[position].image

//        var resources = resources.
//        holder?.cardImage?.setImageResource()
        holder?.cardName.text = productList[position].productName
        holder?.cardPrice.text = productList[position].price.toString()
//        holder?.cardRating


    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardImage = itemView.findViewById<ImageView>(R.id.card_image)
        val cardName = itemView.findViewById<TextView>(R.id.card_name)
        val cardRating = itemView.findViewById<RatingBar>(R.id.card_rating)
        val cardPrice = itemView.findViewById<TextView>(R.id.card_price)
    }

}