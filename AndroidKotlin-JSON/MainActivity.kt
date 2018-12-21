package com.example.json.kotlin_json

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun get (view: View){
        val downloadData = Download()
        try {
            val jsonObject = JSONObject(downloadData.execute("https://jigyasu.org/data/json.php").get())
            val title = editText.text.toString()
            val jsonResult = jsonObject.getString(title)
            textView.text = "URL: " + jsonResult
        } catch (e: Exception) {
            e.printStackTrace()
        }
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
