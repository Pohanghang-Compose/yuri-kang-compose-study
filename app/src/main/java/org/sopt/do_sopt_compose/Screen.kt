package org.sopt.do_sopt_compose

sealed class Screen(val route: String) {
    object Login : Screen(route = "init")
    object SignUp : Screen(route = "library")
    object Main : Screen(route = "details")
}