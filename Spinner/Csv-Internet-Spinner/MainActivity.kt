package com.example.spinner.csv_internet_spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.os.AsyncTask
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import android.widget.Spinner


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val download = Download()
        try {
            val color = Download().execute("https://jigyasu.org/data/csv.php").get()
            var colors: List<String> = color.split(",").map { it.trim() }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            // bind data - spinner object with adapter
            spinner.adapter = adapter;
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun get (view: View){
        val spinner = findViewById(R.id.spinner) as Spinner
        val chosen = (spinner.getSelectedItem()).toString()
        textView.text = "Selected: " + chosen
    }

inner class Download : AsyncTask<String,Void,String>(){
    override fun doInBackground(vararg adds: String?): String {
        var downloaded = ""
        var url : URL
        val httpConnection : HttpURLConnection
        try {
            url = URL(adds[0])
            httpConnection = url.openConnection() as HttpURLConnection
            val input = httpConnection.inputStream
            val inputReader = InputStreamReader(input)
            var data = inputReader.read()
            while (data > 0) {
                val character = data.toChar()
                downloaded += character
                data = inputReader.read()
            }
            return downloaded
        } catch (e: Exception) {
            e.printStackTrace()
            return downloaded
        }
    }
}
}