package com.samueljuma.basenetworkapp.data.network

import com.samueljuma.basenetworkapp.utils.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class APIService(
    private val client: HttpClient
) {
    suspend fun fetchTodos() = client.get("/todos")
}