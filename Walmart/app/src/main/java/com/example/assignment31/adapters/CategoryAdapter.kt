package com.example.assignment31.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.assignment31.R
import com.example.assignment31.RecycledListActivity
import com.example.assignment31.domains.ShoppingCategory
import kotlinx.android.synthetic.main.card.view.*

class CategoryAdapter : BaseAdapter {

    var context: Context?=null
    var listOfCategory = ArrayList<ShoppingCategory>()

    constructor(context: Context, listOfCategory: ArrayList<ShoppingCategory>) {
        this.context = context
        this.listOfCategory = listOfCategory
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val cat = this.listOfCategory[p0]
        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val categoryView = inflator.inflate(R.layout.card, p2, false)
        categoryView.imageButton5.setImageResource(cat.imageString!!)
        categoryView.beauty.setOnClickListener{
            popToast(categoryView)
            if(categoryView.textView8.text == "Electronics") {
                val intent = Intent(context, RecycledListActivity::class.java)
                (context as Activity).startActivity(intent)
            }
        }
        categoryView.textView8.text = cat.catName!!
        return categoryView
    }


    private fun popToast(categoryView : View) {
        val toast: Toast = Toast.makeText(
            context,
            "${categoryView.textView8.text} Category Selected",
            Toast.LENGTH_LONG
        )
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.show()
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