package com.example.assignment31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment31.adapters.DeviceAdapter
import com.example.assignment31.domains.Device
import kotlinx.android.synthetic.main.activity_recycled_list.*

class RecycledListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycled_list)

        val recyclerView = rview
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val devices = ArrayList<Device>()
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))
        devices.add(Device("iPhone 5", 999.0, "Black", R.drawable.phone, "34564", "Brand New"))
        devices.add(Device("MacBook Air", 850.0, "Grey", R.drawable.macbook, "76435", "Used"))

        var adapter = DeviceAdapter(devices)
        recyclerView.adapter = adapter

    }

    fun deviceDescription(view: View) {

    }
}