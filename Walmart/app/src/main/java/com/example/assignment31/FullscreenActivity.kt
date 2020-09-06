package com.example.assignment31

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.assignment31.domains.User
import com.example.assignment31.repository.Datasource
import com.example.assignment31.repository.ListDatasource
import kotlinx.android.synthetic.main.activity_fullscreen.*
import java.util.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {
    private lateinit var fullscreenContent: TextView
    private lateinit var fullscreenContentControls: LinearLayout
    private val hideHandler = Handler()



    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        supportActionBar?.hide()

        ListDatasource.save(User("Brook", "Yemerou", "brookyemerou@gmail.com", "brookyemerou"))
        ListDatasource.save(User("Brook", "Yemerou", "byemerou@miu.edu", "Y"))
        ListDatasource.save(User("Jane", "Doe", "JDoe", "janedoe"))
        ListDatasource.save(User("Peter", "Parker", "PParker", "peterparker"))
        ListDatasource.save(User("John", "Doe", "JDoeM", "jdoem"))
        ListDatasource.save(User("John", "Doe", "", ""))

    }

    fun authentication(view: View) {
        val email = email.text.toString()
        val password = password.text.toString()

        if(ListDatasource.find(email)?.password == password) {
            val intent = Intent(this, ShoppingActivity::class.java)
            intent.putExtra("username", email)
            intent.putExtra("fullname", "${ListDatasource.find(email)?.firstname} ${ListDatasource.find(email)?.lastname}")
            startActivity(intent)
        }
    }



    companion object {
        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private const val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private const val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private const val UI_ANIMATION_DELAY = 300
    }

    fun createAccount(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun forgotPassword(view: View) {
        val myToast = Toast.makeText(applicationContext,"Forgot Password Clicked!",Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.LEFT,200,560)
        myToast.show()

        if(email.text.toString() != "") {
            var intent = Intent(Intent.ACTION_SEND)
            println(email.text.toString())
            intent.putExtra(Intent.EXTRA_EMAIL, email.text.toString())
            intent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")
            intent.putExtra(Intent.EXTRA_TEXT, ListDatasource.find(email.text.toString())?.password)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose Email Client"))
        } else {
            val toast: Toast = Toast.makeText(this, "No Email Found", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.LEFT, 200, 560)
            toast.show()
        }

    }


}