package com.example.composetestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetestapplication.data.SampleChatMessages
import com.example.composetestapplication.tutorials.chat_messages_demo.composables.Conversation
import com.example.composetestapplication.tutorials.chat_messages_demo.screen.ChatScreen
import com.example.composetestapplication.ui.theme.ComposeTestApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ComposeTestApplicationTheme {

                StartFun()
            }
        }
    }
}

@Composable
fun StartFun() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable(route = "main") {
            MainScreen(navController)
        }

        composable(route = "chat") {
            ChatScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {

        Text(text = "Main Screen", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("chat")} ) {
            Text(text = "Chat demo")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column() {

        Text(text = "SecondScreen Screen")
        Button(onClick = { navController.popBackStack() } ) {
            Text(text = "back")
        }
    }
}

public fun NavGraphBuilder.composable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    addDestination(
        ComposeNavigator.Destination(
            provider[ComposeNavigator::class],
            content
        ).apply {
            this.route = route
            arguments.forEach { (argumentName, argument) ->
                addArgument(argumentName, argument)
            }
            deepLinks.forEach { deepLink ->
                addDeepLink(deepLink)
            }
        }

    )

}





