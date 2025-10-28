# FindebeautyTest

This is an Android application that helps users find beauty products and services.

## Features

- View a home screen with a list of beauty products or services.
- Location-based search using latitude and longitude.
- Filter by city.
- A dummy login feature to demonstrate secure token storage.

## Screenshots

**Home Screen**

![Home Screen](screenshots/home_screen.png)

## How to Run

1. **Clone the repository.**
2. **Open in Android Studio:** Open the cloned project in Android Studio.
3. **Add your Dummy Token:**
    * Navigate to the
      `app/src/main/java/com/libin/findebeauty/presentation/ui/screen/LoginFragment.kt` file.
    * Find the `DUMMY_TOKEN` constant inside the `companion object`.
    * Paste your API token into the empty string for the `DUMMY_TOKEN` constant.
      ```kotlin
      private const val DUMMY_TOKEN = "PASTE_YOUR_TOKEN_HERE"
      ```
4. **Build and Run:** Build and run the application on an emulator or a physical device.

## Libraries Used

- [Hilt](https://dagger.dev/hilt/) for Dependency Injection
- [Retrofit](https://square.github.io/retrofit/) for Networking
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for Asynchronous Programming
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  and [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) for
  Lifecycle-Aware Data
- [Coil](https://coil-kt.github.io/coil/) for Image Loading
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) for Preferences
- [Navigation Component](https://developer.android.com/guide/navigation) for In-App Navigation
- [Material Components](https://material.io/develop/android) for UI Components
- AndroidX Libraries (Core KTX, AppCompat, Activity KTX, ConstraintLayout)

## Dummy Login and Token Encryption

The app includes a dummy login feature to demonstrate how to securely save and retrieve an
authentication token.

- **Keystore:** The app uses the Android Keystore system to securely store cryptographic keys.
- **CryptoManager:** A `CryptoManager` class is used to encrypt and decrypt the authentication
  token. This class handles the creation and management of the secret key in the Keystore.
- **DataStore:** The encrypted token is stored in Jetpack DataStore, which is a data storage
  solution that allows for asynchronous and transactional data storage.
- **PreferenceStorageManager:** A `PreferenceStorageManager` class is used to interact with
  DataStore to save and retrieve the encrypted token.

This approach ensures that the authentication token is stored securely on the device and is
protected from unauthorized access.