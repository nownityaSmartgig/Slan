package com.slan.admin

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.slan.admin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_tournament, R.id.navigation_players, R.id.navigation_teams, R.id.navigation_menu
            )
        )
        setupActionBarWithNavController(navController , appBarConfiguration)

        // Change the color of the navigation up arrow
//        supportActionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_white))


        // Change the color of the navigation up arrow
//        val arrowDrawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_white)
//        val wrappedArrow = DrawableCompat.wrap(arrowDrawable!!)
//        DrawableCompat.setTint(wrappedArrow, ContextCompat.getColor(this, android.R.color.white))
//        supportActionBar?.setHomeAsUpIndicator(wrappedArrow)


        // Create a custom navigation icon with the desired color
//        val customNavIcon = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_white)

        // Set the custom navigation icon as the home indicator
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setHomeAsUpIndicator(customNavIcon)

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