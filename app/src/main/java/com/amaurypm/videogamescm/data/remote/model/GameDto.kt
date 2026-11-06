package com.amaurypm.videogamescm.data.remote.model

import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String
)
