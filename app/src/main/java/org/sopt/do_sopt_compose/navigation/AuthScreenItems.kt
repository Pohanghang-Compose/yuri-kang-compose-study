package org.sopt.do_sopt_compose.navigation

sealed class AuthScreenItems(val route: String) {
    object Login : AuthScreenItems(route = "login")
    object SignUp : AuthScreenItems(route = "signUp")
    object Main : AuthScreenItems(route = "main")
}