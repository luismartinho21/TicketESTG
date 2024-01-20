package com.example.ticketestg

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ticketestg.User.Usuario

class DBHelper(context: Context) : SQLiteOpenHelper(context, "Userdata", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Userdata (utilizador TEXT primary key, password TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists Userdata")
    }

    fun insertdata(utilizador: String, password:String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("utilizador", utilizador)
        cv.put("password",password)

        // Verificar se o nome de utilizador já existe
        val cursor = db.rawQuery("SELECT * FROM Userdata WHERE utilizador = ?", arrayOf(utilizador))
        val exists = cursor.count > 0
        cursor.close()

        // Se o nome de utilizador já existir, retornar false
        if (exists) {
            return false
        }

        // Caso contrário, inserir o novo utilizador
        val result = db.insert("Userdata", null, cv)

        // Se o resultado for -1, a inserção falhou
        return result != -1L
    }
    private fun obterUsuarioAtual(): Usuario? {
        // Implemente a lógica para obter o usuário atual (autenticação, etc.)
        // Substitua "usuario_logado" pela lógica real para obter o usuário atual
        val usuarioLogado = "usuario_logado"
        return getUser(usuarioLogado)
    }

    fun getUser(utilizador: String): Usuario? {
        val db = this.readableDatabase
        val query = "SELECT * FROM Userdata WHERE utilizador = ?"
        val cursor = db.rawQuery(query, arrayOf(utilizador))

        return if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex("password")
            val password = if (columnIndex >= 0) cursor.getString(columnIndex) ?: "" else ""
            Usuario(utilizador, password)
        } else {
            null
        }
    }

    fun checkuserpass(utilizador: String, password: String): Boolean {
        val db = this.writableDatabase
        val query = "SELECT * FROM Userdata WHERE utilizador = ? AND password = ?"
        val cursor = db.rawQuery(query, arrayOf(utilizador, password))
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }

}