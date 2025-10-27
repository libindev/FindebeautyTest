package com.libin.findebeauty.domain.repository

import com.libin.findebeauty.core.Resource


interface LoginRepository {
    suspend fun saveToken(token: String): Resource<Unit>
}
