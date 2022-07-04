package com.service.bulbacash.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "link_stencil",
    primaryKeys = ["item_id", "stencil_id"],
    foreignKeys = [
        ForeignKey(
            entity = ItemStencilEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("item_id")
        ),
        ForeignKey(
            entity = StencilEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("stencil_id")
        )
    ]
)
data class LinkStencilEntity(val item_id: Int, val stencil_id: Int)