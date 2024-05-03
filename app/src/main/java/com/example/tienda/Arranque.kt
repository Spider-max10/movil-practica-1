package com.example.tienda

import android.app.Application
import androidx.room.Room
import com.example.tienda.database.TiendaDB

class Arranque: Application() {

    companion object{
        lateinit var room: TiendaDB
    }

    override fun onCreate() {
        super.onCreate()
        room = Room
            .databaseBuilder(applicationContext, TiendaDB::class.java, "tienda_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}