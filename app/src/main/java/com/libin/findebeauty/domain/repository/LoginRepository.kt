package com.libin.findebeauty.domain.repository

import com.libin.findebeauty.core.Resource
import kotlinx.coroutines.flow.Flow


interface LoginRepository {
    fun saveToken(token: String): Flow<Resource<Unit>>
}
