package com.example.emart.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.emart.R
import com.example.emart.adapters.CategoryAdapter
import com.example.emart.domains.ShoppingCategory
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var catAdapter: CategoryAdapter

    private val newListOfCategories = ArrayList<ShoppingCategory>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newListOfCategories.add(ShoppingCategory(R.drawable.electronics, "Electronics"))
        newListOfCategories.add(ShoppingCategory(R.drawable.clothing, "Clothings"))
        newListOfCategories.add(ShoppingCategory(R.drawable.beauty, "Beauty"))
        newListOfCategories.add(ShoppingCategory(R.drawable.food, "Food"))

        catAdapter = CategoryAdapter(requireContext(), newListOfCategories)
        categoryLayout.adapter = catAdapter

    }

}