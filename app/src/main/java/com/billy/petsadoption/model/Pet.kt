package com.billy.petsadoption.model

import android.util.Log
import com.billy.petsadoption.HttpInstance
import com.billy.petsadoption.PetClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pet {
    private val TAG = javaClass.simpleName

    var animal_id = ""
        set(value) {
            field = value
        }
        get() = field

    var animal_kind = ""
        set(value) {
            field = value
        }
        get() = field

    var animal_sex = ""
        set(value) {
            field = value
        }
        get() = field

    var animal_colour = ""
        set(value) {
            field = value
        }
        get() = field

    var album_file = ""
        set(value) {
            field = value
        }
        get() = field

    fun getCount(callBack: CallBack2) {
        var result = 0
        var retrofit = HttpInstance.getInstance()
        var petClient = retrofit.create(PetClient::class.java)
        var data = petClient.getPets()
        data.enqueue(object : Callback<List<Pet>> {
            override fun onResponse(call: Call<List<Pet>>, response: Response<List<Pet>>) {
                callBack.getCount(response.body()!!.size)
            }

            override fun onFailure(call: Call<List<Pet>>, t: Throwable) {

            }
        })
    }

    fun getCats(callBack: CallBack): ArrayList<Pet> {
        var list = ArrayList<Pet>()
        var retrofit = HttpInstance.getInstance()
        var petClient = retrofit.create(PetClient::class.java)
        var data = petClient.getPets()
        data.enqueue(object : Callback<List<Pet>> {
            override fun onResponse(call: Call<List<Pet>>, response: Response<List<Pet>>) {
                response.body()!!.forEach {
                    if (it.animal_kind.equals("貓")) {
                        list.add(it)
                    }
                }
                callBack.onFinish(list)
                Log.i(TAG, "貓：${list.size}")
            }

            override fun onFailure(call: Call<List<Pet>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return list
    }

    fun getDogs(callBack: CallBack): ArrayList<Pet> {
        var list = ArrayList<Pet>()
        var retrofit = HttpInstance.getInstance()
        var petClient = retrofit.create(PetClient::class.java)
        var data = petClient.getPets()
        data.enqueue(object : Callback<List<Pet>> {
            override fun onResponse(call: Call<List<Pet>>, response: Response<List<Pet>>) {
                response.body()!!.forEach {
                    if (it.animal_kind.equals("狗")) {
                        list.add(it)
                    }
                }
                callBack.onFinish(list)
                Log.i(TAG, "狗：${list.size}")
            }

            override fun onFailure(call: Call<List<Pet>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return list
    }

    interface CallBack {
        fun onFinish(list: ArrayList<Pet>)
    }

    interface CallBack2 {
        fun getCount(count: Int)
    }


}