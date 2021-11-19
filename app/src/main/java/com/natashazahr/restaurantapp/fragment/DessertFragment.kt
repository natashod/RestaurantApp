package com.natashazahr.restaurantapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.natashazahr.restaurantapp.R
import com.natashazahr.restaurantapp.adapter.FoodAdapter
import com.natashazahr.restaurantapp.databinding.FragmentDessertBinding
import com.natashazahr.restaurantapp.databinding.FragmentVegetarianBinding
import com.natashazahr.restaurantapp.model.DataRecipes
import com.natashazahr.restaurantapp.model.Recipes


class DessertFragment : Fragment() {

    private lateinit var dessertBinding: FragmentDessertBinding
    private var list : ArrayList<Recipes> = arrayListOf()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dessertBinding = FragmentDessertBinding.inflate(inflater,container,false)
        return dessertBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataDessert)
        dessertBinding.rvDessert.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }


}