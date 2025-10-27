package com.libin.findebeauty.domain.repository

import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.domain.model.Home


interface HomeRepository {
    suspend fun getHomePageData(
        lat: Double,
        logt: Double,
        lang: String,
        cityId: Int,
        all: Int
    ): Resource<Home>
}