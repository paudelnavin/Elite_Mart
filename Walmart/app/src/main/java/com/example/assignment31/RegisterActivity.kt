package com.example.assignment31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.assignment31.domains.User
import com.example.assignment31.repository.Datasource
import com.example.assignment31.repository.ListDatasource
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
        var firstname = firstname.text.toString()
        var lastname = lastname.text.toString()
        var email = email.text.toString()
        var password = password.text.toString()

        if(firstname != "" && lastname != "" && email != "" && password != "" && ListDatasource.find(email)?.username != email) {
            ListDatasource.save(User(firstname, lastname, email, password))
            var toast: Toast = Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT)
            toast.show()
            finish()
        } else {
            var toast: Toast = Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}