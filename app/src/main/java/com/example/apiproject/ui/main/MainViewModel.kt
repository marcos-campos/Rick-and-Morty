package com.example.apiproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiproject.modelCharacter.Result3
import com.example.apiproject.modelLocation.Result
import com.example.apiproject.modelEpisode.Result2
import com.example.apiproject.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val localizacaoLiveData = MutableLiveData<List<Result>>()
    val repository = RepositoryApi()
    val episodiosLiveData = MutableLiveData<List<Result2>>()
    val personagensLiveData = MutableLiveData<List<Result3>>()


    fun chamarLocalizacaoCoroutineOk() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.chamarLocalizacaoCoroutine().let { localizacao ->
                localizacao.results?.let(localizacaoLiveData::postValue)


            }

        }
    }

    fun chamarEpisodiosCoroutinesOk() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.chamarEpisodiosCoroutine().let { episodios ->
                episodios.result2s?.let {
                    episodiosLiveData.postValue(it)

                }
            }
        }
    }

    fun chamarPersonagemCoroutineOk() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.chamarPersonagemCoroutine().let { personagens ->
                personagens.results3?.let {
                    personagensLiveData.postValue(it)


                }
            }
        }
    }

}
