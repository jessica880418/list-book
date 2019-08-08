package com.example.jessica.listbook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.ListView



class ListProductActivity : AppCompatActivity() {

    private lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_product)

        listView = findViewById(R.id.recipe_list_view)

        val recipeList = Recipe.getRecipesFromFiles("recipes.json", this)
        val adapter = RecipeAdapter(this, recipeList)
        listView.adapter = adapter

    }

}
