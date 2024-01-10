package com.example.ticketestg.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ticketestg.R

class Menuadmin : AppCompatActivity() {

    private lateinit var btnticketadmin: Button
    private lateinit var btnhistadmin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuadmin)


            btnticketadmin = findViewById(R.id.adminticket)
            btnhistadmin = findViewById(R.id.adminhis)

            btnticketadmin.setOnClickListener{
                val intent = Intent(this, Ticketsadmin::class.java)
                startActivity(intent)
            }

            btnhistadmin.setOnClickListener {
                val intent = Intent(this, histoadmin::class.java)
                startActivity(intent)
            }
        }
    }
