package com.natashazahr.restaurantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.natashazahr.restaurantapp.databinding.ActivityMainBinding
import com.natashazahr.restaurantapp.databinding.ActivityMainBinding.inflate
import com.natashazahr.restaurantapp.fragment.BreakfastFragment
import com.natashazahr.restaurantapp.fragment.DessertFragment
import com.natashazahr.restaurantapp.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {
/*
* val -> value : immutable
* var -> bisa di ubah2 : mutable
* modifier : private , protected , inner
* root : yang ngasih akses value/view (?)
* supportFragmentManager : buat nempelin fragmen
* begin Transaction : buat memulai tugas si supportFragmentManager
* */

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        setCurrentFragment(BreakfastFragment())
        mainBinding.navBottomMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_breakfast -> setCurrentFragment(BreakfastFragment())
                R.id.ic_vegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.ic_dessert -> setCurrentFragment(DessertFragment())

            }
            true
        }
    }
    private fun setCurrentFragment(fragment : Fragment) = supportFragmentManager.beginTransaction().apply{
    replace(R.id.fl_main, fragment)
        commit()

    }

}