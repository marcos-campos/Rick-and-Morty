package com.example.apiproject.modelCharacter

import com.google.gson.annotations.SerializedName

data class Personagens(

    @SerializedName("info")
    val info3: Info3?,

    @SerializedName("results")
    val results3: List<Result3>?
)