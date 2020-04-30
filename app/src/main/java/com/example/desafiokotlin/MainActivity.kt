package com.example.desafiokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("")

        val button = findViewById<Button>(R.id.bt_start)
        button.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("page_title","r/androiddev")
            startActivity(intent)
        }
    }
}
