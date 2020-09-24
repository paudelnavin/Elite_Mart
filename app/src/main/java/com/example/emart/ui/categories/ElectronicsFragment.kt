package com.example.emart.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emart.R
import com.example.emart.adapters.CustomerProductAdapter
import com.example.emart.entities.Product
import com.example.emart.viewmodels.ProductViewModel


class ElectronicsFragment : Fragment() {


    private lateinit var pViewModel: ProductViewModel
    private var listOfProducts = ArrayList<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_electronics, container, false)
        val shopRecycler = view!!.findViewById<RecyclerView>(R.id.shop_recycle)

        pViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        shopRecycler?.layoutManager = GridLayoutManager(activity, 2)

        pViewModel.getAllProduct.observe(viewLifecycleOwner, Observer { products ->
            products.forEach {
                if (it.catagory.equals("Electronics")) {
                    listOfProducts.add(it)
                }
            }
        })

        shopRecycler.adapter = CustomerProductAdapter(listOfProducts)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ElectronicsFragment().apply {
            arguments = Bundle()
        }
    }
}