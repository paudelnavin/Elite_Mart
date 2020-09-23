package com.example.emart.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emart.R
import com.example.emart.adapters.CustomerProductAdapter
import com.example.emart.entities.Product


class ElectronicsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_electronics, container, false)
        val shopRecycler = view!!.findViewById<RecyclerView>(R.id.shop_recycle)

        shopRecycler?.layoutManager = GridLayoutManager(activity, 2)

        //TODO("Replace with Database")

        val listOfProducts = arrayListOf<Product>(
            Product(0, "Laptop", 25.0, "the Device"),
            Product(1, "Laptop", 25.0, "the Device"),
            Product(2, "Laptop", 25.0, "the Device"),
            Product(3, "Laptop", 25.0, "the Device"),
            Product(4, "Laptop", 25.0, "the Device")
        )

        shopRecycler.adapter = CustomerProductAdapter(listOfProducts)
        Toast.makeText(activity, "We are here!!!!", Toast.LENGTH_SHORT).show()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ElectronicsFragment().apply {
                arguments = Bundle()
            }
    }
}