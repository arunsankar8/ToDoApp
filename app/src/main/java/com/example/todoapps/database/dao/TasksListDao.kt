package com.example.todoapps.database.dao


import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
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