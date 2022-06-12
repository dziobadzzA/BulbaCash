package com.service.bulbacash.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,

    @ColumnInfo(name="Cur_ID")
    val Cur_ID: Int = 0,

    @ColumnInfo(name="Cur_ParentID")
    val Cur_ParentID: Int = 0,

    @ColumnInfo(name = "Cur_Abbreviation")
    val Cur_Abbreviation: String,

    @ColumnInfo(name = "Cur_Code")
    val Cur_Code: String,

    @ColumnInfo(name = "Cur_Scale")
    val Cur_Scale: Int,

    @ColumnInfo(name = "Cur_Name")
    val Cur_Name: String,

    @ColumnInfo(name = "Cur_QuotName")
    val Cur_QuotName: String,

    @ColumnInfo(name = "Cur_NameMulti")
    val Cur_NameMulti: String,

    @ColumnInfo(name = "Cur_Periodicity")
    val Cur_Periodicity: Int,

    @ColumnInfo(name = "Cur_DateStart")
    val Cur_DateStart: String,

    @ColumnInfo(name = "Is_Cur_DateEnd")
    var Is_Cur_DateEnd: Boolean
)





