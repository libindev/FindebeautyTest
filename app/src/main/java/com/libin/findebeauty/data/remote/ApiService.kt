package com.libin.findebeauty.data.remote

import com.libin.findebeauty.data.model.HomeResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("user/get-HomePageData-authorized")
    suspend fun getHomePageData(
        @Query("Lang") lang: String,
        @Query("Lat") lat: Double,
        @Query("Logt") logt: Double,
        @Query("CityId") cityId: Int,
        @Query("All") all: Int
    ): Response<HomeResponseDto>
}