package com.example.emart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emart.adapters.DeviceAdapter
import com.example.emart.repository.ListDeviceDatasource
import kotlinx.android.synthetic.main.activity_recycled_list.*
import kotlinx.android.synthetic.main.horizontal_card.view.*

class RecycledListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycled_list)

        val recyclerView = rview
        recyclerView?.layoutManager = LinearLayoutManager(this)
//        val devices = ArrayList<Device>()

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