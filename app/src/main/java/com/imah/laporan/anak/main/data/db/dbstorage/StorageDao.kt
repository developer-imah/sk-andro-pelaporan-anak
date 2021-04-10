package com.imah.laporan.anak.main.data.db.dbstorage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.imah.laporan.anak.main.util.value.StoreConstant

@Dao
interface StorageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: StorageEntity)

    @Query("UPDATE ${StoreConstant.DbName.STORAGE} SET opened = :opened WHERE pk = 0")
    suspend fun setOpened(opened: Int)

    @Query("SELECT * FROM ${StoreConstant.DbName.STORAGE} WHERE pk = 0")
    fun get() : LiveData<StorageEntity?>
}