package com.example.apiproject.network

import com.example.apiproject.modelCharacter.Personagens
import com.example.apiproject.modelLocation.Localizacao
import com.example.apiproject.modelEpisode.Episodios
import retrofit2.http.GET

interface EndPoints {


    @GET("character")
    suspend fun chamarPersonagem() : Personagens

    @GET("location")
    suspend fun chamarLocalizacao() : Localizacao

    @GET("episode")
    suspend fun chamarEpisodio() : Episodios

}