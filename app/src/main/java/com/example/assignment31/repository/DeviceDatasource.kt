package com.example.assignment31.repository

import com.example.assignment31.domains.Device
import com.example.assignment31.domains.User

interface DeviceDatasource {
    fun save(device: Device) : String?
    fun find(id:String) : Device?
    fun edit(device: Device) : String
    fun delete(device: Device) : String
    fun findAll() : List<Device>
}