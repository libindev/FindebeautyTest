package com.libin.findebeauty.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.libin.findebeauty.core.CryptoManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Base64
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PreferenceStorageManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val cryptoManager: CryptoManager
) {

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("encrypted_token")
    }

    fun getToken(): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[TOKEN_KEY]?.let {
                cryptoManager.decrypt(Base64.getDecoder().decode(it))?.decodeToString()
            }
        }
    }

    suspend fun saveToken(token: String) {
        val encryptedToken = Base64.getEncoder().encodeToString(cryptoManager.encrypt(token.toByteArray()))
        context.dataStore.edit {
            it[TOKEN_KEY] = encryptedToken
        }
    }
}