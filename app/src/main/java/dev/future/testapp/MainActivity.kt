package dev.future.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import dev.future.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var appBarConfiguration2: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration2 = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.settingsFragment),
            binding.drawerLayout
        )


        setSupportActionBar(binding.toolbar)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.searchFragment2)
        )

        setupActionBarWithNavController(navController,appBarConfiguration)

        setupActionBarWithNavController(navController,appBarConfiguration2)

        // bottomMenu uchun
        binding.bottomNav.setupWithNavController(navController)

        // drawerMenu uchun
        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{_, destination, arguments ->
            if(destination.id == R.id.settingsFragment){
                binding.bottomNav.visibility = View.GONE
            }else{
                binding.bottomNav.visibility = View.VISIBLE
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (item.itemId == R.id.termsAndConditions){
//            val action = NavGraphDirections.actionGlobalTermsFragment()
//            navController.navigate(action)
//            true
//        }else{
//            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//        }
//
//    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration2) || super.onSupportNavigateUp()
    }
}