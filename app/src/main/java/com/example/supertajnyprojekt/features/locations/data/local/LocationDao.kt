package com.example.supertajnyprojekt.features.locations.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.supertajnyprojekt.features.characters.data.local.model.CharacterCached
import com.example.supertajnyprojekt.features.locations.data.local.model.LocationCached

@Dao
interface LocationDao {

    @Query("SELECT * FROM EpisodeCached")
    suspend fun getLocations(): List<LocationCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg character: LocationCached)
}