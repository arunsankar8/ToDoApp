package com.example.todoapps.ui.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapps.R
import com.example.todoapps.database.entity.Tasks

import kotlinx.android.synthetic.main.item_search_layout.view.*


class SearchRecyclerAdapter(private val context: Context, private val containerData: List<Tasks>): RecyclerView.Adapter<SearchRecyclerAdapter.SearchRecyclerViewHolder>() {
    override fun onBindViewHolder(holder: SearchRecyclerViewHolder, position: Int) {





    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SearchRecyclerViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.item_search_layout, parent, false)
        return SearchRecyclerViewHolder(itemView)
    }


    override fun getItemCount(): Int {

        return (containerData.size)
    }
    
    class SearchRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

}