package com.example.assignment31

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.assignment31.domains.Device
import com.example.assignment31.repository.ListDeviceDatasource
import kotlinx.android.synthetic.main.activity_device_description.*
import kotlinx.android.synthetic.main.description.view.*

class DeviceDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_description)

        var currentDevice: Device? = ListDeviceDatasource.find(intent.getStringExtra("deviceId")!!)

        val descriptionView : View? = layoutInflater.inflate(R.layout.description, null)
        descriptionView!!.bigImage.setImageResource(currentDevice!!.image)
        descriptionView!!.deviceName.text = currentDevice!!.name
        descriptionView!!.devicePrice.text = currentDevice!!.price.toString()
        descriptionView!!.deviceId.text = currentDevice!!.itemId
        descriptionView!!.deviceDesc.text = currentDevice!!.desc
        descriptionView!!.deviceColor.text = currentDevice!!.color
        descBackground!!.addView(descriptionView)

    }

}