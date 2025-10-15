# BaseNetworkApp

> BaseNetworkApp is a Kotlin-based Android starter project designed to serve as a foundation for new applications. By cloning this repository, you can avoid repetitive tasks such as setting up dependencies, dependency injection (DI), navigation, manifest configurations, and more. The project is structured to help you rapidly bootstrap your own apps with modern Android architecture and best practices.

## Features

- **Dependency Injection with Koin:** All core dependencies are managed via Koin modules for easy scalability and testing.
- **Network Layer:** Includes a preconfigured [Ktor](https://ktor.io/) HTTP client with logging and JSON serialization.
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
│   │   │   ├── data/network/         # Network API & client
│   │   │   ├── data/repositories/    # Data repositories
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
- **AppModules.kt:** Registers dependencies (network client, API service, repository, ViewModel).
- **AppNavigation.kt:** Configures navigation between screens.
- **APIService.kt & HttpClientProvider.kt:** Handles network requests using Ktor.
- **TodosViewModel & TodoRepository:** Example ViewModel and repository pattern for API data.
- **Theme.kt & Type.kt:** Custom Material 3 Compose theming and typography.

## Example: Adding a New Screen

1. Create a new Composable in `ui/screens/`.
2. Add a route in `AppScreens.kt`.
3. Register your screen in `AppNavigation.kt`.

## Customization

- **Dependencies:** Managed in Gradle files, update as needed for your project.
- **DI Modules:** Add new singletons or ViewModels in `AppModules.kt`.
- **Networking:** Swap out `APIService.kt` for your backend endpoints.
- **UI Theme:** Customize colors and typography in `ui/theme/`.
---

Start with BaseNetworkApp to save time and focus on your app's features!