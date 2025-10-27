package com.libin.findebeauty.data.model

import com.google.gson.annotations.SerializedName
import com.libin.findebeauty.domain.model.FeaturedSalon
import com.libin.findebeauty.domain.model.Home
import com.libin.findebeauty.domain.model.HomePageBanner
import com.libin.findebeauty.domain.model.NearBySalon
import com.libin.findebeauty.domain.model.TopDeal
import com.libin.findebeauty.domain.model.TopService
import com.libin.findebeauty.domain.model.TopTech
import kotlin.collections.map


data class HomeResponseDto(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: HomeDataDto,
    @SerializedName("message")
    val message: String
)

fun HomeDataDto.toDomain(): Home {
    return Home(
        homePageBanner = homePageBanner.toDomain(),
        topDeals = topDeals.map { it.toDomain() },
        topServices = topServices.map { it.toDomain() },
        featuredSalons = featuredSalons.map { it.toDomain() },
        topTechs = topTechs.map { it.toDomain() },
        nearBySalons = nearBySalons.map { it.toDomain() }
    )
}

data class HomeDataDto(
    @SerializedName("HomePageBanner")
    val homePageBanner: HomePageBannerDto,
    @SerializedName("TopDeals")
    val topDeals: List<TopDealDto>,
    @SerializedName("TopServices")
    val topServices: List<TopServiceDto>,
    @SerializedName("FeaturedSalons")
    val featuredSalons: List<FeaturedSalonDto>,
    @SerializedName("Toptechs")
    val topTechs: List<TopTechDto>,
    @SerializedName("NearBySalons")
    val nearBySalons: List<NearBySalonDto>
)

fun HomePageBannerDto.toDomain(): HomePageBanner {
    return HomePageBanner(
        bannerId = bannerId,
        topBannerAndroid = topBannerAndroid,
        bottomBannerAndroid = bottomBannerAndroid,
        bannerType = bannerType
    )
}

data class HomePageBannerDto(
    @SerializedName("Banner_Id")
    val bannerId: Int,
    @SerializedName("TopBanner_iOS")
    val topBannerIos: String,
    @SerializedName("BottomBanner_iOS")
    val bottomBannerIos: String,
    @SerializedName("TopBanner_Android")
    val topBannerAndroid: String,
    @SerializedName("BottomBanner_Android")
    val bottomBannerAndroid: String,
    @SerializedName("Banner_Date")
    val bannerDate: String,
    @SerializedName("Banner_IsActive")
    val bannerIsActive: Boolean,
    @SerializedName("TopBanner_iOS_Ar")
    val topBannerIosAr: String?,
    @SerializedName("BottomBanner_iOS_Ar")
    val bottomBannerIosAr: String?,
    @SerializedName("TopBanner_Android_Ar")
    val topBannerAndroidAr: String?,
    @SerializedName("BottomBanner_Android_Ar")
    val bottomBannerAndroidAr: String?,
    @SerializedName("Banner_Type")
    val bannerType: String
)

fun TopDealDto.toDomain(): TopDeal {
    return TopDeal(
        dealId = dealId,
        salonId = salonId,
        dealTitle = dealTitle,
        dealBanner = dealBanner,
        serviceName = serviceName,
        servicePrice = servicePrice,
        serviceFinalPrice = serviceFinalPrice,
        salonName = salonName,
        area = area,
        city = city
    )
}

