package io.shortcut.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.shortcut.data.database.entities.ComicEntity

@Database(entities = [ComicEntity::class], version = 1)
abstract class XKCDDatabase: RoomDatabase() {

    abstract fun getXKCDDao(): XKCDDao
}