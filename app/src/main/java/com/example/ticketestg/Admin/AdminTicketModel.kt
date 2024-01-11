package com.example.ticketestg.Admin

data class AdminTicketModel(
    val ticketId: String,
    val userName: String,
    val ticketStatus: String // Pode ser "Aceito", "Recusado", "Em Andamento", "Completo", etc.
    // Adicione outros campos conforme necessário
)
