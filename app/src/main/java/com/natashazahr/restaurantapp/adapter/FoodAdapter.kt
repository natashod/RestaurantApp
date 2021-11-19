package com.natashazahr.restaurantapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natashazahr.restaurantapp.DetailActivity
import com.natashazahr.restaurantapp.databinding.ItemFoodBinding
import com.natashazahr.restaurantapp.model.Recipes

class FoodAdapter(private val listFood : ArrayList<Recipes>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){
//    fingsi inner class karna class ga boleh dlm class jadi class foodviewholdernya bakal jadi sub class

    inner class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
        //inflate buat nempel layout
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        //gabungin layoutnya sama datanya
        // fungsi position untuk nge get data mana yg diurutin secara berurutan dan sesuai
        //kalo ga pake[position] dipake biar layoutnya gak random posisinya
        with(holder){
            with(listFood[position]){
                Glide.with(holder.itemView.context).load(pictures).into(binding.ivItemRecipe)
                binding.tvItemNameRecipe.text = name
                binding.tvItemMenu.text = category
                binding.tvNumberRecipe.text = number

                val mContext = holder.itemView.context
                //kalo di klik ngasih respon buat pindah halaman dgn bawa bbrp data
                holder.itemView.setOnClickListener{
                    val dataSend = Recipes(
                        name = listFood[position].name,
                        category = listFood[position].category,
                        description = listFood[position].description,
                        ingredients = listFood[position].ingredients,
                        instructions = listFood[position].instructions,
                        pictures = listFood[position].pictures,
                        number = listFood[position].number,
                        calories = listFood[position].calories,
                        carbo = listFood[position].carbo,
                        protein = listFood[position].protein,
                    )
                    //intent = kang paket
                    val intentToDetail = Intent(mContext, DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA, dataSend)
                    mContext.startActivity(intentToDetail)
                }
            }
        }
    }

    override fun getItemCount(): Int=listFood.size

}