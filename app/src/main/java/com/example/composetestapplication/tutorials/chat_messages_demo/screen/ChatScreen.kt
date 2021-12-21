package com.example.composetestapplication.tutorials.chat_messages_demo.screen

import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetestapplication.R
import com.example.composetestapplication.data.SampleChatMessages
import com.example.composetestapplication.tutorials.chat_messages_demo.composables.Conversation

@Composable
fun ChatScreen(navController: NavController) {
    Column() {
        TopAppBar() {
            Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Chat Screen")
        }
        Conversation(messages = SampleChatMessages.conversationSample)
    }
}