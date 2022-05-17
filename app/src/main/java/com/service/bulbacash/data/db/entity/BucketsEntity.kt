package com.service.bulbacash.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buckets")
data class BucketsEntity(

        @PrimaryKey (autoGenerate = true)
        var id : Long = 0,

        @ColumnInfo(name="first_rate")
        var firstRate: Long = 0,

        @ColumnInfo(name="second_rate")
        var secondRate: Long = 0

)