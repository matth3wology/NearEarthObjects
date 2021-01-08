package com.alpha.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alpha.myapplication.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupHomeFragment()
    }

    private fun setupHomeFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.home_container, HomeFragment())
        fragmentTransaction.commit()
    }
}