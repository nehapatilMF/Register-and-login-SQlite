@file:Suppress("DEPRECATION")

package com.example.userregistration


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Finalpage : AppCompatActivity() {
    private lateinit var text: TextView

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalpage)

        text = findViewById(R.id.changeText)
        val intent = intent
        val s2 = intent.getStringExtra("email")
        text.text = s2
    }
}
