package com.example.ticketestg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.ticketestg.User.AppDatabase
import com.example.ticketestg.User.Senha
import com.example.ticketestg.User.SenhaAdapter
import com.example.ticketestg.User.SenhaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Historico : Fragment() {


    private lateinit var senhaRepository: SenhaRepository
    // NOVO
    private lateinit var senhaAdapter: SenhaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_historico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "senhas-db"
        ).build()

        senhaRepository = SenhaRepository(database.senhaDao())

        senhaAdapter = SenhaAdapter(this)
        val recyclerView= view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = senhaAdapter


        senhaRepository = SenhaRepository(database.senhaDao())

        val btnInserir = view.findViewById<Button>(R.id.buttonregticket)
        btnInserir.setOnClickListener {

            lifecycleScope.launch {
                inserirSenha()
                atualizarListaSenhas()

            }
        }
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
        senhaRepository.inserirSenha(novaSenha)

        editNome?.text?.clear()
        editNumero?.text?.clear()
        editMail?.text?.clear()
        editMotivo?.text?.clear()
        editDescricao?.text?.clear()
        editNome?.requestFocus()
    }

    private fun atualizarListaSenhas() {
        lifecycleScope.launch {
            val listaSenhas = withContext(Dispatchers.IO) {
                senhaRepository.listarSenhas()
            }
        }
    }
}


