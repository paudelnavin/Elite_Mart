package com.example.emart.ui.seller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emart.R
import com.example.emart.adapters.SellerProductAdapter
import com.example.emart.domains.Product
import kotlinx.android.synthetic.main.fragment_product.view.*


class ProductFragment : Fragment() {



    private lateinit var listProducts: List<Product>
    lateinit var myRecyclerView: RecyclerView

    @Nullable
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        listProducts = arrayListOf(Product(0, "Name", 2, 23, 2, 1,"gOOD"))
        var inflate = inflater.inflate(R.layout.fragment_product, container, false)
        inflate.products_recyclerView.layoutManager = LinearLayoutManager(context)
        val recyclerAdapter = SellerProductAdapter(requireContext(), listProducts)
        inflate.products_recyclerView.adapter = recyclerAdapter
        // Inflate the layout for this fragment
        return inflate
    }


}