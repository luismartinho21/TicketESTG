package com.example.ticketestg

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.Intent
import android.net.Uri



class Ajuda : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ajuda, container, false)
//email
        val emailTextView: TextView = view.findViewById(R.id.email)

        emailTextView.text = Html.fromHtml("<a href=\"mailto:hupinheiro@ipvc.pt\">hupinheiro@ipvc.pt</a>")
        emailTextView.movementMethod = LinkMovementMethod.getInstance()

        emailTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:hupinheiro@ipvc.pt")
            startActivity(intent)
        }
//phone

                val phoneTextView: TextView = view.findViewById(R.id.phone)

                phoneTextView.text = Html.fromHtml("<a href=\"tel:+351 912123123\">+351 912123123</a>")
                phoneTextView.movementMethod = LinkMovementMethod.getInstance()

                phoneTextView.setOnClickListener {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:+351 912123123")
                    startActivity(intent)
                }

            return view


            }




    }

