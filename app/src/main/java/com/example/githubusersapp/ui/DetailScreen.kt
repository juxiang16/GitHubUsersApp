package com.example.githubusersapp.ui
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.example.githubusersapp.data.model.DetailUser
import com.example.githubusersapp.data.repository.UserRepository

@Composable
fun DetailScreen(
    login: String
) {

    // Step4
    val repository = UserRepository()

    // Step5
    var user by remember {
        mutableStateOf<DetailUser?>(null)
    }

    // Step6
    LaunchedEffect(login) {
        user = repository.getUser(login)
    }

    if (user == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Loading...")
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = user!!.avatar_url,
            contentDescription = null,
            modifier = Modifier.size(140.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = user!!.name ?: "名前なし"
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Login : ${user!!.login}")
        Text("Followers : ${user!!.followers}")
        Text("Following : ${user!!.following}")
        Text("Repositories : ${user!!.public_repos}")
        Text("Location : ${user!!.location ?: "なし"}")
        Text("Bio : ${user!!.bio ?: "なし"}")
    }
}
