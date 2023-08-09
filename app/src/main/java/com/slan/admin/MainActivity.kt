package com.slan.admin

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.slan.admin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
//        val toolbar =

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_tournament, R.id.navigation_players, R.id.navigation_teams, R.id.navigation_menu
            )
        )
        setupActionBarWithNavController(navController , appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_tournament, R.id.navigation_players, R.id.navigation_teams, R.id.navigation_menu -> {
//                    navView.show()
                    navView.visibility = View.VISIBLE
                }
                else -> {
                    navView.visibility = View.GONE
                }
            }
        }

        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp()||super.onSupportNavigateUp()
    }

//    fun BottomNavigationView.show() {
//        if (!isVisible) {
//            animate().translationY(0f).duration = 300
//            visibility = View.VISIBLE
//        }
//    }
//
//    fun BottomNavigationView.hide() {
//        if (!isVisible) {
//            animate().translationY(height.toFloat()).duration = 300
//            visibility = View.GONE
//        }
//    }
}