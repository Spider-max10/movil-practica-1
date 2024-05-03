package com.example.tienda.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tiendas")
data class TiendaEntidad(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "nombre") val Nombre: String,
    @ColumnInfo(name = "descripcion") val Descripcion: String,
    @ColumnInfo(name = "visitas") val Visitas: Int,
    @ColumnInfo(name = "url") val Url: String,
)

