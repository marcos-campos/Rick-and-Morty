package com.example.apiproject.modelEpisode

import com.google.gson.annotations.SerializedName

data class Episodios(

    @SerializedName("info")
    val info2: Info2?,
    @SerializedName("results")
    val result2s: List<Result2>?
)