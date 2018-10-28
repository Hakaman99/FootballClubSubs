package com.example.root.submission1

import android.content.Context
import org.jetbrains.anko.*

class MainActivityUI : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>)= with(ui){
        relativeLayout() {
            padding= dip(16)

            imageView(){
                id = R.id.img_logo
                imageResource=R.drawable.img_mu
            }.lparams(width= dip(70),height = dip(70))

            textView(){
                id = R.id.tv_name
                text="Test"
            }.lparams(width= matchParent,height = matchParent){
                leftMargin=dip(10)
                rightOf(R.id.img_logo)
                centerVertically()
            }

        }

    }
}