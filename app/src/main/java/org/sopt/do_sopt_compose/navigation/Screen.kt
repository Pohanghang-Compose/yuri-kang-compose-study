package org.sopt.do_sopt_compose.navigation

sealed class Screen(val route: String) {
    object Login : Screen(route = "login")
    object SignUp : Screen(route = "signUp")
    object Main : Screen(route = "main")
}