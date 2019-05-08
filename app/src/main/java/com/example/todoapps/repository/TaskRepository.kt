package com.example.todoapps.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

import com.example.todoapps.database.dao.TasksListDao
import com.example.todoapps.database.entity.Tasks

class TaskRepository(private val taskDao: TasksListDao) {

    val allTasks: LiveData<List<Tasks>> = taskDao.getAllTasks()

    @WorkerThread
    fun insert(word: Tasks) {
        taskDao.insert(word)
    }
}