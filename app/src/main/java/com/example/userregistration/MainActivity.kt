package com.example.userregistration
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.userregistration.DB.DBHelper

class MainActivity : AppCompatActivity() {

    private lateinit var login: Button
    private lateinit var Reg: Button
    private lateinit var dbHelper: DBHelper

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)

        login = findViewById(R.id.btnLogin)


        login.setOnClickListener {
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
        }

        Reg = findViewById(R.id.btnSignUp)
        Reg.setOnClickListener {
            val intent = Intent(this@MainActivity, Signup::class.java)
            startActivity(intent)
        }
    }
}



