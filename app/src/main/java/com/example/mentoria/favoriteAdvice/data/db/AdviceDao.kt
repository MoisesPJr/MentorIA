package com.example.mentoria.favoriteAdvice.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.randomAdviceFeature.data.model.SlipRemote

@Dao
interface AdviceDao {

    @Query("SELECT * FROM advice")
    fun getAdvice() : List<AdviceEntityRemote>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( advice: AdviceEntityRemote)

    @Query("DELETE FROM advice WHERE id = :adviceId")
    fun deleteFavoriteAdvice(adviceId: Int)
}