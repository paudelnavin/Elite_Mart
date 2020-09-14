package com.example.emart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.emart.domains.User
import com.example.emart.repository.ListUserDatasource
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val actionbar = supportActionBar
        actionbar!!.title = "Register"
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun register(view: View) {
        val firstname = firstname.text.toString()
        val lastname = lastname.text.toString()
        val email = email.text.toString()
        val password = password.text.toString()

        if(firstname != "" && lastname != "" && email != "" && password != "" && ListUserDatasource.find(email)?.username != email) {
            ListUserDatasource.save(User(firstname, lastname, email, password))
            val toast: Toast = Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT)
            toast.show()
            finish()
        } else {
            val toast: Toast = Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}