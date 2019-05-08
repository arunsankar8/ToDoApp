package com.example.todoapps.ui.home

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import com.example.todoapps.R
import com.example.todoapps.api.ApiRepo
import com.example.todoapps.database.entity.Tasks
import com.example.todoapps.ui.addTask.AddTaskActivity
import com.example.todoapps.ui.home.adapter.SearchRecyclerAdapter
import com.example.todoapps.viewModel.TaskViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import rx.Observable

import rx.Subscription


class HomeActivity : AppCompatActivity() {

    private lateinit var subscription: Subscription
    private lateinit var observable: Observable<Int>
    private lateinit var taskViewModel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        taskViewModel.allTasks.observe(this, Observer { t:List<Tasks>? ->
            if (t != null) {
                setupAdapter(t)
            }
        })

        fab.setOnClickListener {
            startActivityForResult(Intent(this@HomeActivity, AddTaskActivity::class.java), 0)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK&&requestCode==0) {
            val tasks= data!!.getSerializableExtra("tasks") as Tasks
            taskViewModel.insert(tasks)

        }
    }

    private fun setupAdapter(syncDataContainer: List<Tasks>) {
        val layoutmanager = LinearLayoutManager(this)
        val adapter = SearchRecyclerAdapter(this, syncDataContainer)
        rvData.layoutManager = layoutmanager
        rvData.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        subscription.unsubscribe()
    }


}



