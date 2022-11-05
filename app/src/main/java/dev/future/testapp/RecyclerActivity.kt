package dev.future.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.future.apptests.adapter.Adapter
import dev.future.testapp.adapter.RecyclerAdapter
import dev.future.testapp.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    lateinit var binding : ActivityRecyclerBinding
    lateinit var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        binding.recyclerView2.adapter = adapter
    }
}