package com.example.ml3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val title = intent.getStringExtra("RECIPE_TITLE")
        val longDesc = intent.getStringExtra("RECIPE_LONG_DESC")
        val imageRes = intent.getIntExtra("RECIPE_IMAGE", 0)

        findViewById<TextView>(R.id.detail_title).text = title
        findViewById<TextView>(R.id.detail_long_desc).text = longDesc
        findViewById<ImageView>(R.id.detail_image).setImageResource(imageRes)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}