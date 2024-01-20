// Tickets.kt
package com.example.ticketestg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Tickets : Fragment() {

    private lateinit var ticketDao: TicketDao
    private lateinit var dbHelper: DBHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tickets, container, false)

        // Inicialize o DAO
        ticketDao = TicketDatabase.getDatabase(requireContext()).ticketDao()
        dbHelper = DBHelper(requireContext())

        // Declarações de variáveis para as EditTexts
        val editNomeUsuario: EditText = view.findViewById(R.id.editnomeuser)
        val editNumero: EditText = view.findViewById(R.id.editnumero)
        val editEmail: EditText = view.findViewById(R.id.editemail)
        val editMotivo: EditText = view.findViewById(R.id.editmotivo)
        val editDescricao: EditText = view.findViewById(R.id.editdescrição)
        val buttonregticket: Button = view.findViewById(R.id.buttonregticket)

        buttonregticket.setOnClickListener {
            // Obtenha os dados das EditTexts usando as variáveis declaradas
            val nomeUsuario = editNomeUsuario.text.toString()
            val numeroContato = editNumero.text.toString()
            val email = editEmail.text.toString()
            val motivo = editMotivo.text.toString()
            val descricao = editDescricao.text.toString()

            // Crie um objeto Ticket
            val ticket = Ticket(
                nomeUsuario = nomeUsuario,
                numeroContato = numeroContato,
                email = email,
                motivo = motivo,
                descricao = descricao
            )

            // Guarda o ticket no banco de dados
            GlobalScope.launch {
                ticketDao.insert(ticket)
            }

            // Limpar os EditTexts após o registro do ticket
            editNomeUsuario.text.clear()
            editNumero.text.clear()
            editEmail.text.clear()
            editMotivo.text.clear()
            editDescricao.text.clear()
        }

        return view
    }
}

