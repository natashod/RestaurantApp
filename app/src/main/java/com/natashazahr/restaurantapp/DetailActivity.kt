package com.natashazahr.restaurantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.natashazahr.restaurantapp.databinding.ActivityDetailBinding
import com.natashazahr.restaurantapp.model.Recipes

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        showData()
    }

    private fun showData() {
        val getData = intent.getParcelableExtra<Recipes>(RECIPE_DATA) as Recipes
        Glide.with(this).load(getData.pictures).into(detailBinding.ivDetail)
        detailBinding.tvNameDetail.text = getData.name
        detailBinding.tvDescriptionDetail.text = getData.description
        detailBinding.tvCalories.text = getData.calories
        detailBinding.tvCarbo.text = getData.carbo
        detailBinding.tvIngredients.text = getData.ingredients
        detailBinding.tvIngredientsLabel.text = getData.ingredients
        detailBinding.tvLabelInstruction.text = getData.instructions
        detailBinding.tvProtein.text = getData.protein
        detailBinding.tvResepLable.text = getData.ingredients
        detailBinding.tvValueCalories.text = getData.calories
        detailBinding.tvValueCarbo.text = getData.carbo
        detailBinding.tvValueProtein.text = getData.protein
    }

    //    comp obj = obj yg bisa di akses kelas lain
    companion object {
        const val RECIPE_DATA = "recipe_data"
    }
}