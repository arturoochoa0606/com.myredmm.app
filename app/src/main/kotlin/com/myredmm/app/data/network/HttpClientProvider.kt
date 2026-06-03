package com.myredmm.app.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.defaultRequest

object HttpClientProvider {
    val httpClient: HttpClient by lazy {
        HttpClient(Android) {
            defaultRequest {
                // Configure default request settings
            }
        }
    }
}
