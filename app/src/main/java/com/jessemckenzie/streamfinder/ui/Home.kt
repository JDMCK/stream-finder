package com.jessemckenzie.streamfinder.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "Welcome to\nStream Finder!",
            textAlign = TextAlign.Center,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(150.dp))
        Button(modifier = Modifier.width(200.dp).height(50.dp),
            onClick = {
            navController.navigate(Screens.SEARCH.route)
        }) {
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Search", fontSize = 18.sp)
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Go to search"
                )
            }
        }
    }
}