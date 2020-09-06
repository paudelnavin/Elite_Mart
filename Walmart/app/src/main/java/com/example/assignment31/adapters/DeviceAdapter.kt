package com.example.assignment31.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment31.R
import com.example.assignment31.domains.Device

class DeviceAdapter(private var deviceList : ArrayList<Device>) : RecyclerView.Adapter<DeviceAdapter.DeviceHolder>() {

//    private var deviceList = ArrayList<Device>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceAdapter.DeviceHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.horizontal_card, parent, false)
        return DeviceHolder(v)
    }

    override fun onBindViewHolder(holder: DeviceAdapter.DeviceHolder, position: Int) {
        holder?.deviceName?.text = deviceList[position].name
        holder?.deviceColor?.text = deviceList[position].color
        holder?.devicePrice?.text = deviceList[position].price.toString()
        holder?.deviceImage?.setImageResource(deviceList[position].image)
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    class DeviceHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deviceName = itemView.findViewById<TextView>(R.id.name)
        val devicePrice = itemView.findViewById<TextView>(R.id.price)
        val deviceColor = itemView.findViewById<TextView>(R.id.color)
        val deviceImage = itemView.findViewById<ImageView>(R.id.profile_image)

    }
}