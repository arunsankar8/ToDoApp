package com.example.todoapps.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import com.example.todoapps.database.dao.TasksListDao
import com.example.todoapps.database.entity.Tasks


@Database(entities = [Tasks::class],version = 1)
abstract class ToDoRoomDatabase : RoomDatabase(){

    abstract fun tasksDao(): TasksListDao
    companion object {

        @Volatile
        private var instance:ToDoRoomDatabase?=null
        fun getDatabase(context: Context): ToDoRoomDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val dbInstance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoRoomDatabase::class.java,
                    "ToDoList_database"
                ).build()
                instance= dbInstance
                return dbInstance
            }
        }
    }

}