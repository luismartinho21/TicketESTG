package com.example.ticketestg.User

import com.example.ticketestg.Ticket
import com.example.ticketestg.TicketDao

class TicketRepository(private val ticketDao: TicketDao) {
    suspend fun insert(ticket: Ticket) {
        ticketDao.insert(ticket)
    }

    suspend fun aceitarTicket(ticket: Ticket) {
        ticketDao.aceitar(ticket)
    }

    suspend fun apagarTicket(ticket: Ticket) {
        ticketDao.apagar(ticket)
    }


}
