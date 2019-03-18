package com.billy.petsadoption

import com.billy.petsadoption.model.Pet
import retrofit2.Call
import retrofit2.http.GET

interface PetClient {

    @GET("/Service/OpenData/TransService.aspx?UnitId=QcbUEzN6E6DL")
    fun getPets(): Call<List<Pet>>


}