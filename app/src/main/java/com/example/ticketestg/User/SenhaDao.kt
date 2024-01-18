package com.example.ticketestg.User

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ticketestg.User.Senha

@Dao
interface SenhaDao {
    @Insert
    suspend fun inserir(senha: Senha)

    @Query("SELECT * FROM senhas")
    suspend fun listarSenhas(): List<Senha>
}