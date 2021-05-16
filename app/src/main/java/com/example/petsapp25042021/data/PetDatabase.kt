package com.example.petsapp25042021.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pet::class], version = 1, exportSchema = false)
abstract class PetDatabase : RoomDatabase() {

    abstract val petDatabaseDao: PetDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: PetDatabase? = null

        fun getInstance(context: Context): PetDatabase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PetDatabase::class.java,
                        "pet_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}