package com.amaurypm.videogamescm.data.remote

import com.amaurypm.videogamescm.data.remote.model.GameDetailDto
import com.amaurypm.videogamescm.data.remote.model.GameDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GamesApi {

    //Aquí ponemos las funciones que van a consumir los endpoints

    @GET
    suspend fun getGames(
        @Url url: String
    ): List<GameDto>


    //cm/games/game_detail.php?id=21357
    @GET("cm/games/game_detail.php") //game_detail.php?id=23423&name=Amaury
    suspend fun getGameDetail(
        @Query("id") id: String/*,
        @Query("name") name: String*/
    ): GameDetailDto

    //getGameDetail("23423")

    //https://api.hyrule-compendium.com/v3/compendium/category/<category>
    @GET("v3/compendium/category/{category}/{game}")
    suspend fun getCategoryElement(
        @Path("category") category: String,
        @Path("game") game: String
    )


}