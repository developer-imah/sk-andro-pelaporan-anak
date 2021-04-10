package com.imah.laporan.anak.main.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.imah.laporan.anak.main.data.db.dbstorage.StorageDao
import com.imah.laporan.anak.main.data.db.dbstorage.StorageEntity
import com.imah.laporan.anak.main.util.value.StoreConstant

@Database(
    entities = [StorageEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val daoStorage: StorageDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(
                appContext, AppDatabase::class.java, StoreConstant.DbName.BASE
            ).fallbackToDestructiveMigration()
                .build()
    }
}