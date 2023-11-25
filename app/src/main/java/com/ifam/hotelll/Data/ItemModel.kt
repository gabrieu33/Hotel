package com.ifam.hotelll.Data

import android.net.Uri
import com.ifam.hotelll.Data.acessorios.ItemEntity

data class ItemModel(
    val id: Long,
    val image: Uri,
    val name: String,
    val amount: String,
    val value: String,
    val onRemove: (ItemModel) -> Unit
) {

    fun toEntity(): ItemEntity {
        return ItemEntity(
            id = this.id,
            image = this.image,
            name = this.name,
            amount = this.amount,
            value = this.value
        )
    }
}