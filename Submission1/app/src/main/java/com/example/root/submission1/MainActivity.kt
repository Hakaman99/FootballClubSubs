package com.example.root.submission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(),AnkoLogger {
    private var items:MutableList<Item> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityRecyclerView().setContentView(this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_ball)
        initData()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=RecycleViewAdapter(this,items){
            startActivity<DetailActivity>("detail" to it)
        }

    }
    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val detail= resources.getStringArray(R.array.detail_club)
        val image =resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],
                    image.getResourceId(i,0),
                    detail[i]))
        }
        image.recycle()
    }

    class MainActivityRecyclerView : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {
            verticalLayout{
                lparams(width= matchParent,height = matchParent)
                recyclerView(){
                    id=R.id.rv_ball
                }.lparams(width= matchParent,height= matchParent)
            }
        }

    }
}