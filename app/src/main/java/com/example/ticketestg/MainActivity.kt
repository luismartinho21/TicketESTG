package com.example.ticketestg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnregisto: Button
    private lateinit var btnlogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnregisto = findViewById(R.id.button)
        btnlogin = findViewById(R.id.button2)

        btnregisto.setOnClickListener{
            val intent = Intent(this, registo::class.java)
            startActivity(intent)
        }

        btnlogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}