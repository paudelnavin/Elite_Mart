package com.example.emart

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emart.adapters.DeviceAdapter
import com.example.emart.entities.Product
import com.example.emart.repository.ListDeviceDatasource
import kotlinx.android.synthetic.main.activity_recycled_list.*
import kotlinx.android.synthetic.main.horizontal_card.view.*

class RecycledListActivity : AppCompatActivity() {
    lateinit var result: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycled_list)

        val recyclerView = rview
        recyclerView?.layoutManager = LinearLayoutManager(this)

        var adapter = DeviceAdapter(ListDeviceDatasource.findAll())
        recyclerView.adapter = adapter
    }

    fun deviceDescription(view: View) {
        val toast: Toast = Toast.makeText(
            this,
            "Category Selected",
            Toast.LENGTH_LONG
        )
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.show()
        val intent = Intent(this, DeviceDescriptionActivity::class.java)
        intent.putExtra("deviceId", view.itemId.text)
        startActivity(intent)
    }
}