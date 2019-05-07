package com.example.todoapps.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.todoapps.R
import com.example.todoapps.api.ApiRepo
import com.example.todoapps.ui.home.adapter.SearchRecyclerAdapter
import com.tiffin.metal.dl.models.downsync.container.SyncDataContainer
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
        fab.setOnClickListener {

            apiRepo.callContainerDownSyncApi()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<SyncDataContainer> {
                    override fun onError(e: Throwable?) {

                        if (true) {

                        }
                    }

                    override fun onNext(t: SyncDataContainer?) {
                        if (t != null) {
                            setupAdapter(t)
                        }
                    }

                    override fun onCompleted() {


                    }
                })
            /*observable= Observable
            .just(1, 2, 3, 4, 5,6,7)
            .filter( Func1<Int,Boolean> {
                return@Func1 it%2!=0
            })
        var stringBuilder=StringBuilder()
        stringBuilder.append("")
        val action= object:Observer<Int> {
            override fun onError(e: Throwable?) {


            }

            override fun onNext(t: Int?) {
                stringBuilder.append(t.toString()+" ")
                tvSample.text=stringBuilder
            }

            override fun onCompleted() {

            }

        }

        subscription= observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action)*/

        }
    }
    private fun setupAdapter(syncDataContainer: SyncDataContainer) {
        val layoutmanager = LinearLayoutManager(this)
        val adapter=SearchRecyclerAdapter(this,syncDataContainer.data.containers)
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



