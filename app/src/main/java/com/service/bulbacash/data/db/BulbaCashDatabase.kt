package com.service.bulbacash.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.db.entity.*

@Database(
    entities = [BucketsEntity::class, RateEntity::class, CurrencyEntity::class,
               StencilEntity::class, ItemStencilEntity::class, LinkStencilEntity::class],
    version = 3,
    exportSchema = false
)
abstract class BulbaCashDatabase : RoomDatabase() {
    abstract fun bulbaCashDAO(): BulbaCashDAO
}
