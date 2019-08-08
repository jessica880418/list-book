package com.example.jessica.listbook

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso



class RecipeAdapter(private val context: Context,
                    private val dataSource: ArrayList<Recipe>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        // 1
        if (convertView == null) {

            // 2
            view = inflater.inflate(R.layout.list_item_recipe, parent, false)

            // 3
            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById(R.id.recipe_list_thumbnail) as ImageView
            holder.titleTextView = view.findViewById(R.id.recipe_list_title) as TextView
            holder.subtitleTextView = view.findViewById(R.id.recipe_list_subtitle) as TextView
            holder.detailTextView = view.findViewById(R.id.recipe_list_detail) as TextView

        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }



        val recipe = getItem(position) as Recipe

        holder.titleTextView.text = recipe.title
        holder.subtitleTextView.text = recipe.description
        holder.detailTextView.text = recipe.label

        Picasso.with(context).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(holder.thumbnailImageView)



        return view
    }

    private class ViewHolder {
        lateinit var titleTextView: TextView
        lateinit var subtitleTextView: TextView
        lateinit var detailTextView: TextView
        lateinit var thumbnailImageView: ImageView
    }
}