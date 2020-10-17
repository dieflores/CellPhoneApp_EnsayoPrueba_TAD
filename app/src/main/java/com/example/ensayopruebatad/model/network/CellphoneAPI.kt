package com.example.ensayopruebatad.model.network

import com.example.ensayopruebatad.model.pojo.CellphoneAppItem
import retrofit2.Response
import retrofit2.http.GET

interface CellphoneAPI {


    @GET("getCellphones")
    suspend fun fetchDataFromInternet(): Response<List<CellphoneAppItem>>
}