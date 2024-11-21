package com.jessemckenzie.streamfinder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.jessemckenzie.streamfinder.data.StreamingService
import com.jessemckenzie.streamfinder.ui.state.MediaState

@Composable
fun TitleInfo(navController: NavController, mediaState: MediaState) {

    val titleInfo = mediaState.titleInfo.value

    if (titleInfo == null)
        return Text("No information about this title is available.",
            fontSize = 30.sp,
            textAlign = TextAlign.Center)


    Column(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = titleInfo.backdrop,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column(modifier = Modifier.padding(10.dp)) {
            Text(titleInfo.title, fontSize = 30.sp)
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider()
            Text("Streaming Services:", fontSize = 25.sp)
            Spacer(modifier = Modifier.height(15.dp))
            LazyColumn {
                items(titleInfo.sources.size) {
                    val sortedSources = titleInfo.sources.sortedWith {
                        source1, source2 ->
                        source1.region.compareTo(source2.region)
                    }
                    SourceCard(sortedSources[it])
                }
            }
        }
    }
}

@Composable
fun SourceCard(service: StreamingService) {
    Row(modifier = Modifier.padding(5.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(service.name, fontSize = 18.sp)
        Text(service.region, fontSize = 15.sp, fontStyle = FontStyle.Italic)
    }
    HorizontalDivider()
}