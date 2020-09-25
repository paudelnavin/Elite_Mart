package com.example.emart.ui.seller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emart.R
import com.example.emart.adapters.CustomerProductAdapter
import com.example.emart.adapters.SellerProductAdapter
import com.example.emart.entities.Product
import com.example.emart.ui.categories.ElectronicsFragment
import com.example.emart.viewmodels.ProductViewModel
import kotlinx.android.synthetic.main.fragment_product.view.*


class ProductFragment : Fragment() {

    private lateinit var pViewModel : ProductViewModel
    private var listOfProducts = ArrayList<Product>()

    @Nullable
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_product, container, false)
        val sellerRecycler = view!!.findViewById<RecyclerView>(R.id.seller_recycle)
        pViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        sellerRecycler?.layoutManager = LinearLayoutManager(activity)

        pViewModel.getAllProduct.observe(viewLifecycleOwner, Observer { products ->
            products.forEach {
                    listOfProducts.add(it)
                }
        })

        sellerRecycler.adapter = CustomerProductAdapter(listOfProducts)
        return view
    }
}

