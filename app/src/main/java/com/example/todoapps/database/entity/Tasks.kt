package com.example.todoapps.database.entity

import androidx.room.ColumnInfo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasksList")
data class Tasks(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "taskName") val taskName: String,
    @ColumnInfo(name = "taskDesc") val taskDesc: String,
    @ColumnInfo(name = "date") val date: String
)