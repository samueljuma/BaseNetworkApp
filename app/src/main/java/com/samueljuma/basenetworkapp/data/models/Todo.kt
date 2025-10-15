package com.samueljuma.basenetworkapp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val userId: String,
    val id: String,
    val title: String,
    val completed: String
)