package com.example.ensayopruebatad.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CellPhoneEntity::class], version = 1)

abstract class CellPhoneDataBase : RoomDatabase() {
    abstract fun getCellPhoneDAO(): CellphoneDAO

    companion object {
        @Volatile
        private var INSTANCE: CellPhoneDataBase? = null

        fun getDataBase(context: Context): CellPhoneDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    CellPhoneDataBase::class.java, "CellPhoneDatabase"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}