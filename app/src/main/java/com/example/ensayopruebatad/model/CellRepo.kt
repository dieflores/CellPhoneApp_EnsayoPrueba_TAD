package com.example.ensayopruebatad.model

import android.util.Log
import com.example.ensayopruebatad.model.database.CellPhoneEntity
import com.example.ensayopruebatad.model.database.CellphoneDAO
import com.example.ensayopruebatad.model.network.RetrofitClient
import com.example.ensayopruebatad.model.pojo.CellphoneAppItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CellRepo(private val phoneDAO: CellphoneDAO) {

    private val service = RetrofitClient.getRetrofitClient()
    val allDataCellPhone = phoneDAO.getAllCellPhones()

    fun getDataFromNetworkCoroutines() = CoroutineScope(Dispatchers.IO)
        .launch{
            val service = kotlin.runCatching { service.fetchDataFromInternet() }
            service.onSuccess {
                when(it.code()){
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        it.body()?.let {
                            phoneDAO.insertAllCellPhones(convert(it))
                        }
                    }
                }
            }
            service.onFailure {
                Log.d("ERROR", it.message.toString())
            }
        }
    fun convert(listFromInternet: List<CellphoneAppItem>): List<CellPhoneEntity>{
        val listCellphoneEntity = mutableListOf<CellPhoneEntity>()
        listFromInternet.map {
            listCellphoneEntity.add(
                CellPhoneEntity(it.id,
            it.image,
            it.name,
            it.price)
            )
        }
        return listCellphoneEntity
    }
}