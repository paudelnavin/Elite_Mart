package com.example.emart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.emart.domains.User
import com.example.emart.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.activity_register.*
import org.mindrot.jbcrypt.BCrypt

class RegisterActivity : AppCompatActivity() {

    private lateinit var myUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        myUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

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
        val userType = findViewById<RadioButton>(type.checkedRadioButtonId).text.toString()

        if (inputCheck(firstname, lastname, email, password, userType)) {
            val user = User(
                0,
                firstname,
                lastname,
                email,
                BCrypt.hashpw(password, BCrypt.gensalt(12)),
                userType
            )
            myUserViewModel.addUser(user)
            val toast: Toast =
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT)
            toast.show()
            finish()
        } else {
            val toast: Toast = Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_LONG)
            toast.show()
        }
    }

    private fun inputCheck(
        firstname: String,
        lastname: String,
        username: String,
        password: String,
        userType: String
    ): Boolean =
        !(TextUtils.isEmpty(firstname) &&
                TextUtils.isEmpty(lastname) &&
                TextUtils.isEmpty(username) &&
                TextUtils.isEmpty(password) &&
                TextUtils.isEmpty(userType))

}