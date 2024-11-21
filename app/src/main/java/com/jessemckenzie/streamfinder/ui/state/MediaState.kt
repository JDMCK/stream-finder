package com.jessemckenzie.streamfinder.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.jessemckenzie.streamfinder.data.MediaRepository
import com.jessemckenzie.streamfinder.data.TitleInfo
import com.jessemckenzie.streamfinder.data.TitleSearchResult

class MediaState(private val mediaRepository: MediaRepository) {

    var searchValue by mutableStateOf("")
    val onSearchValueChanged: (String) -> Unit = { searchValue = it }

    var titleSearchResults = mutableStateListOf<TitleSearchResult>()
    var titleInfo = mutableStateOf<TitleInfo?>(null)

    suspend fun searchByTitle(title: String) {
        titleSearchResults.also {
            it.clear()
            it.addAll(mediaRepository.searchByTitle(title).titleResults)
        }
    }

    suspend fun getTitleInfo(titleID: Int) {
        titleInfo.value = mediaRepository.getTitleInfo(titleID.toString())
    }
}