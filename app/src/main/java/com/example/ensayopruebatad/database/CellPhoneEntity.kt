package com.example.ensayopruebatad.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "CellPhones_items")
data class CellPhoneEntity(
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String,
    val price: Int
)
