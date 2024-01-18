package com.example.ticketestg.User

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.ticketestg.R
import kotlinx.coroutines.launch


class Tickets : Fragment() {
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val buttonRegTicket: Button = view.findViewById(R.id.buttonregticket)
            buttonRegTicket.setOnClickListener {
                // Insert the ticket into the history
                val newSenha = Senha(
                    nome = "ExampleName",
                    numero = 123456789,
                    mail = "example@email.com",
                    motivo = "Ticket",
                    descricao = "Ticket Description"
                )
            }
        }
    }
