package com.example.root.submission1

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity(), AnkoLogger {
    private lateinit var name: String
    private lateinit var detail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val items = intent.getParcelableExtra<Item>("detail")

        name = items.name.toString()
        detail = items.detail.toString()

        DetailActivityUI().setContentView(this)

        val imageDetail = findViewById<ImageView>(R.id.img_detail)
        Glide.with(this).load(items.image).into(imageDetail)

    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout() {
                padding = dip(15)
               imageView() {
                    id=R.id.img_detail
                   imageResource=R.drawable.img_mu
                }.lparams(width = dip(80), height = dip(80)) {
                    centerHorizontally()
                }

                textView() {
                    text = "${ui.owner.name} ${ui.owner.detail}"
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
                        textAlignment= View.TEXT_ALIGNMENT_CENTER
                    }
                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.img_detail)
                    topMargin=dip(10)
                    centerHorizontally()
                }
            }
        }

    }
}
