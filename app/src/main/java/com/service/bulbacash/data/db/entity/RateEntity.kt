package com.service.bulbacash.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rate")
data class RateEntity(

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,

    @ColumnInfo(name="Cur_ID")
    val Cur_ID: Int = 0,

    @ColumnInfo(name = "Cur_Abbreviation")
    val Cur_Abbreviation: String,

    @ColumnInfo(name = "Cur_Scale")
    val Cur_Scale: Int,

    @ColumnInfo(name = "Cur_Name")
    val Cur_Name: String,

    @ColumnInfo(name = "Cur_OfficialRate")
    val Cur_OfficialRate: Double

)