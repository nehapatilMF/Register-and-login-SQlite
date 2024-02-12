package com.example.userregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.userregistration.DB.DBHelper

class Signup : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var number: EditText
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var login: TextView
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        name = findViewById(R.id.textName)
        number = findViewById(R.id.textNumber)
        email = findViewById(R.id.textEmail)
        pass = findViewById(R.id.textPass)
        val signUpAcc: Button = findViewById(R.id.btnSignUpAcc)
        dbHelper = DBHelper(this)

        signUpAcc.setOnClickListener {
            val name1 = name.text.toString()
            val number1 = number.text.toString()
            val email1 = email.text.toString()
            val pass1 = pass.text.toString()

            val b = dbHelper.insertUserData(name1, number1, email1, pass1)

            if (b) {
                Toast.makeText(this@Signup, "Data inserted", Toast.LENGTH_SHORT).show()
                val i = Intent(this@Signup, Login::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this@Signup, "Failed To insert Data", Toast.LENGTH_SHORT).show()
            }
        }

        login = findViewById(R.id.loginAcc)
        login.setOnClickListener {
            val i = Intent(this@Signup, Login::class.java)
            startActivity(i)
        }
    }
}
