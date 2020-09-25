package com.programmergabut.android_jetpack_testing.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingItemDatabases : RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao
}