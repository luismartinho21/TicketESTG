package com.example.ticketestg.User

import com.example.ticketestg.User.SenhaDao
import com.example.ticketestg.User.Senha

class SenhaRepository(private val senhaDao: SenhaDao) {
    suspend fun inserirSenha(senha: Senha) {
        senhaDao.inserir(senha)
    }

    suspend fun listarSenhas(): List<Senha> {
        return senhaDao.listarSenhas()
    }
}