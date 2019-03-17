package com.billy.petsadoption

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpInstance {
    companion object {
        private var HOST = "http://data.coa.gov.tw/"
        private var mRetrofitBuilder: Retrofit? = null

        fun getInstance(): Retrofit {
            if (mRetrofitBuilder == null) {
                buildRetrofit()
            }

            return mRetrofitBuilder!!
        }

        private fun buildRetrofit() {
            mRetrofitBuilder = Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}