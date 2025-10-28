package com.libin.findebeauty.data.repository


import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.data.model.toDomain
import com.libin.findebeauty.data.remote.ApiService
import com.libin.findebeauty.domain.model.Home
import com.libin.findebeauty.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : HomeRepository {
    override fun getHomePageData(
        lat: Double,
        logt: Double,
        lang: String,
        cityId: Int,
        all: Int
    ): Flow<Resource<Home>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiService.getHomePageData(
                lang = lang,
                lat = lat,
                logt = logt,
                cityId = cityId,
                all = all
            )
            if (response.isSuccessful) {
                val home = response.body()?.data?.toDomain()
                if (home != null) {
                    emit(Resource.Success(home))
                } else {
                    emit(Resource.Error("Empty response body"))
                }
            } else {
                emit(Resource.Error("API Error: ${response.code()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Network Error: ${e.message}"))
        }
    }
}