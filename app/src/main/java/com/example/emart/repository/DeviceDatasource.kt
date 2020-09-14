package com.example.emart.repository

import com.example.emart.domains.Device

interface DeviceDatasource {
    fun save(device: Device) : String?
    fun find(id:String) : Device?
    fun edit(device: Device) : String
    fun delete(device: Device) : String
    fun findAll() : List<Device>
}