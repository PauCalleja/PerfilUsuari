package com.example.perfilusuari

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.btn)
        val editUser = findViewById<EditText>(R.id.editUser)
        val editMail = findViewById<EditText>(R.id.editMail)
        val editUrl = findViewById<EditText>(R.id.editUrl)
        val editBio = findViewById<EditText>(R.id.editBio)

        btn.setOnClickListener {
            val nextPantalla = Intent(this, ProfileActivity::class.java)
            nextPantalla.putExtra("user", editUser.text.toString())
            nextPantalla.putExtra("mail", editMail.text.toString())
            nextPantalla.putExtra("img", editUrl.text.toString())
            nextPantalla.putExtra("bio", editBio.text.toString())
            startActivity(nextPantalla)
        }
    }
}