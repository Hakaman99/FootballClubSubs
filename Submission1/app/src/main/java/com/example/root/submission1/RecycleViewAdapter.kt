package com.example.root.submission1
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class RecycleViewAdapter(private val context: Context,private val items:List<Item>,
                         private val listener:(Item)->Unit)
    : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(MainActivityUI().createView(AnkoContext.create(context,false)))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(items[p1],listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view),AnkoLogger {
        private val name = itemView.findViewById<TextView>(R.id.tv_name)
        private val image = itemView.findViewById<ImageView>(R.id.img_logo)
        fun bindItem(items: Item, listener: (Item) -> Unit){
            name.text = items.name
//            items.image?.let { Picasso.get().load(it).into(image) }
            Glide.with(itemView.context).load(items.image).into(image)
            info { "TextView Name = ${items.name}, ImageView Club = ${items.image}" }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}