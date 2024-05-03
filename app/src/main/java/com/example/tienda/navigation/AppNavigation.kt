package com.example.tienda.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tienda.screens.TiendaEntryScreen
import com.example.tienda.screens.TiendaRegistrosScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController =navController , startDestination = AppScreens.TiendaEntry.route){
        composable(route = AppScreens.TiendaEntry.route){
            TiendaEntryScreen(navController)
        }
        composable(route = AppScreens.TiendaRegistros.route){
            TiendaRegistrosScreen(navController)
        }
    }

}