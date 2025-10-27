package com.libin.findebeauty.domain.model

import androidx.annotation.DrawableRes

data class ActionButton(
    @DrawableRes val icon: Int,
    val text: String,
    val color: Int
)
