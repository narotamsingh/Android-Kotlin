package com.example.spinner.spinnerandroidkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Spinner
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val worldcity = arrayOf("Paris", "Dubai", "New York", "Singapore", "Kuala Lumpur", "Istanbul", "Tokyo", "Seoul")
    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, worldcity)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = adapter;
    }

    fun get (view: View){
        val spinner = findViewById(R.id.spinner) as Spinner
        val chosen = (spinner.getSelectedItem()).toString()
        textView.text = "Selected City: "+chosen
    }
}
