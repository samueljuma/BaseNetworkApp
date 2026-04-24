# BaseNetworkApp

> BaseNetworkApp is a Kotlin-based Android starter project designed to serve as a foundation for new applications. By cloning this repository, you can avoid repetitive tasks such as setting up dependencies, dependency injection (DI), navigation, manifest configurations, and more. The project is structured to help you rapidly bootstrap your own apps with modern Android architecture and best practices.

## Features

- **Dependency Injection with Koin:** All core dependencies are managed via Koin modules for easy scalability and testing.
- **Network Layer:** Includes a preconfigured [Ktor](https://ktor.io/) HTTP client with logging and JSON serialization.
- **Local Database with Room:** Pre-wired Room database with a sample entity, DAO, and local repository for offline-first patterns.
- **MVVM Architecture:** Separation of concerns with ViewModels and Repositories.
- **Jetpack Compose UI:** Out-of-the-box Compose setup with custom theming and navigation.
- **Navigation:** Simple and extensible navigation structure using Jetpack Compose Navigation.
- **Manifest & Project Configurations:** Standard Android manifest and Gradle settings for a quick start.
- **Sample API Integration:** Includes a sample API service to fetch data from [JSONPlaceholder](https://jsonplaceholder.typicode.com).

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/samueljuma/basenetworkapp/
│   │   │   ├── data/
│   │   │   │   ├── local/
│   │   │   │   │   ├── dao/          # Room DAOs
│   │   │   │   │   ├── entities/     # Room entities (@Entity)
│   │   │   │   │   └── AppDatabase.kt  # Room database definition
│   │   │   │   ├── models/           # Network/domain models
│   │   │   │   ├── network/          # Ktor API client & utils
│   │   │   │   └── repositories/     # Network & local repositories
│   │   │   ├── di/                   # Koin DI modules
│   │   │   ├── ui/navigation/        # Navigation setup
│   │   │   ├── ui/screens/           # Composable screens
│   │   │   ├── ui/theme/             # Custom Compose theme
│   │   │   ├── utils/                # Constants and utilities
│   │   │   └── BaseNetworkApplication.kt  # App entry point
│   │   ├── res/                      # Resources (drawables, layouts, etc.)
│   ├── androidTest/                  # Instrumentation tests
│   ├── test/                         # Unit tests
```

## Getting Started

### 1. Clone the Repository

```sh
git clone https://github.com/samueljuma/BaseNetworkApp.git
cd BaseNetworkApp
```

### 2. Open in Android Studio

Open the project in [Android Studio](https://developer.android.com/studio) (Arctic Fox or newer recommended).

### 3. Run the App

- Connect your device or start an emulator.
- Click the "Run" button in Android Studio.

### 4. Start Building Your App

- Replace or extend the sample screens (`FirstScreen`, `SecondScreen`) and ViewModels.
- Add your own modules to `AppModules.kt` for DI.
- Update the `BASE_URL` in `Constants.kt` for your API.
- Add new navigation routes to `AppScreens.kt`.

## Key Components

- **BaseNetworkApplication.kt:** Initializes Koin DI and sets up modules.
- **AppModules.kt:** Registers dependencies (network client, API service, Room database, DAOs, repositories, ViewModel).
- **AppNavigation.kt:** Configures navigation between screens.
- **APIService.kt & HttpClientProvider.kt:** Handles network requests using Ktor.
- **TodosViewModel & TodoRepository:** Example ViewModel and repository pattern for API data.
- **AppDatabase.kt:** Room database entry point. Add new entities and DAOs here.
- **TodoEntity & TodoDao:** Sample Room entity and DAO demonstrating CRUD + reactive `Flow` queries.
- **TodoLocalRepository:** Local data repository wrapping the DAO with coroutine dispatcher scoping.
- **Theme.kt & Type.kt:** Custom Material 3 Compose theming and typography.

## Example: Adding a New Screen

1. Create a new Composable in `ui/screens/`.
2. Add a route in `AppScreens.kt`.
3. Register your screen in `AppNavigation.kt`.

## Room Database

Room is pre-configured and wired through Koin DI. To extend it for your own data:

### Adding a New Entity

1. Create a data class annotated with `@Entity` in `data/local/entities/`.
2. Add the entity to the `entities` list in `AppDatabase.kt`.
3. Increment the `version` and provide a `Migration` if you already have data.

```kotlin
@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String
)
```

### Adding a DAO

Create an interface annotated with `@Dao` in `data/local/dao/` and expose it via `AppDatabase`:

```kotlin
@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteEntity)
}
```

### Registering with Koin

Add the DAO and repository bindings to `AppModules.kt`:

```kotlin
single { get<AppDatabase>().noteDao() }
single<NoteLocalRepository> { NoteLocalRepositoryImpl(get(), get()) }
```

### Database Name

The database is created with the name `app_database`. Change the name in `AppModules.kt` if needed.

---

## Customization

- **Dependencies:** Managed in `gradle/libs.versions.toml`, update as needed for your project.
- **DI Modules:** Add new singletons or ViewModels in `AppModules.kt`.
- **Networking:** Swap out `APIService.kt` for your backend endpoints.
- **Room:** Extend `AppDatabase` with new entities and DAOs. Koin handles injection automatically.
- **UI Theme:** Customize colors and typography in `ui/theme/`.
---

Start with BaseNetworkApp to save time and focus on your app's features!