package com.example.githubusersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubusersapp.ui.theme.GitHubUsersAppTheme
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import android.util.Log
import com.example.githubusersapp.data.repository.UserRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect
import com.example.githubusersapp.data.model.User
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import coil.compose.AsyncImage
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import com.example.githubusersapp.ui.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = UserRepository()
        setContent {
            val navController = rememberNavController()
            AppNavigation(navController)
        }
    }
}