package com.example.tienda.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TiendaDao {

    @Query("SELECT * FROM tiendas" )
    suspend fun getAllTiendas():List<TiendaEntidad>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tiendas: TiendaEntidad)
}