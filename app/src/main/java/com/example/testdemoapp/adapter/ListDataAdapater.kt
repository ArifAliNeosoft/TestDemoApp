package com.example.testdemoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testdemoapp.activities.MainActivity
import com.example.testdemoapp.R
import java.util.*

class ListDataAdapater(
    val context: Context,
    var activity: MainActivity,
    val rvDataList: ArrayList<String>,
    var size: Int

) : RecyclerView.Adapter<ListDataAdapater.EmailViewHolder>() {


    class EmailViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {
        var tvLabel = itemView.findViewById<AppCompatTextView>(R.id.tvLabel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListDataAdapater.EmailViewHolder {


        return EmailViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false),
            viewType
        )


    }


    override fun onBindViewHolder(holder: ListDataAdapater.EmailViewHolder, position: Int) {
        holder.tvLabel.setText(rvDataList.get(position))

    }

    override fun getItemCount(): Int {
        if (size == 0) {
            return rvDataList.size
        } else {
            return size
        }

    }

}