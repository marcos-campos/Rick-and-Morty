package com.example.apiproject.modelLocation

import com.google.gson.annotations.SerializedName

data class Localizacao(

    @SerializedName("info")
    val info: Info?,

    @SerializedName("results")
    val results: List<Result>?
)