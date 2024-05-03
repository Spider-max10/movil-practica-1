package com.example.tienda.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TiendaEntidad::class], version = 1)
abstract class TiendaDB: RoomDatabase(){
    abstract fun getTiendaDao(): TiendaDao
}