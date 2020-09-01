package com.example.assignment2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var menu : ArrayList<String> = ArrayList<String>(5)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        menu.addAll(arrayOf("Hamburger", "Pizza", "Mexican", "American", "Chinese"))
        textView.text = menu[0]
    }

    fun decideClicked(view: View) {
        val randomNumber = Random.nextInt(0, menu.size)
        textView.text = menu[randomNumber]
    }

    fun addButton(view: View) {
        val newFood = editText.text.toString()
        if(!menu.contains(newFood)) menu.add(newFood)
        textView.text = newFood
    }
}