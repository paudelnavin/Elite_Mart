package com.example.emart.repository

import com.example.emart.domains.Device
import java.lang.Exception

object ListDeviceDatasource : DeviceDatasource {
    private var storage: MutableList<Device> = mutableListOf()

    override fun save(device: Device): String? {
        return try {
            if(!storage.contains(device)) {
                storage.add(device)
                device.itemId
            } else null
        } catch (e: Exception) {
            "Couldn't save Device"
        }
    }

    override fun find(itemId: String): Device? {
        storage.forEach { when (it.itemId) { itemId -> return it } }
        return null
    }

    override fun edit(device: Device): String {
        for ((index, aDevice) in storage.withIndex()) {
            when (aDevice.itemId) {
                device.itemId -> {
                    storage[index] = device
                    return device.itemId
                }
            }
        }
        return "Couldn't Edit Device"
    }

    override fun delete(device: Device): String {
        storage.forEach {
            when (it.itemId) {
                device.itemId -> {
                    storage.remove(it)
                    return device.itemId
                }
            }
        }
        return "Couldn't Delete Device"
    }

    override fun findAll() : ArrayList<Device> { return storage as ArrayList<Device> }
}