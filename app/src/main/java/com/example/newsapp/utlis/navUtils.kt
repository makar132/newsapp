package com.example.newsapp.utlis

import androidx.navigation.NavHostController

object NavRoutes {
    const val HOME = "Home"
    const val SEARCH = "Search"
    const val FAVORITES = "Favorites"
}

/**
 * Navigate to NavHost composable screens*/
class NavActions(navHostController: NavHostController) {
     val navController = navHostController

    val navigateToHome: () -> Unit = {
        println("navigating to  home ...")

        navController.navigate(NavRoutes.HOME)
        {
            popUpTo(NavRoutes.HOME)
            { inclusive = true }
        }
    }
    val navigateToSearch: () -> Unit = {
        println("navigating to  search ...")

        navController.navigate(NavRoutes.SEARCH)
        {

            popUpTo(NavRoutes.HOME)
            { inclusive = true }

        }
    }
    val navigateToFavorites: () -> Unit = {
        println("navigating to  favorites ...")
        navController.navigate(NavRoutes.FAVORITES)
        {
            popUpTo(NavRoutes.HOME)
            { inclusive = true }

        }
    }

}