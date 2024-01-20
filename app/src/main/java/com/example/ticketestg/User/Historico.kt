// Historico.kt
package com.example.ticketestg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketestg.User.Usuario
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Historico : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ticketAdapter: TicketAdapter
    private lateinit var ticketDao: TicketDao
    private lateinit var dbHelper: DBHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_historico, container, false)

        // Inicialize o DAO
        ticketDao = TicketDatabase.getDatabase(requireContext()).ticketDao()
        dbHelper = DBHelper(requireContext())

        recyclerView = view.findViewById(R.id.recyclerView)
        ticketAdapter = TicketAdapter()

        // Configurar o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ticketAdapter


        GlobalScope.launch {
            val usuarioAtual = obterUsuarioAtual()
            usuarioAtual?.let { user ->
                val tickets = ticketDao.getTicketsByUser(user.utilizador)
                requireActivity().runOnUiThread {
                    ticketAdapter.submitList(tickets)
                }
            }
        }


        return view
    }

    private fun obterUsuarioAtual(): Usuario? {
        // Implemente a lógica para obter o usuário atual (autenticação, etc.)
        return dbHelper.getUser("usuario_logado")
    }
}






