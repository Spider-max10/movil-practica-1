package com.example.tienda.navigation

sealed class AppScreens(val route: String){

    object TiendaEntry: AppScreens("TiendaEntry")
    object TiendaRegistros: AppScreens("TiendaRegistros")

}