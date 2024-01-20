package com.example.ticketestg.Admin


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticketestg.R
import com.example.ticketestg.TicketAdapter
import com.example.ticketestg.TicketDao
import com.example.ticketestg.TicketDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class HistoricoAdmin : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ticketAdapter: TicketAdapter
    private lateinit var ticketDao: TicketDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_histoadmin)

        // Inicialize o DAO
        ticketDao = TicketDatabase.getDatabase(this).ticketDao()

        recyclerView = findViewById(R.id.recyclerView1)
        ticketAdapter = TicketAdapter()

        // Configurar o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ticketAdapter

        // Buscar todos os tickets do banco de dados
        GlobalScope.launch {
            val tickets = ticketDao.getAllTickets()
            runOnUiThread {
                ticketAdapter.submitList(tickets)
            }
        }
    }
}


