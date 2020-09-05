package com.example.assignment31.ui.home

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.assignment31.R
import com.example.assignment31.ShoppingActivity
import com.example.assignment31.domains.ShoppingCategory
import kotlinx.android.synthetic.main.card.view.*
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
        newListOfCategories.add(ShoppingCategory(R.drawable.clothing2, "Clothings"))

        catAdapter = CategoryAdapter(requireContext(), newListOfCategories)
        categoryLayout.adapter = catAdapter

    }

    class CategoryAdapter : BaseAdapter {

        var context: Context?=null
        var listOfCategory = ArrayList<ShoppingCategory>()
        constructor(context: Context, listOfCategory: ArrayList<ShoppingCategory>) {
            this.context = context
            this.listOfCategory = listOfCategory
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val cat = this.listOfCategory[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            var categoryView = inflator.inflate(R.layout.card, p2, false)
            categoryView.imageButton5.setImageResource(cat.imageString!!)
            categoryView.imageButton5.setOnClickListener{
                var toast: Toast = Toast.makeText(context, "${categoryView.textView8.text} Category Selected", Toast.LENGTH_LONG )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            categoryView.textView8.text = cat.catName!!
            return categoryView
        }


        override fun getCount(): Int {
            return listOfCategory.size
        }

        override fun getItem(p0: Int): Any {
            return listOfCategory[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }


    }


}