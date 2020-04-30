package com.example.desafiokotlin.Adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.desafiokotlin.Model.Article
import com.example.desafiokotlin.R

class MyListAdapter(private val context: Activity, private val title: ArrayList<Article>)
    : ArrayAdapter<Article>(context, R.layout.list_item, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView

        titleText.text = title[position].title

        return rowView
    }
}

