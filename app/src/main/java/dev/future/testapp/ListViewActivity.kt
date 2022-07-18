package dev.future.testapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.future.apptests.adapter.MyAdapter
import dev.future.apptests.model.User
import dev.future.testapp.databinding.ActivityListViewBinding


class ListViewActivity : AppCompatActivity() {

    lateinit var userArrayList: ArrayList<User>

    lateinit var binding: ActivityListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.g,
            R.drawable.g,
            R.drawable.g,
            R.drawable.g,
            R.drawable.g,
            R.drawable.g,
            R.drawable.g,
        )

        val name = arrayOf(
            "Kiristofer",
            "Craig",
            "Sergio",
            "Mubariz",
            "Mike",
            "Tao",
            "Tao",
            "Tao",
            "Tao",
            "Tao",
            "Tao",
            "Tao",
            "Tao",


        )
        val phoneNo = arrayOf(
            "91 6119878",
            "91 9874545",
            "91 1234567",
            "91 7898989",
            "91 9874545",
            "91 9874545",
            "91 9874545",
            "91 9874545",
            "91 9874545",
            "91 9874545",
            "91 9874545",
            "91 9874545",
            "91 9874545",
            "91 9874545",
        )

        val lastMsgTime = arrayOf(
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
            "7:05 pm",
        )

        val lastMessage = arrayOf(
            "Heye",
            "Supp",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
            "Lest's Catchup",
        )

        val country = arrayOf(
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
            "Unit States",
        )

        userArrayList = ArrayList()

        // indexlarini berish
        for (i in name.indices){
            val user = User(name[i], lastMessage[i], lastMsgTime[i],phoneNo[i],country[i],imageId[i] )
            userArrayList.add(user)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            val name = name[position]
            val phone = phoneNo[position]
            val country = country[position]
            val image = imageId[position]

            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone",phone)
            i.putExtra("country",country)
            i.putExtra("image",image)
            startActivity(i)
        }

    }

}