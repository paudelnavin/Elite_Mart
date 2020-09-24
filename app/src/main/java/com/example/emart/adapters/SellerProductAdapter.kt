package com.example.emart.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emart.R
import com.example.emart.domains.Product
import kotlinx.android.synthetic.main.items_products.view.*


class SellerProductAdapter(private val mContext: Context, private val mData: List<Product>) : RecyclerView.Adapter<SellerProductAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items_products, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = mData[position]
//        holder.imgView.setImageResource(currentItem.image)
        holder.textView.text = "Quantity: " + currentItem.quantity.toString()
        holder.textView1.text = "Item: " + currentItem.productName
        holder.textView4.text = "$" + currentItem.price.toString()
        holder.textView3.text = "Code: " + currentItem.productId.toString()
    }

    override fun getItemCount() = mData.size


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgView: ImageView = itemView.img_products
        val textView:TextView=itemView.quantity_product
        val textView1: TextView = itemView.name_product
        val textView2: TextView = itemView.id_product
        val textView3: TextView = itemView.color_product
        var textView4: TextView = itemView.price_product


    }

}