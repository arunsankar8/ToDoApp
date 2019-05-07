package com.example.todoapps.repository

import android.support.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.todoapps.database.dao.TasksListDao
import com.example.todoapps.database.entity.Tasks

class TaskRepository(private val taskDao: TasksListDao) {

    val allWords: LiveData<List<Tasks>> = taskDao.getAllTasks()

    @WorkerThread
    suspend fun insert(word: Tasks) {
        taskDao.insert(word)
    }
}