package com.example.mycourseworkaston.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mycourseworkaston.R
import com.example.mycourseworkaston.databinding.ActivityMainBinding
import com.example.mycourseworkaston.presentation.charactersFragment.CharactersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_frame_layout, CharactersFragment())
            .commit()
    }

    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.activity_frame_layout, fragment
        )
            .addToBackStack("Init")
            .commit()
    }
}