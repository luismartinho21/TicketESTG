package com.example.ticketestg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.ticketestg.User.AppDatabase
import com.example.ticketestg.User.TicketRepository
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ticketestg.User.Senha
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketestg.User.SenhaAdapter


class Tickets : Fragment() {

    private lateinit var ticketRepository: TicketRepository
    private lateinit var senhaAdapter: SenhaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tickets, container, false)

        val database = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "senhas-db"
        ).build()

        ticketRepository = TicketRepository(database.senhaDao())

        senhaAdapter = SenhaAdapter(emptyList())



        val btnInserir = view.findViewById<Button>(R.id.buttonregticket)
        btnInserir.setOnClickListener {
            lifecycleScope.launch {
                inserirSenha()
            }
        }

        return view


        return view
    }
    suspend fun inserirSenha() {
        val editNome = view?.findViewById<EditText>(R.id.editnomeuser)
        val editNumero = view?.findViewById<EditText>(R.id.editnumero)
        val editMail = view?.findViewById<EditText>(R.id.editemail)
        val editMotivo = view?.findViewById<EditText>(R.id.editmotivo)
        val editDescricao = view?.findViewById<EditText>(R.id.editdescrição)

        val nome = editNome?.text.toString()
        val numero = editNumero?.text.toString().toInt()
        val mail = editMail?.text.toString()
        val motivo = editMotivo?.text.toString()
        val descricao = editDescricao?.text.toString()

        val novaSenha = Senha(nome = nome, numero = numero, mail = mail, motivo = motivo, descricao = descricao, idade = 0)
        ticketRepository.inserirSenha(novaSenha)

        editNome?.text?.clear()
        editNumero?.text?.clear()
        editMail?.text?.clear()
        editMotivo?.text?.clear()
        editDescricao?.text?.clear()
        editNome?.requestFocus()
        atualizarListaSenhas()
    }

    override fun onResume() {
        super.onResume()
        atualizarListaSenhas()
    }

    private fun atualizarListaSenhas() {
        lifecycleScope.launch {
            val listaSenhas = withContext(Dispatchers.IO) {
                ticketRepository.listarSenhas()
            }
            senhaAdapter.listaSenhas = listaSenhas
            senhaAdapter.notifyDataSetChanged()
        }
    }
}