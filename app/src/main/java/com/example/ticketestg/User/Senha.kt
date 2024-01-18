package com.example.ticketestg.User

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "senhas")
data class Senha(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String,
    val idade: Int,
    val numero: Int,
    val mail: String,
    val motivo: String,
    val descricao: String
)