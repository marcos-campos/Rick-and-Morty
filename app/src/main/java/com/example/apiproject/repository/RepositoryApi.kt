package com.example.apiproject.repository

import com.example.apiproject.modelCharacter.Personagens
import com.example.apiproject.modelLocation.Localizacao
import com.example.apiproject.modelEpisode.Episodios
import com.example.apiproject.network.EndPoints
import com.example.apiproject.network.RetrofitInit

class RepositoryApi {

    private var url = "https://rickandmortyapi.com/api/"
    private var service = EndPoints::class

    private val conectionService = RetrofitInit(url).create(service)

    suspend fun chamarLocalizacaoCoroutine(): Localizacao = conectionService.chamarLocalizacao()

    suspend fun chamarEpisodiosCoroutine(): Episodios = conectionService.chamarEpisodio()

    suspend fun chamarPersonagemCoroutine(): Personagens = conectionService.chamarPersonagem()

}