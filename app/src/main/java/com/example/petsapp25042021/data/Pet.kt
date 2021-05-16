package com.example.petsapp25042021.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pet_information_table")
data class Pet(
    @PrimaryKey(autoGenerate = true)
    var petId: Long =0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "breed")
    var breed: String = "",

    @ColumnInfo(name = "gender")
    var gender: String = "",

    @ColumnInfo(name = "weight")
    var weight: Double = 0.0

) {
}