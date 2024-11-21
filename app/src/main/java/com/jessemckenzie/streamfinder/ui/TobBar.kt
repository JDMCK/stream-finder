package com.jessemckenzie.streamfinder.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    CenterAlignedTopAppBar(
        title = {
            Text("StreamFinder")
        },
        navigationIcon = {
            if (currentRoute != Screens.HOME.route) {
                IconButton(onClick = {
                    navController.navigate(
                        when (currentRoute) {
                            Screens.SEARCH.route -> Screens.HOME.route
                            Screens.TITLE_INFO.route -> Screens.SEARCH.route
                            else -> Screens.HOME.route
                        }
                    )
                }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go back"
                    )
                }
            } else null
        },
        actions = {
            IconButton(enabled = currentRoute != Screens.HOME.route,
                onClick = {
                navController.navigate(Screens.HOME.route)
            }) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home"
                )
            }
            IconButton(enabled = currentRoute != Screens.SEARCH.route,
                onClick = {
                navController.navigate(Screens.SEARCH.route)
            }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}