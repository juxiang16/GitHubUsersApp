package com.example.githubusersapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.githubusersapp.data.model.User
import com.example.githubusersapp.data.repository.UserRepository
import android.util.Log

@Composable
fun ListScreen(
    navController: NavHostController
) {

    val repository = UserRepository()

    var users by remember {
        mutableStateOf<List<User>>(emptyList())
    }

    LaunchedEffect(Unit) {
        users = repository.getUsers()
    }

    LazyColumn {
        items(users) { user ->
            UserItem(
                user = user,
                onClick = {
                    Log.d("NAV_TEST", "click: ${user.login}")
                    navController.navigate("detail/${user.login}")
                }
            )
        }
    }
}

@Composable
fun UserItem(
    user: User,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = user.avatar_url,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(text = user.login)
    }
}