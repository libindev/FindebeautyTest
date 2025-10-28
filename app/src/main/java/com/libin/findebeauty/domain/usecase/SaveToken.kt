package com.libin.findebeauty.domain.usecase


import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveToken @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(token: String): Flow<Resource<Unit>> = loginRepository.saveToken(token)
}
