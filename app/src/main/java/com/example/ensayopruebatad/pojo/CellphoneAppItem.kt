package com.example.ensayopruebatad.pojo


import com.google.gson.annotations.SerializedName

data class CellphoneAppItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)