package com.example.todoapps.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.todoapps.R
import com.example.todoapps.api.ApiRepo
import com.example.todoapps.database.entity.Tasks
import com.example.todoapps.ui.home.adapter.SearchRecyclerAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import rx.Observable
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class HomeActivity : AppCompatActivity() {

    private lateinit var subscription: Subscription
    private lateinit var observable: Observable<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val apiRepo: ApiRepo = ApiRepo()

    }
    private fun setupAdapter(syncDataContainer: List<Tasks>) {
        val layoutmanager = LinearLayoutManager(this)
        val adapter=SearchRecyclerAdapter(this,syncDataContainer)
        rvData.layoutManager=layoutmanager
        rvData.adapter=adapter


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



