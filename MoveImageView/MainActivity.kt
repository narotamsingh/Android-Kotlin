package com.example.imagemotion.imagemotion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listenerd = View.OnClickListener(function = {view ->
            imageView.y = imageView.y + 50
        })
        imageDown.setOnClickListener(listenerd)

        var listeneru = View.OnClickListener(function = {view ->
            imageView.y = imageView.y - 50
        })
        imageUp.setOnClickListener(listeneru)

        var listenerr = View.OnClickListener(function = {view ->
            imageView.x = imageView.x + 50
        })
        imageRight.setOnClickListener(listenerr)

        var listenerl = View.OnClickListener(function = {view ->
            imageView.x = imageView.x - 50
        })
        imageLeft.setOnClickListener(listenerl)
    }
}