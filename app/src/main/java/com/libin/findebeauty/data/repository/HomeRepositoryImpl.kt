package com.libin.findebeauty.data.repository


import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.data.model.toDomain
import com.libin.findebeauty.data.remote.ApiService
import com.libin.findebeauty.domain.model.Home
import com.libin.findebeauty.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : HomeRepository {
    override suspend fun getHomePageData(
        lat: Double,
        logt: Double,
        lang: String,
        cityId: Int,
        all: Int
    ): Resource<Home> {
        return try {
            val response = apiService.getHomePageData(
                lang = "en",
                lat = lat,
                logt = logt,
                cityId = -1,
                all = -1
            )
            if (response.isSuccessful) {
                val home = response.body()?.data?.toDomain()
                if (home != null) {
                    Resource.Success(home)
                } else {
                    Resource.Error("Empty response body")
                }
            } else {
                Resource.Error("API Error: ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network Error: ${e.message}")
        }
    }
}