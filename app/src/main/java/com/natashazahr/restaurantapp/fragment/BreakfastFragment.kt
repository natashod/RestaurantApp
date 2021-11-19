package com.natashazahr.restaurantapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.natashazahr.restaurantapp.adapter.FoodAdapter
import com.natashazahr.restaurantapp.databinding.FragmentBreakfastBinding
import com.natashazahr.restaurantapp.model.DataRecipes
import com.natashazahr.restaurantapp.model.Recipes

class BreakfastFragment : Fragment() {
    //lateinit = inisialisasinya entaran
    private lateinit var breakfastBinding: FragmentBreakfastBinding
    private var list : ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        breakfastBinding = FragmentBreakfastBinding.inflate(inflater, container, false)

        return breakfastBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataBreakfast)
        breakfastBinding.rvBreakfast.apply{
            setHasFixedSize(true)
            //fungsi biar size ga berubah
            layoutManager = GridLayoutManager(context,2)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }
}