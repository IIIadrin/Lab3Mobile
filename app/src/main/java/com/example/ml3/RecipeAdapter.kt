package com.example.ml3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecipeAdapter(
    private val dataset: List<Recipe>,
    private val onClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.recipe_title)
        val dayView: TextView = view.findViewById(R.id.day_number)
        val imageView: ImageView = view.findViewById(R.id.recipe_image)
        val descView: TextView = view.findViewById(R.id.recipe_short_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return RecipeViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = dataset[position]
        val context = holder.itemView.context

        holder.titleView.text = context.getString(item.titleRes)
        holder.dayView.text = "${context.getString(R.string.day_prefix)} ${item.id}"
        holder.descView.text = context.getString(item.shortDescRes)
        holder.imageView.setImageResource(item.imageRes)

        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = dataset.size
}