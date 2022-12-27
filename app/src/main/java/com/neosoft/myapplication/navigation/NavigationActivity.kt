package com.neosoft.myapplication.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.neosoft.myapplication.MainNavGraphDirections
import com.neosoft.myapplication.MyInterface
import com.neosoft.myapplication.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        setSupportActionBar(toolbar)


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        navController = navHostFragment.navController

        // toolbar.setupWithNavController(navController)
        setupActionBarWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.aboutApp -> {
                val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
                navController.navigate(action)
                return true
            }
            else -> item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}