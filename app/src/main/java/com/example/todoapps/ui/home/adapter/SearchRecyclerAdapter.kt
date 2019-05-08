package com.example.todoapps.ui.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapps.R
import com.example.todoapps.database.entity.Tasks


class SearchRecyclerAdapter(private val context: Context, private val taskList: List<Tasks>): RecyclerView.Adapter<SearchRecyclerAdapter.SearchRecyclerViewHolder>() {
    override fun onBindViewHolder(holder: SearchRecyclerViewHolder, position: Int) {


       /* tvTaskName.text=taskList[position].taskName
       tvTaskDescription.text=taskList[position].taskDesc
*/


    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SearchRecyclerViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.item_search_layout, parent, false)
        return SearchRecyclerViewHolder(itemView)
    }


    override fun getItemCount(): Int {

        return (taskList.size)
    }
    
    class SearchRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

}