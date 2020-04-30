package com.example.desafiokotlin

import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiokotlin.Adapters.MyListAdapter
import com.example.desafiokotlin.Model.Article
import org.json.JSONObject
import java.net.URL

class HomeActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val page_title = intent.getStringExtra("page_title")

        var title = findViewById<TextView>(R.id.activity_home_tv_page_title)
        title.setText(page_title)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Carregando ....")
        progressDialog.setCancelable(false)
        progressDialog.show()

        var listView = findViewById<ListView>(R.id.listview_article)

        Thread({
            var result_json = URL("https://www.reddit.com/r/androiddev.json?raw_json=1").readText()

            var list_data = JSONObject(result_json).getJSONObject("data").getJSONArray("children")
            var list_article = ArrayList<Article>()

            var cont: Int = 0
            while (cont < list_data.length()) {
                var title = list_data.getJSONObject(cont).getJSONObject("data").getString("title")
                list_article.add(Article(title))
                cont++
            }

            runOnUiThread({
                //Update UI
                val myListAdapter = MyListAdapter(this, list_article)
                listView.adapter = myListAdapter

                while ( progressDialog.isShowing){
                    if(listView.isShown){
                        progressDialog.dismiss()
                    }
                }
            })
        }).start()
    }
}

