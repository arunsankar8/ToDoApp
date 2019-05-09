package com.example.todoapps.ui.addTask

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapps.R
import com.example.todoapps.database.entity.Tasks
import com.example.todoapps.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_add_task)
        val buttonClicks=ButtonClick(binding,this)

        binding.btnClick=buttonClicks




    }

    class ButtonClick(
        val binding: ActivityAddTaskBinding,
        val addTaskActivity: AddTaskActivity
    ) {

        fun AddButtonClick(){

            val task= Tasks()
            if(binding.etHeading.toString().trim().isNotEmpty()){
                if(binding.etTaskDesc.text.toString().trim().isNotEmpty()){
                    task.taskName=binding.etHeading.text.toString()
                    task.taskDesc=binding.etTaskDesc.text.toString()
                    val intent= Intent()
                    intent.putExtra("tasks",task)
                    addTaskActivity.setResult(Activity.RESULT_OK,intent)
                    addTaskActivity.finish()
                }else{
                    //Snackbar.make(it,"Empty Description",Snackbar.LENGTH_SHORT)
                }

            }else{
                //Snackbar.make(it,"Empty name",Snackbar.LENGTH_SHORT)
            }
        }



    }

}
