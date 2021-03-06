package com.example.emart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.emart.domains.Device
import com.example.emart.entities.User
import com.example.emart.repository.ListDeviceDatasource
import com.example.emart.repository.ListUserDatasource
import com.example.emart.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.activity_fullscreen.*
import org.mindrot.jbcrypt.BCrypt


class FullscreenActivity : AppCompatActivity() {
    private lateinit var fullscreenContent: TextView
    private lateinit var fullscreenContentControls: LinearLayout
    private val hideHandler = Handler()

    private var users = ArrayList<User>()

    private lateinit var myUserViewModel: UserViewModel

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        supportActionBar?.hide()

        myUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        ListDeviceDatasource.save(
            Device(
                "iPhone 11",
                999.0,
                "Black",
                R.drawable.phone,
                "34564",
                "This pre-owned product is not Apple certified, but has been professionally inspected, tested and " +
                        "cleaned by Amazon-qualified suppliers."
            )
        )

        ListDeviceDatasource.save(
            Device(
                "MacBook Air",
                850.0,
                "Space Grey",
                R.drawable.macbook,
                "76435",
                "Stunning 13.3-inch Retina display with True Tone technology " +
                        "Backlit Magic Keyboard and Touch ID" +
                        "Tenth-generation Intel Core i3 processor" +
                        "Intel Iris Plus Graphics"
            )
        )

        ListDeviceDatasource.save(
            Device(
                "Alienware",
                1029.99,
                "Lunar Light",
                R.drawable.monitor,
                "AW3420DW",
                "Experience breathtaking views with a combination of immersive features\n" +
                        "A 1900R curved, wide 21: 9 display maximizes the field of view"
            )
        )

        ListDeviceDatasource.save(
            Device(
                "MSI Leopard 10SFK-062",
                1399.00,
                "Black",
                R.drawable.laptop,
                "GL65",
                "15.6\" FHD IPS-Level 144Hz 72%NTSC Thin Bezel close to 100%Srgb NVIDIA GeForce RTX 2070 8G GDDR6\n" +
                        "Intel Core i7-10750H 2.6-5.0GHz"
            )
        )

        ListDeviceDatasource.save(
            Device(
                "Omen by HP Obelisk",
                1999.99,
                "Black",
                R.drawable.desktop,
                "8751023",
                "Hyper-realistic graphics: NVIDIA(R) GeForce(R) RTX 2080 Super (8 GB GDDR6 dedicated memory). Enjoy new levels of gaming realism and speed"
            )
        )
    }

    fun authentication(view: View) {
        val email = email.text.toString()
        val password = password.text.toString()

        var user : User? = null
        try {
            myUserViewModel.getAllUsers.observe(this, Observer {
                    users -> users.forEach {
                if(it.username == email) {
                    user = it
                    if (BCrypt.checkpw(password, user!!.password)) {
                        when (user!!.userType) {
                            "CUSTOMER" -> {
                                val intent = Intent(this, ShoppingActivity::class.java)
                                intent.putExtra("username", email)
                                intent.putExtra("fullname", "${user!!.firstname} ${user!!.lastname}")
                                startActivity(intent)
                                Toast.makeText(applicationContext, "Login Successful!", Toast.LENGTH_LONG)
                            }
                            "SELLER" -> {
                                val intent = Intent(this, SellerActivity::class.java)
                                intent.putExtra("username", email)
                                intent.putExtra("fullname", "${user!!.firstname} ${user!!.lastname}")
                                startActivity(intent)
                                Toast.makeText(applicationContext, "Sign Up Successful!", Toast.LENGTH_LONG)
                            }
                        }
                    }
                }
            }})
        } catch (ex : Exception) {
            println("${ex.message}")
        }

    }


    companion object {
        private const val AUTO_HIDE = true
        private const val AUTO_HIDE_DELAY_MILLIS = 3000
        private const val UI_ANIMATION_DELAY = 300
    }

    fun createAccount(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun forgotPassword(view: View) {
        val myToast =
            Toast.makeText(applicationContext, "Forgot Password Clicked!", Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.LEFT, 200, 560)
        myToast.show()

        if (email.text.toString() != "") {
            var intent = Intent(Intent.ACTION_SEND)
            println(email.text.toString())
            intent.putExtra(Intent.EXTRA_EMAIL, email.text.toString())
            intent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")
            intent.putExtra(
                Intent.EXTRA_TEXT,
                ListUserDatasource.find(email.text.toString())?.password
            )
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose Email Client"))
        } else {
            val toast: Toast = Toast.makeText(this, "No Email Found", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.LEFT, 200, 560)
            toast.show()
        }

    }


}