package com.jessemckenzie.streamfinder.data

import android.util.Log

const val API_KEY: String = "API_KEY_HERE"

enum class Endpoints(val url: String) {
    BASE_URL("https://api.watchmode.com/v1/"),
    SEARCH_BY_TITLE("${BASE_URL.url}search/?search_field=name&types=tv,movie&search_value=%s&apiKey=%s"),
    GET_TITLE_INFO("${BASE_URL.url}title/%s/details/?apiKey=%s&append_to_response=sources");

    fun fields(search: String): String {
        val formattedURL = url.format(search, API_KEY)
        Log.d("API Call", formattedURL)
        return url.format(search, API_KEY)
    }
}