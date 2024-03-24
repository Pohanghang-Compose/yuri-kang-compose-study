package org.sopt.do_sopt_compose.ui.pages.doandroid

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.sopt.do_sopt_compose.navigation.BottomNavigation

@Composable
fun DoAndroid(
    navController: NavController,
) {
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                Text(text = "Do")
            }
        }
    )
}
