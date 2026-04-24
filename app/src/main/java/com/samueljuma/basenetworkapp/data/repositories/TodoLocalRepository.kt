package com.samueljuma.basenetworkapp.data.repositories

import com.samueljuma.basenetworkapp.data.local.dao.TodoDao
import com.samueljuma.basenetworkapp.data.local.entities.TodoEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface TodoLocalRepository {
    fun getTodos(): Flow<List<TodoEntity>>
    suspend fun getTodoById(id: Int): TodoEntity?
    suspend fun saveTodo(todo: TodoEntity)
    suspend fun saveTodos(todos: List<TodoEntity>)
    suspend fun updateTodo(todo: TodoEntity)
    suspend fun deleteTodo(todo: TodoEntity)
    suspend fun clearTodos()
}

class TodoLocalRepositoryImpl(
    private val todoDao: TodoDao,
    private val dispatcher: CoroutineDispatcher
) : TodoLocalRepository {

    override fun getTodos(): Flow<List<TodoEntity>> = todoDao.getAll()

    override suspend fun getTodoById(id: Int): TodoEntity? = withContext(dispatcher) {
        todoDao.getById(id)
    }

    override suspend fun saveTodo(todo: TodoEntity) = withContext(dispatcher) {
        todoDao.insert(todo)
    }

    override suspend fun saveTodos(todos: List<TodoEntity>) = withContext(dispatcher) {
        todoDao.insertAll(todos)
    }

    override suspend fun updateTodo(todo: TodoEntity) = withContext(dispatcher) {
        todoDao.update(todo)
    }

    override suspend fun deleteTodo(todo: TodoEntity) = withContext(dispatcher) {
        todoDao.delete(todo)
    }

    override suspend fun clearTodos() = withContext(dispatcher) {
        todoDao.clearAll()
    }
}
