package com.example.ml3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.main_toolbar)
        setSupportActionBar(toolbar)

        val myDataset = Datasource().loadRecipes()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = RecipeAdapter(myDataset) { recipe ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("RECIPE_TITLE", getString(recipe.titleRes))
            intent.putExtra("RECIPE_LONG_DESC", getString(recipe.longDescRes))
            intent.putExtra("RECIPE_IMAGE", recipe.imageRes)
            startActivity(intent)
        }

        recyclerView.setHasFixedSize(true)
    }
}