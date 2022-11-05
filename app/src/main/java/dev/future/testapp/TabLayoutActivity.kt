package dev.future.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import dev.future.testapp.databinding.ActivityTabLayoutBinding
import dev.future.testapp.fragment.HomeFragment
import dev.future.testapp.fragment.LoginFragment
import dev.future.testapp.fragment.SearchFragment

class TabLayoutActivity : AppCompatActivity() {

    private val fragmentList = listOf(
        HomeFragment.newInstance(),
        LoginFragment.newInstance(),
        SearchFragment.newInstance(),
    )

    lateinit var binding: ActivityTabLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportFragmentManager.beginTransaction().replace(R.id.container,fragmentList[tab!!.position]).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }
}