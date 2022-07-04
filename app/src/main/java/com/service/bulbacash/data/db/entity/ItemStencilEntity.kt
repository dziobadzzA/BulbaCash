package com.service.bulbacash.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rate")
data class ItemStencilEntity(

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,

    @ColumnInfo(name="Cur_ID")
    val Cur_ID: Int = 0,

    @ColumnInfo(name = "costName")
    val costName: String

)