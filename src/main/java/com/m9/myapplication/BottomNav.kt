package com.m9.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.m9.myapplication.DB.SeleccionEspDBHelper
import com.m9.myapplication.Fragments.FormFragment
import com.m9.myapplication.Fragments.ListFragment

class BottomNav : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        var dbHelber: SeleccionEspDBHelper = SeleccionEspDBHelper(this)

        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)
        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_form -> {
                    loadFragment(FormFragment(dbHelber))
                    true
                }
                R.id.nav_list -> {
                    loadFragment(ListFragment(dbHelber))
                    true
                }

                R.id.nav_home -> {
                    loadFragment(ListFragment(dbHelber))
                    true
                }
                else -> {false}
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}