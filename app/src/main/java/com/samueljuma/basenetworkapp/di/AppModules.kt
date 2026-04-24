package com.samueljuma.basenetworkapp.di

import androidx.room.Room
import com.samueljuma.basenetworkapp.data.local.AppDatabase
import com.samueljuma.basenetworkapp.data.network.APIService
import com.samueljuma.basenetworkapp.data.network.HttpClientProvider
import com.samueljuma.basenetworkapp.data.repositories.TodoLocalRepository
import com.samueljuma.basenetworkapp.data.repositories.TodoLocalRepositoryImpl
import com.samueljuma.basenetworkapp.data.repositories.TodoRepository
import com.samueljuma.basenetworkapp.data.repositories.TodoRepositoryImpl
import com.samueljuma.basenetworkapp.ui.screens.TodosViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { HttpClientProvider.create() }
    single { APIService(get()) }
    single { Dispatchers.IO }
    single<TodoRepository> { TodoRepositoryImpl(get(), get()) }
    viewModel { TodosViewModel(get()) }

    // Room
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
    single { get<AppDatabase>().todoDao() }
    single<TodoLocalRepository> { TodoLocalRepositoryImpl(get(), get()) }
}