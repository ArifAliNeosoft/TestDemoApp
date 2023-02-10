package com.example.testdemoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testdemoapp.activities.MainActivity
import com.example.testdemoapp.R
import com.example.testdemoapp.models.ProductListModel
import com.example.testdemoapp.models.ProductSliderModel

class ProductListAdapter(
    val rvProductList: ArrayList<ProductListModel>
) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {
        var tvProductName = itemView.findViewById<AppCompatTextView>(R.id.tvProductName)
        var ivProduct = itemView.findViewById<AppCompatImageView>(R.id.ivProduct)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false),
            viewType
        )
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ProductViewHolder, position: Int) {
        holder.tvProductName.setText(rvProductList.get(position).title)
        holder.ivProduct.setBackgroundResource(rvProductList.get(position).image)
    }

    override fun getItemCount(): Int {
        return rvProductList.size
    }

}