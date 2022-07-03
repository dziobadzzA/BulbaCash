package com.service.bulbacash.di

import com.service.bulbacash.data.db.BulbaCashDatabase
import com.service.bulbacash.data.db.dao.BulbaCashDAO
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val NAME_FILE_DB = "bulbacash_db"

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideBulbaCashDAO(database: BulbaCashDatabase): BulbaCashDAO {
        return database.bulbaCashDAO()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): BulbaCashDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            BulbaCashDatabase::class.java,
            NAME_FILE_DB
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}

