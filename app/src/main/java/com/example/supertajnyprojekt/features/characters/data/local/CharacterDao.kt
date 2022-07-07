package com.example.supertajnyprojekt.features.characters.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.supertajnyprojekt.features.characters.data.local.model.CharacterCached

@Dao
interface CharacterDao {

    @Query("SELECT * FROM EpisodeCached")
    suspend fun getCharacters(): List<CharacterCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg character: CharacterCached)
}