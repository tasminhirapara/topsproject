package com.example.topsproject.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.topsproject.Activity.CategoryActivity
import com.example.topsproject.Model.HomeModel
import com.example.topsproject.R
import com.squareup.picasso.Picasso

class HomeAdapter(var context: Context, var list: MutableList<HomeModel>) : RecyclerView.Adapter<viewholder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder
    {
        val view = LayoutInflater.from(context).inflate(R.layout.home_design, parent, false)
        return viewholder(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int)
    {
        holder.textView.text = list[position].name
        Picasso.get().load(list.get(position).image).into(holder.imageView)

        holder.imageView.setOnClickListener()
        {
            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("position", position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}

class viewholder (itemview : View): RecyclerView.ViewHolder(itemview)
{
    var textView = itemView.findViewById<TextView>(R.id.dashboard_txt)
    var imageView = itemView.findViewById<ImageView>(R.id.dashboard_img)


}
