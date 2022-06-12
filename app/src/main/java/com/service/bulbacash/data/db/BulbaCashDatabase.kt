package com.service.bulbacash.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.db.entity.BucketsEntity
import com.service.bulbacash.data.db.entity.CurrencyEntity
import com.service.bulbacash.data.db.entity.RateEntity

@Database(
    entities = [BucketsEntity::class, RateEntity::class, CurrencyEntity::class],
    version = 2,
    exportSchema = false
)
abstract class BulbaCashDatabase : RoomDatabase() {
    abstract fun bulbaCashDAO(): BulbaCashDAO
}
