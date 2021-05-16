package com.example.petsapp25042021.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.petsapp25042021.data.Pet
import com.example.petsapp25042021.data.PetDatabaseDao
import kotlinx.coroutines.launch

class PetsViewModel(
    val database: PetDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var lastPet = MutableLiveData<Pet?>()
    private val pets = database.getAllPets()

    init {
        initializeLastPet()
    }

    private fun initializeLastPet(){
        viewModelScope.launch {
            lastPet.value = getLastPetFromDatabase()
        }
    }

    private suspend fun getLastPetFromDatabase(): Pet? {
        var pet = database.getLastPet()
        return pet
    }

}