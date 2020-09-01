package com.example.assignment2

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
    }

    fun decideClicked(view: View) {
        val randomNumber = Random.nextInt(0, 5)
        textView.text = menu[randomNumber]
    }
}