package com.neosoft.myapplication.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*

import com.neosoft.myapplication.MyInterface
import com.neosoft.myapplication.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        setSupportActionBar(toolbar)


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment



        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.settingsFragment, R.id.notificationsFragment),
            drawer_layout
        )

        // toolbar.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottom_nav_view.setupWithNavController(navController)
        navView.setupWithNavController(navController)



        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.splashFragment) {
                toolbar?.visibility = View.GONE
                bottom_nav_view.visibility = View.GONE
            }
            else if (destination.id == R.id.loginFragment) {
                toolbar?.visibility = View.GONE
                bottom_nav_view.visibility = View.GONE
            }
            else {
                toolbar?.visibility = View.VISIBLE
                bottom_nav_view.visibility = View.VISIBLE
            }



        }


    }


    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp(appBarConfiguration)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.aboutApp -> {
//                val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
//                navController.navigate(action)
                return true
            }
            else -> item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.splashFragment) {
                toolbar?.visibility = View.GONE
                bottom_nav_view.visibility = View.GONE
            }
            else if (destination.id == R.id.loginFragment) {
                toolbar?.visibility = View.GONE
                bottom_nav_view.visibility = View.GONE
            }
            else {
                toolbar?.visibility = View.VISIBLE
                bottom_nav_view.visibility = View.VISIBLE
            }



        }
    }
}