package dev.future.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import dev.future.testapp.databinding.ActivityMenuBinding
import dev.future.testapp.databinding.ActivityTabLayoutBinding

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.termsAndConditions -> Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            R.id.settingsFragment -> Toast.makeText(this, "Setting Fragment", Toast.LENGTH_SHORT).show()
            R.id.fragment -> Toast.makeText(this, "Fragment", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}