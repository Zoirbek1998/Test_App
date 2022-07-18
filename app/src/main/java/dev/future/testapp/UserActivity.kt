package dev.future.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import dev.future.testapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val country = intent.getStringExtra("country")
        val image = intent.getIntExtra("image", R.drawable.f)

        binding.profileImage.setImageResource(image)
        binding.name.text = name
        binding.phone.text = phone
        binding.uae.text = country
    }
}