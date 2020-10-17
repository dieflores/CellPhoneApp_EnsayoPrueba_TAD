package com.example.ensayopruebatad.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CellphoneDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCellPhones(list: List<CellPhoneEntity>)

    @Query("SELECT * FROM cellphones_items")
    fun getAllCellPhones(): LiveData<List<CellPhoneEntity>>
}