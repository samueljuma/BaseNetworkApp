package com.samueljuma.basenetworkapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samueljuma.basenetworkapp.data.repositories.TodoRepository
import kotlinx.coroutines.launch

class TodosViewModel(
    private val todoRepository: TodoRepository
): ViewModel() {

    fun fetchTodos() {
        viewModelScope.launch {
            todoRepository.fetchTodos()
        }
    }

}