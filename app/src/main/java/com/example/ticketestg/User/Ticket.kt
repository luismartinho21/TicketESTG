// Ticket.kt
package com.example.ticketestg

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tickets")
data class Ticket(
    val nomeUsuario: String,
    val numeroContato: String,
    val email: String,
    val motivo: String,
    val descricao: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
