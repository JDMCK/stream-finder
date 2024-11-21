package com.jessemckenzie.streamfinder.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jessemckenzie.streamfinder.data.TitleSearchResult
import com.jessemckenzie.streamfinder.ui.state.MediaState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(navController: NavController, mediaState: MediaState) {
    val coroutineScope = rememberCoroutineScope()

    SearchBar(
        query = mediaState.searchValue,
        onQueryChange = mediaState.onSearchValueChanged,
        onSearch = {
            coroutineScope.launch() {
                mediaState.searchByTitle(it)
            }
        },
        active = true,
        onActiveChange = {},
    ) {
        Text("Search for a Movie or TV Show by title", modifier = Modifier.padding(5.dp))
        Button(modifier = Modifier.width(150.dp).align(Alignment.End).padding(horizontal = 5.dp),
            onClick = {
            coroutineScope.launch {
                mediaState.searchByTitle(mediaState.searchValue)
            }
        }) {
            Text("Search", fontSize = 15.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (mediaState.titleSearchResults.isEmpty()) {
            Text("No results available.",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
        } else {
            LazyColumn {
                items(mediaState.titleSearchResults.size) {
                    SearchResultCard(mediaState.titleSearchResults[it]) {
                        coroutineScope.launch {
                            mediaState.getTitleInfo(it)
                        }
                        navController.navigate(Screens.TITLE_INFO.route)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchResultCard(title: TitleSearchResult, onClick: (Int) -> Unit) {

    fun String.truncateEllipsis(n: Int): String {
        if (this.length <= n) return this
        return this.substring(0, n) + "..."
    }

    Card(modifier = Modifier
        .padding(horizontal = 15.dp, vertical = 5.dp)
        .fillMaxWidth()
        .height(75.dp),
        onClick = { onClick(title.id) }) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(title.name.truncateEllipsis(40), fontSize = 18.sp)
            Text(if (title.year != 0) title.year.toString() else "Unreleased", fontSize = 13.sp)
            Text(title.type, fontSize = 15.sp, fontStyle = FontStyle.Italic)
        }
    }
}