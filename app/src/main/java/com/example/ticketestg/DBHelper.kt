package com.example.ticketestg

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "Userdata", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Userdata (utilizador TEXT primary key, password TEXT)")
        p0?.execSQL("create table Tickets (id INTEGER primary key, nomeUsuario TEXT, numeroContato TEXT, email TEXT, motivo TEXT, descricao TEXT, estado TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists Userdata")
        p0?.execSQL("drop table if exists TicketData")
        onCreate(p0)
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

    fun checkuserpass(utilizador: String, password: String): Boolean {
        val db = this.writableDatabase
        val query = "SELECT * FROM Userdata WHERE utilizador = ? AND password = ?"
        val cursor = db.rawQuery(query, arrayOf(utilizador, password))
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }

}