package com.example.perfilusuari

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usertxt = findViewById<TextView>(R.id.user)
        val mailtxt = findViewById<TextView>(R.id.mail)
        val biotxt = findViewById<TextView>(R.id.bio)
        val imageView = findViewById<ImageView>(R.id.imageView)


        intent.getStringExtra("user").apply { usertxt.text = "$this" }
        intent.getStringExtra("mail").apply { mailtxt.text = "$this" }
        intent.getStringExtra("bio").apply { biotxt.text = "$this" }


        Glide.with(imageView)
           .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/196.png")
           .into(imageView)
    }
}