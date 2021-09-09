package com.kushalsharma.unsplashphotos.Modals

data class CoinsItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String?,
    val rank: Int?,
    val symbol: String?,
    val type: String?
)


// https://api.coinpaprika.com/v1/global?api_key=261edac420msh334f4d543490fep16097ajsn3f69ft
