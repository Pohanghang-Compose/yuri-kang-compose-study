package org.sopt.do_sopt_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.do_sopt_compose.navigation.AuthNavigation
import org.sopt.do_sopt_compose.navigation.Screen
import org.sopt.do_sopt_compose.ui.pages.LoginPage
import org.sopt.do_sopt_compose.ui.pages.MainPage
import org.sopt.do_sopt_compose.ui.pages.SignUpPage
import org.sopt.do_sopt_compose.ui.theme.Do_sopt_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Do_sopt_composeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val navController = rememberNavController()
                        AuthNavigation(navController = navController)
                    }
                }
            }
        }
    }
}
