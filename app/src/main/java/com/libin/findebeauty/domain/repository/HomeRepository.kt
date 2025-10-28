package com.libin.findebeauty.domain.repository

import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.domain.model.Home
import kotlinx.coroutines.flow.Flow


interface HomeRepository {
    fun getHomePageData(
        lat: Double,
        logt: Double,
        lang: String,
        cityId: Int,
        all: Int
    ): Flow<Resource<Home>>
}