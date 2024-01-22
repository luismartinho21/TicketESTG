// TicketDao.kt
package com.example.ticketestg

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TicketDao {
    @Insert
    suspend fun insert(ticket: Ticket)

    @Query("SELECT * FROM tickets")
    suspend fun getAllTickets(): List<Ticket>

    @Update
    suspend fun aceitar(ticket: Ticket)

    @Delete
    suspend fun apagar(ticket: Ticket)
}
