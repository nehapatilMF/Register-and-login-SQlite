package com.example.userregistration
import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.userregistration.DB.DBHelper
import java.nio.file.attribute.AclEntry.Builder

class Login : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btnSubmit: Button
    private lateinit var createAcc: TextView
    private lateinit var dbHelper: DBHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.text_email)
        password = findViewById(R.id.text_pass)
        btnSubmit = findViewById(R.id.btnSubmit_login)
        createAcc = findViewById(R.id.createAcc)
        dbHelper = DBHelper(this)

        btnSubmit.setOnClickListener {
            val emailCheck = email.text.toString()
            val passCheck = password.text.toString()
            val cursor = dbHelper.getData()

            if (emailCheck.isBlank() && passCheck.isBlank()) {
                Toast.makeText(this@Login, "email and password should not empty.", Toast.LENGTH_LONG).show()

            }

            else if (loginCheck(cursor, emailCheck, passCheck)) {
                val intent = Intent(this@Login, Finalpage::class.java)
                intent.putExtra("email", emailCheck)
                email.setText("")
                password.setText("")
                startActivity(intent)
            } else {
                val builder = AlertDialog.Builder(this@Login)
                builder.setCancelable(true)
                builder.setMessage("please enter correct email or password.")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.show()
            }
            dbHelper.close()
        }

        createAcc.setOnClickListener {
            val intent = Intent(this@Login, Signup::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun loginCheck(cursor: Cursor, emailCheck: String, passCheck: String): Boolean {
            while (cursor.moveToNext()) {
                if (cursor.getString(0) == emailCheck) {
                    if (cursor.getString(2) == passCheck) {
                        return true
                    }
                    return false
                }
            }
            return false
        }
    }
}
