package com.jessemckenzie.streamfinder.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MediaRepository(private val client: HttpClient) {

    suspend fun searchByTitle(title: String): TitleSearchResults {
        val response = client.get(Endpoints.SEARCH_BY_TITLE.fields(title))
        val json = response.body<JsonObject>().toString()
        /* val json = """
            {
              "title_results": [
                {
                  "resultType": "title",
                  "id": 3173903,
                  "name": "Breaking Bad",
                  "type": "tv_series",
                  "year": 2008,
                  "imdb_id": "tt0903747",
                  "tmdb_id": 1396,
                  "tmdb_type": "tv"
                },
                {
                  "resultType": "title",
                  "id": 3203841,
                  "name": "Breaking Bad Fortune Teller",
                  "type": "tv_series",
                  "year": 2016,
                  "imdb_id": null,
                  "tmdb_id": 232533,
                  "tmdb_type": "tv"
                },
                {
                  "resultType": "title",
                  "id": 1770490,
                  "name": "Breaking Bad",
                  "type": "movie",
                  "year": null,
                  "imdb_id": null,
                  "tmdb_id": 1215230,
                  "tmdb_type": "movie"
                },
                {
                  "resultType": "title",
                  "id": 4146033,
                  "name": "Breaking Bad Wolf",
                  "type": "tv_movie",
                  "year": 2018,
                  "imdb_id": "tt9746510",
                  "tmdb_id": 635602,
                  "tmdb_type": "movie"
                },
                {
                  "resultType": "title",
                  "id": 1801911,
                  "name": "Breaking Bad - The Movie",
                  "type": "movie",
                  "year": null,
                  "imdb_id": null,
                  "tmdb_id": 1260224,
                  "tmdb_type": "movie"
                },
                {
                  "resultType": "title",
                  "id": 1772044,
                  "name": "Breaking Bad: The Movie",
                  "type": "movie",
                  "year": null,
                  "imdb_id": null,
                  "tmdb_id": 1217466,
                  "tmdb_type": "movie"
                },
                {
                  "resultType": "title",
                  "id": 1822702,
                  "name": "Breaking Bad Remake",
                  "type": "movie",
                  "year": null,
                  "imdb_id": null,
                  "tmdb_id": 1290123,
                  "tmdb_type": "movie"
                },
                {
                  "resultType": "title",
                  "id": 1780653,
                  "name": "Breaking Bad Universe TRIVIA FACE OFF - Beat Rice VS HN Films",
                  "type": "movie",
                  "year": null,
                  "imdb_id": null,
                  "tmdb_id": 1229872,
                  "tmdb_type": "movie"
                },
                {
                  "resultType": "title",
                  "id": 1755197,
                  "name": "Breaking Bad: The Movie",
                  "type": "movie",
                  "year": null,
                  "imdb_id": null,
                  "tmdb_id": 1193090,
                  "tmdb_type": "movie"
                }
              ],
              "people_results": []
            }
        """.trimIndent() */
        Log.d("JSON: Search by Title", json)
        return Gson().fromJson(json, TitleSearchResults::class.java)
    }

    suspend fun getTitleInfo(titleID: String): TitleInfo {
        val response = client.get(Endpoints.GET_TITLE_INFO.fields(titleID))
        val json = response.body<JsonObject>().toString()
        /* val json = """
            {
              "id": 3173903,
              "title": "Breaking Bad",
              "original_title": "Breaking Bad",
              "plot_overview": "Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
              "type": "tv_series",
              "runtime_minutes": null,
              "year": 2008,
              "end_year": 2013,
              "release_date": "2008-01-20",
              "imdb_id": "tt0903747",
              "tmdb_id": 1396,
              "tmdb_type": "tv",
              "genres": [7, 5, 17],
              "genre_names": [
                "Drama",
                "Crime",
                "Thriller"
              ],
              "user_rating": 9.3,
              "critic_score": 92,
              "us_rating": "TV-MA",
              "poster": "https://cdn.watchmode.com/posters/03173903_poster_w185.jpg",
              "posterMedium": "https://cdn.watchmode.com/posters/03173903_poster_w342.jpg",
              "posterLarge": "https://cdn.watchmode.com/posters/03173903_poster_w780.jpg",
              "backdrop": "https://cdn.watchmode.com/backdrops/03173903_bd_w780.jpg",
              "original_language": "en",
              "similar_titles": [1122525, 1276287, 1286429, 1310542, 1346993, 1387087, 1425483, 1586594, 313542, 330948, 340865, 345534, 350396, 381024, 383653, 390224, 3109684, 3129354, 3130921, 3131293, 3140350, 3177706, 519773, 520325, 537712],
              "networks": [8],
              "network_names": [
                "AMC"
              ],
              "relevance_percentile": 99.27,
              "popularity_percentile": 99.933,
              "trailer": "https://www.youtube.com/watch?v=ZbngCYyyKag",
              "trailer_thumbnail": "https://cdn.watchmode.com/video_thumbnails/2204319_pthumbnail_320.jpg",
              "sources": [
                {
                  "source_id": 203,
                  "name": "Netflix",
                  "type": "sub",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.netflix.com/watch/70236428",
                  "format": "4K",
                  "price": null,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 425,
                  "name": "Stan",
                  "type": "sub",
                  "region": "AU",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.stan.com.au/watch/breaking-bad/season-1",
                  "format": "4K",
                  "price": null,
                  "seasons": 4,
                  "episodes": 46
                },
                {
                  "source_id": 203,
                  "name": "Netflix",
                  "type": "sub",
                  "region": "BR",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.netflix.com/title/70143836",
                  "format": "4K",
                  "price": null,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 203,
                  "name": "Netflix",
                  "type": "sub",
                  "region": "CA",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.netflix.com/title/70143836",
                  "format": "4K",
                  "price": null,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 203,
                  "name": "Netflix",
                  "type": "sub",
                  "region": "GB",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.netflix.com/watch/70196252",
                  "format": "4K",
                  "price": null,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 203,
                  "name": "Netflix",
                  "type": "sub",
                  "region": "ES",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.netflix.com/title/70143836",
                  "format": "4K",
                  "price": null,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 349,
                  "name": "AppleTV",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://tv.apple.com/us/episode/umc.cmc.3lc7xx6fxzohifz171koat0pf?itsct=&itscg=30200&at=1010layx",
                  "format": "HD",
                  "price": 2.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 24,
                  "name": "Amazon",
                  "type": "buy",
                  "region": "GB",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.amazon.co.uk/gp/video/detail/amzn1.dv.gti.5ca9f67b-7c7a-2ec5-8a9c-0c6635724c24?tag=",
                  "format": "SD",
                  "price": 1.89,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 24,
                  "name": "Amazon",
                  "type": "buy",
                  "region": "GB",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.amazon.co.uk/gp/video/detail/amzn1.dv.gti.5ca9f67b-7c7a-2ec5-8a9c-0c6635724c24?tag=",
                  "format": "HD",
                  "price": 2.49,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 140,
                  "name": "Google Play",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://play.google.com/store/tv/show?id=L2wfgMDGiBk&cdid=tvseason-QloudPiQicc&gdid=tvepisode-9VYSQkZP4Gc&PAffiliateID=1101l32vn",
                  "format": "HD",
                  "price": 2.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 140,
                  "name": "Google Play",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://play.google.com/store/tv/show?id=L2wfgMDGiBk&cdid=tvseason-QloudPiQicc&gdid=tvepisode-9VYSQkZP4Gc&PAffiliateID=1101l32vn",
                  "format": "SD",
                  "price": 1.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 307,
                  "name": "VUDU",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.vudu.com/content/movies/details/content/353922",
                  "format": "SD",
                  "price": 1.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 307,
                  "name": "VUDU",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.vudu.com/content/movies/details/content/353922",
                  "format": "HD",
                  "price": 2.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 24,
                  "name": "Amazon",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.amazon.com/gp/video/detail/amzn1.dv.gti.9aa9f77a-dc91-b172-9a35-b9a6f34728b8?tag=",
                  "format": "SD",
                  "price": 1.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 24,
                  "name": "Amazon",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.amazon.com/gp/video/detail/amzn1.dv.gti.9aa9f77a-dc91-b172-9a35-b9a6f34728b8?tag=",
                  "format": "HD",
                  "price": 2.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 24,
                  "name": "Amazon",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.amazon.com/gp/video/detail/amzn1.dv.gti.9aa9f77a-dc91-b172-9a35-b9a6f34728b8?tag=",
                  "format": "4K",
                  "price": 3.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 349,
                  "name": "AppleTV",
                  "type": "buy",
                  "region": "CA",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://tv.apple.com/ca/episode/pilot/umc.cmc.6trodclp7sphpy2gelbgwb4fk?at=1000l3V2&ct=app_tv&itscg=30200&itsct=&playableId=tvs.sbd.9001%3A942900448&showId=umc.cmc.1v90fu25sgywa1e14jwnrt9uc",
                  "format": "HD",
                  "price": 3.49,
                  "seasons": 5,
                  "episodes": 54
                },
                {
                  "source_id": 349,
                  "name": "AppleTV",
                  "type": "buy",
                  "region": "GB",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://tv.apple.com/gb/episode/umc.cmc.6trodclp7sphpy2gelbgwb4fk",
                  "format": "SD",
                  "price": 1.89,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 349,
                  "name": "AppleTV",
                  "type": "buy",
                  "region": "GB",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://tv.apple.com/gb/episode/umc.cmc.6trodclp7sphpy2gelbgwb4fk",
                  "format": "HD",
                  "price": 2.49,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 349,
                  "name": "AppleTV",
                  "type": "buy",
                  "region": "AU",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://tv.apple.com/au/episode/pilot/umc.cmc.6trodclp7sphpy2gelbgwb4fk?at=1000l3V2&ct=app_tv&itscg=30200&itsct=&playableId=tvs.sbd.9001%3A291565398&showId=umc.cmc.1v90fu25sgywa1e14jwnrt9uc",
                  "format": "HD",
                  "price": 3.49,
                  "seasons": 4,
                  "episodes": 43
                },
                {
                  "source_id": 436,
                  "name": "Fetch TV",
                  "type": "buy",
                  "region": "AU",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.fetchtv.com.au/season/details/35918",
                  "format": "SD",
                  "price": 2.99,
                  "seasons": 4,
                  "episodes": 46
                },
                {
                  "source_id": 398,
                  "name": "Windows Store",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.microsoft.com/en-us/p/Season%201/8D6KGWXCMRFX?episode=8D6KGWXCMRZ1",
                  "format": "HD",
                  "price": 2.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 398,
                  "name": "Windows Store",
                  "type": "buy",
                  "region": "US",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.microsoft.com/en-us/p/Season%201/8D6KGWXCMRFX?episode=8D6KGWXCMRZ1",
                  "format": "SD",
                  "price": 1.99,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 398,
                  "name": "Windows Store",
                  "type": "buy",
                  "region": "GB",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.microsoft.com/en-gb/p/Series%201/8D6KGWXCMRFX?episode=8D6KGWXCMRZ1",
                  "format": "HD",
                  "price": 2.49,
                  "seasons": 5,
                  "episodes": 62
                },
                {
                  "source_id": 398,
                  "name": "Windows Store",
                  "type": "buy",
                  "region": "GB",
                  "ios_url": "Deeplinks available for paid plans only.",
                  "android_url": "Deeplinks available for paid plans only.",
                  "web_url": "https://www.microsoft.com/en-gb/p/Series%201/8D6KGWXCMRFX?episode=8D6KGWXCMRZ1",
                  "format": "SD",
                  "price": 1.89,
                  "seasons": 5,
                  "episodes": 62
                }
              ]
            }
        """.trimIndent() */
        Log.d("JSON: Title Info", json)
        return Gson().fromJson(json, TitleInfo::class.java)
    }
}