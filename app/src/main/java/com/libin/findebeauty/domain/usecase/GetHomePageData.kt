package com.libin.findebeauty.domain.usecase


import com.libin.findebeauty.core.Resource
import com.libin.findebeauty.domain.model.Home
import com.libin.findebeauty.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomePageData @Inject constructor(
    private val homeRepository: HomeRepository
) {

    operator fun invoke(
        lat: Double,
        logt: Double,
        lang: String,
        cityId: Int,
        all: Int
    ): Flow<Resource<Home>> = homeRepository.getHomePageData(lat, logt, lang, cityId, all)
}