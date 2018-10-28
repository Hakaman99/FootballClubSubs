package com.example.root.submission3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.example.root.submission3.Favorites.FavoritesFragment
import com.example.root.submission3.R.id.*
import com.example.root.submission3.Teams.TeamLastLeague.TeamsLastLeagueFragment
import com.example.root.submission3.Teams.TeamNextLeague.TeamNextLeagueFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                last_match -> {
                    loadLastMatchFragment(savedInstanceState)
                }
                next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                }
                favorites -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = last_match
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamNextLeagueFragment(),
                            TeamNextLeagueFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoritesFragment(),
                            FavoritesFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadLastMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsLastLeagueFragment(),
                            TeamsLastLeagueFragment::class.java.simpleName)
                    .commit()
        }
    }
}
