package com.mjtech.mentoria.favoriteAdvice.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mjtech.mentoria.favoriteAdvice.data.model.AdviceEntityRemote

@Database(
    entities = [AdviceEntityRemote::class],
    version = 1
)

abstract class AdviceDb : RoomDatabase() {

    abstract fun getDao(): AdviceDao

}