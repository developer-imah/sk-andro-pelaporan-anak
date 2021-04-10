package com.imah.laporan.anak.main.data.db.dbstorage

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imah.laporan.anak.main.util.value.StoreConstant

@Entity(tableName = StoreConstant.DbName.STORAGE)
@Keep
data class StorageEntity(
    @PrimaryKey
    val pk: Int = 0,
    val opened: Int? = 0
)