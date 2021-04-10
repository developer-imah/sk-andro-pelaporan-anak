package com.imah.laporan.anak.main.util.value

sealed class StoreConstant {
    object DbName {
        const val BASE = "db_imah"
        const val STORAGE = "tbl_storage"
    }
}