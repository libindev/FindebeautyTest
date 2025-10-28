package com.libin.findebeauty.data.repository


import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.data.local.PreferenceStorageManager
import com.libin.findebeauty.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val preferenceStorageManager: PreferenceStorageManager
) : LoginRepository {
    override fun saveToken(token: String): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            preferenceStorageManager.saveToken(token)
            emit(Resource.Success(Unit))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Something went wrong"))
        }

    }
}