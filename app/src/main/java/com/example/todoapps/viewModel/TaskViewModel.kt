package com.example.todoapps.viewModel


import android.app.Application
import android.arch.lifecycle.AndroidViewModel

import android.arch.lifecycle.LiveData
import android.os.AsyncTask

import com.example.todoapps.database.ToDoRoomDatabase
import com.example.todoapps.database.entity.Tasks
import com.example.todoapps.repository.TaskRepository


class TaskViewModel(application:Application): AndroidViewModel(application) {

    private var repository: TaskRepository
    var allTasks: LiveData<List<Tasks>>
    init {
        val tasksDao = ToDoRoomDatabase.getDatabase(application).tasksDao()
        repository = TaskRepository(tasksDao)
        allTasks = repository.allTasks

    }
    fun insert(task: Tasks)=AsyncTask.execute{
        repository.insert(task)
    }

}