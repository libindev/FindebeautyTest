package com.libin.findebeauty.data.repository


import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.data.local.PreferenceStorageManager
import com.libin.findebeauty.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val preferenceStorageManager: PreferenceStorageManager
) : LoginRepository {
    override suspend fun saveToken(token: String): Resource<Unit> {
        try {
            preferenceStorageManager.saveToken(token)
            return Resource.Success(Unit)
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "Something went wrong")
        }

    }
}