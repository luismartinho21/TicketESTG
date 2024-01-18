package com.example.ticketestg.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ticketestg.Ajuda
import com.example.ticketestg.Historico
import com.example.ticketestg.Home
import com.example.ticketestg.R
import com.example.ticketestg.databinding.ActivityMenuuserBinding


class Menuuser : AppCompatActivity() {


    private lateinit var binding: ActivityMenuuserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuuserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.historico -> replaceFragment(Historico())
                R.id.tickets -> replaceFragment(Tickets())
                R.id.ajuda -> replaceFragment(Ajuda())

                else ->{

                }
            }
            true
        }


    }


    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }


}