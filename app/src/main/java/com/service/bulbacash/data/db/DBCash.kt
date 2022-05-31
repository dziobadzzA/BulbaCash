package com.service.bulbacash.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.db.entity.BucketsEntity
import com.service.bulbacash.data.db.entity.CurrencyEntity
import com.service.bulbacash.data.db.entity.RateEntity

@Database(entities = [BucketsEntity::class, RateEntity::class, CurrencyEntity::class], version = 1, exportSchema = false)
abstract  class DBCash: RoomDatabase() {

    abstract val databaseDao: BulbaCashDAO

    companion object {

        @Volatile
        private var INSTANCE: DBCash? = null

        fun getInstance(context: Context): DBCash {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DBCash::class.java,
                        "BulbaCash"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}