package com.jessemckenzie.streamfinder.data

import com.google.gson.annotations.SerializedName

// For SEARCH_BY_TITLE
data class TitleSearchResults(
    @SerializedName("title_results")
    val titleResults: List<TitleSearchResult>
)

data class TitleSearchResult(
    val name: String,
    val id: Int,
    val year: Int,
    val type: String
)

// For GET_TITLE_INFO
data class TitleInfo(
    val id: Int,
    val title: String,
    @SerializedName("plot_overview")
    val plotOverview: String,
    val type: String,
    @SerializedName("user_rating")
    val userRating: Float,
    val poster: String,
    val posterMedium: String?,
    val posterLarge: String?,
    val backdrop: String,
    val sources: List<StreamingService>
)

data class StreamingService(
    @SerializedName("source_id")
    val id: Int,
    val name: String,
    val region: String
)