package com.jessemckenzie.streamfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jessemckenzie.streamfinder.ui.Home
import com.jessemckenzie.streamfinder.ui.Screens
import com.jessemckenzie.streamfinder.ui.Search
import com.jessemckenzie.streamfinder.ui.TopBar
import com.jessemckenzie.streamfinder.ui.state.MediaState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaRepository = (application as StreamFinder).mediaRepository
        setContent {
            val mediaState = MediaState(mediaRepository)

            MainContent(mediaState)
        }
    }

    @Composable
    fun MainContent(mediaState: MediaState) {

        val navController = rememberNavController()

        Scaffold(
            topBar = {
                TopBar(navController)
            }
        ) {
            padding ->

            NavHost(
                navController = navController,
                startDestination = Screens.HOME.route,
                modifier = Modifier.padding(padding)
            ) {

                composable(Screens.HOME.route) {
                    Home(navController)
                }

                composable(Screens.SEARCH.route) {
                    Search(navController, mediaState)
                }

                composable(Screens.TITLE_INFO.route) {
                    TitleInfo(navController, mediaState)
                }
            }
        }
    }
}