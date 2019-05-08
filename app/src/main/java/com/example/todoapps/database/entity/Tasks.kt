package com.example.todoapps.database.entity


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "tasksList")
data class Tasks(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo(name = "taskName") var taskName: String,
    @ColumnInfo(name = "taskDesc") var taskDesc: String,
    @ColumnInfo(name = "date") var date: String
):Serializable{

    constructor():this(0,"","","")



}