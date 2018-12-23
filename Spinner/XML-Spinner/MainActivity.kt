package com.spinner.xml.xml_spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun get (view: View){
            val spinner = findViewById(R.id.spinner) as Spinner
            val chosen = (spinner.getSelectedItem()).toString()
            textView.text = chosen
    }
}
