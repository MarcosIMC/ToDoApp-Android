package com.example.todo.addtasks.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    //DAO
    abstract fun taskDao(): TaskDao
}