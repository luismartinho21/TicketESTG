package com.example.ticketestg.User

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ticketestg.User.SenhaDao
import com.example.ticketestg.User.Senha

@Database(entities = [Senha::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun senhaDao(): SenhaDao
}