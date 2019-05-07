package com.example.todoapps.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.todoapps.database.entity.Tasks

@Dao
interface TasksListDao {

    @Query("SELECT * from tasksList ORDER BY id ASC")
    fun getAllTasks(): LiveData<List<Tasks>>

    @Insert
    fun insert(tasks: Tasks)

    @Query("DELETE FROM tasksList")
    fun deleteAll()

    @Query("DELETE FROM tasksList where id=:id")
    fun deleteTask(id:Int)


    @Transaction
    fun insertAll(tasksList: List<Tasks>)=tasksList.forEach { insert(it) }



}