package com.example.mycourseworkaston.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mycourseworkaston.R
import com.example.mycourseworkaston.databinding.ActivityMainBinding
import com.example.mycourseworkaston.presentation.charactersFragment.CharactersFragment
import com.example.mycourseworkaston.presentation.episodesFragment.EpisodesFragment
import com.example.mycourseworkaston.presentation.locationsFragment.LocationsFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charactersFragment = CharactersFragment()
        val episodesFragment = EpisodesFragment()
        val locationsFragment = LocationsFragment()

        openFragment(charactersFragment)

//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.activity_frame_layout, charactersFragment)
//            .commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_menu_characters->openFragment(charactersFragment)
                R.id.bottom_menu_episodes -> openFragment(episodesFragment)
                R.id.bottom_menu_locations -> openFragment(locationsFragment)
            }
            true
        }
    }

    private fun openFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_frame_layout, fragment)
            addToBackStack("Init")
            commit()
        }
}