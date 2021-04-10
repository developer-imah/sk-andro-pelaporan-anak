package com.imah.laporan.anak.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.imah.laporan.anak.main.data.db.AppDatabase
import com.imah.laporan.anak.main.data.db.dbstorage.StorageEntity
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch

class DbViewmodel (application: Application) : AndroidViewModel(application) {
    private val dbApp: AppDatabase = AppDatabase.getDatabase(application)
    private val daoStorage = dbApp.daoStorage

    val storageData = liveData(Default) {
        emitSource(daoStorage.get())
    }

    fun setStorageOpened(opened: Int) {
        viewModelScope.launch(Default) {
            daoStorage.setOpened(opened)
        }
    }

    fun setStorageData(data: StorageEntity) {
        viewModelScope.launch(Default) {
            daoStorage.insert(data)
        }
    }

}