data class TopDealDto(
    @SerializedName("Deal_Id")
    val dealId: Int,
    @SerializedName("Salon_Id")
    val salonId: Int,
    @SerializedName("Deal_Title")
    val dealTitle: String,
    @SerializedName("Deal_Banner")
    val dealBanner: String,
    @SerializedName("Deal_Condition")
    val dealCondition: String,
    @SerializedName("Service_Id")
    val serviceId: Int,
    @SerializedName("Service_Name")
    val serviceName: String,
    @SerializedName("Service_Price")
    val servicePrice: Double,
    @SerializedName("Service_Discount")
    val serviceDiscount: Double,
    @SerializedName("Service_FinalPrice")
    val serviceFinalPrice: Double,
    @SerializedName("Deal_AvailPostingDate")
    val dealAvailPostingDate: String,
    @SerializedName("Deal_AvailFromDate")
    val dealAvailFromDate: String,
    @SerializedName("Deal_Todate")
    val dealToDate: String,
    @SerializedName("Deal_TimeFrom")
    val dealTimeFrom: String,
    @SerializedName("Deal_TimeTo")
    val dealTimeTo: String,
    @SerializedName("Deal_Status")
    val dealStatus: Boolean,
    @SerializedName("Deal_OnlineFromDate")
    val dealOnlineFromDate: String,
    @SerializedName("Deal_OnlineToDate")
    val dealOnlineToDate: String,
    @SerializedName("Salon_Name")
    val salonName: String,
    @SerializedName("Area")
    val area: String,
    @SerializedName("City")
    val city: String,
    @SerializedName("Latitude")
    val latitude: String,
    @SerializedName("Longitude")
    val longitude: String
)

fun TopServiceDto.toDomain(): TopService {
    return TopService(
        topServiceId = topServiceId,
        serviceName = serviceName,
        serviceId = serviceId,
        serviceImage = serviceImage
    )
}

data class TopServiceDto(
    @SerializedName("TopService_Id")
    val topServiceId: Int,
    @SerializedName("Service_Name")
    val serviceName: String,
    @SerializedName("Service_Id")
    val serviceId: Int,
    @SerializedName("TopService_Date")
    val topServiceDate: String,
    @SerializedName("TopService_IsActive")
    val topServiceIsActive: Boolean,
    @SerializedName("Service_Image")
    val serviceImage: String
)

fun FeaturedSalonDto.toDomain(): FeaturedSalon {
    return FeaturedSalon(
        salonId = salonId,
        salonName = salonName,
        salonRatingSummary = salonRatingSummary,
        areaName = areaName,
        totalCount = totalCount,
        salonBanner = salonBanner
    )
}

data class FeaturedSalonDto(
    @SerializedName("Salon_Id")
    val salonId: Int,
    @SerializedName("Total_Count")
    val totalCount: Int,
    @SerializedName("Salon_Name")
    val salonName: String,
    @SerializedName("Salon_RatingSummary")
    val salonRatingSummary: Double,
    @SerializedName("Salonurl")
    val salonUrl: String,
    @SerializedName("Area_Name")
    val areaName: String,
    @SerializedName("Salon_Banner")
    val salonBanner: String
)

fun TopTechDto.toDomain(): TopTech {
    return TopTech(
        techId = techId,
        salonId = salonId,
        salonName = salonName,
        empId = empId,
        empName = empName,
        empEmployeeProfileImg = empEmployeeProfileImg,
        techVerified = techVerified
    )
}

data class TopTechDto(
    @SerializedName("Tech_Id")
    val techId: Int,
    @SerializedName("Salon_Id")
    val salonId: Int,
    @SerializedName("Salon_Name")
    val salonName: String,
    @SerializedName("Emp_Id")
    val empId: Int,
    @SerializedName("Emp_Name")
    val empName: String,
    @SerializedName("Emp_EmployeeProfileImg")
    val empEmployeeProfileImg: String?,
    @SerializedName("Tech_Verified")
    val techVerified: Boolean
)

fun NearBySalonDto.toDomain(): NearBySalon {
    return NearBySalon(
        salonId = salonId,
        salonName = salonName,
        salonRatingSummary = salonRatingSummary,
        areaName = areaName,
        count = count,
        salonBanner = salonBanner
    )
}

data class NearBySalonDto(
    @SerializedName("Salon_Id")
    val salonId: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("Salon_Name")
    val salonName: String,
    @SerializedName("Salon_RatingSummary")
    val salonRatingSummary: Double,
    @SerializedName("Salon_WorkingHours")
    val salonWorkingHours: Int,
    @SerializedName("Area_Name")
    val areaName: String,
    @SerializedName("Salon_Banner")
    val salonBanner: String
)
