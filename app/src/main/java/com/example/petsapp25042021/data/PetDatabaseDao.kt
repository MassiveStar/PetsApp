package com.example.petsapp25042021.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PetDatabaseDao {

    @Insert
    suspend fun insert(pet: Pet)

    @Update
    suspend fun update(pet: Pet)

    @Query("SELECT * FROM pet_information_table WHERE petId = :key")
    suspend fun get(key: Long): Pet?

    @Query("SELECT * FROM pet_information_table ORDER BY petId DESC LIMIT 1")
    suspend fun getLastPet(): Pet?

    @Query("DELETE FROM pet_information_table")
    suspend fun clear()

    @Query("SELECT * FROM pet_information_table ORDER BY petId DESC")
    fun getAllPets(): LiveData<List<Pet>>
}