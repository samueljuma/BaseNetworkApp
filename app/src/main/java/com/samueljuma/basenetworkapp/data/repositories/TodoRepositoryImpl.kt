package com.samueljuma.basenetworkapp.data.repositories

import com.samueljuma.basenetworkapp.data.models.Todo
import com.samueljuma.basenetworkapp.data.network.APIService
import com.samueljuma.basenetworkapp.data.network.NetworkResult
import com.samueljuma.basenetworkapp.data.network.safeApiCall
import io.ktor.client.call.body
import kotlinx.coroutines.CoroutineDispatcher
import io.ktor.http.HttpStatusCode


interface TodoRepository {
    suspend fun fetchTodos(): NetworkResult<List<Todo>>
}

class TodoRepositoryImpl(
    private val apiService: APIService,
    private val dispatcher: CoroutineDispatcher
) : TodoRepository {
    override suspend fun fetchTodos(): NetworkResult<List<Todo>> {
        return safeApiCall(dispatcher) {
            val response = apiService.fetchTodos()
            when (response.status) {
                HttpStatusCode.OK -> {
                    val todos = response.body<List<Todo>>()
                    NetworkResult.Success(todos)
                }
                else -> {
                    NetworkResult.Error("Something went wrong")
                }
            }
        }
    }
}