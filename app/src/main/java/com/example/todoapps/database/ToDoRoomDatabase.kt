package com.example.todoapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapps.database.dao.TasksListDao
import com.example.todoapps.database.entity.Tasks


@Database(entities = [Tasks::class],version = 1)
abstract class ToDoRoomDatabase :RoomDatabase(){

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