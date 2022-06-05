package io.shortcut.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.shortcut.data.database.XKCDDao
import io.shortcut.data.database.XKCDDatabase
import io.shortcut.data.database.utils.DATABASE_NAME
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(context: Context): XKCDDatabase =
        Room.databaseBuilder(context, XKCDDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDatabaseDao(database: XKCDDatabase): XKCDDao = database.getXKCDDao()
}