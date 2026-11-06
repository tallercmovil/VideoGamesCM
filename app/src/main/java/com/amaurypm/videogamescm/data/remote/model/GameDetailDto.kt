package com.amaurypm.videogamescm.data.remote.model

import com.google.gson.annotations.SerializedName

data class GameDetailDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("long_desc")
    val longDesc: String
)
