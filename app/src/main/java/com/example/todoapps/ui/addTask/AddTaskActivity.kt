package com.example.todoapps.ui.addTask

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.example.todoapps.R
import com.example.todoapps.database.entity.Tasks
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)



        btnAddTask.setOnClickListener {

            val task= Tasks()
            if(etHeading.text.toString().trim().isNotEmpty()){
                if(etTaskDesc.text.toString().trim().isNotEmpty()){
                    task.taskName=etHeading.text.toString()
                    task.taskDesc=etTaskDesc.text.toString()
                    val intent= Intent()
                    intent.putExtra("tasks",task)
                    setResult(Activity.RESULT_OK,intent)
                    finish()
                }else{
                    Snackbar.make(it,"Empty Description",Snackbar.LENGTH_SHORT)
                }

            }else{
                Snackbar.make(it,"Empty name",Snackbar.LENGTH_SHORT)
            }



        }


    }
}
