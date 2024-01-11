package com.example.ticketestg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketestg.R
import com.example.ticketestg.User.UserHistoryAdapter
import com.example.ticketestg.User.UserHistoryModel

class Historico : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userHistoryAdapter: UserHistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_historico, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewUserHistory)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o RecyclerView
        userHistoryAdapter = UserHistoryAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userHistoryAdapter
        }

        // Atualizar o RecyclerView com dados reais do histórico do usuário
        userHistoryAdapter.submitList(getUserHistoryList())
    }

    // Função fictícia para obter a lista real de tickets do usuário
    private fun getUserHistoryList(): List<UserHistoryModel> {
        // Implemente a lógica real para obter a lista de tickets do usuário
        // Pode envolver uma chamada ao banco de dados ou a uma API
        // Exemplo: return repository.getUserHistory()
        return listOf(/* Lista real de tickets */)
    }
}
