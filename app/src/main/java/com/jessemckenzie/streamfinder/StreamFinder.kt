package com.jessemckenzie.streamfinder

import android.app.Application
import com.jessemckenzie.streamfinder.data.MediaRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class StreamFinder : Application() {
    private val client: HttpClient = HttpClient {

        install(ContentNegotiation) {
            gson()
        }
    }
    val mediaRepository by lazy {
        MediaRepository(client)
    }
}