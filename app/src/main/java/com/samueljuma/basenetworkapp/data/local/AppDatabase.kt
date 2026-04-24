package com.samueljuma.basenetworkapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samueljuma.basenetworkapp.data.local.dao.TodoDao
import com.samueljuma.basenetworkapp.data.local.entities.TodoEntity

@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
