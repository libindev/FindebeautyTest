package com.libin.findebeauty.domain.model

data class Home(
    val homePageBanner: HomePageBanner,
    val topDeals: List<TopDeal>,
    val topServices: List<TopService>,
    val featuredSalons: List<FeaturedSalon>,
    val topTechs: List<TopTech>,
    val nearBySalons: List<NearBySalon>
)

data class HomePageBanner(
    val bannerId: Int,
    val topBannerAndroid: String,
    val bottomBannerAndroid: String,
    val bannerType: String
)

data class TopDeal(
    val dealId: Int,
    val salonId: Int,
    val dealTitle: String,
    val dealBanner: String,
    val serviceName: String,
    val servicePrice: Double,
    val serviceFinalPrice: Double,
    val salonName: String,
    val area: String,
    val city: String
)

data class TopService(
    val topServiceId: Int,
    val serviceName: String,
    val serviceId: Int,
    val serviceImage: String
)

data class FeaturedSalon(
    val salonId: Int,
    val salonName: String,
    val totalCount: Int,
    val salonRatingSummary: Double,
    val areaName: String,
    val salonBanner: String
)

data class TopTech(
    val techId: Int,
    val salonId: Int,
    val salonName: String,
    val empId: Int,
    val empName: String,
    val empEmployeeProfileImg: String?,
    val techVerified: Boolean
)

data class NearBySalon(
    val salonId: Int,
    val count : Int,
    val salonName: String,
    val salonRatingSummary: Double,
    val areaName: String,
    val salonBanner: String
)