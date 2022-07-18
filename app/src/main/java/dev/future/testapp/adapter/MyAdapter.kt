package dev.future.apptests.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import dev.future.apptests.model.User
import dev.future.testapp.R

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(
        context,
        R.layout.list_item, arrayList
    ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, null)

        val imageView = view.findViewById<ImageView>(R.id.profileimg)
        val userName = view.findViewById<TextView>(R.id.personName)
        val lastMsg: TextView = view.findViewById(R.id.lastMessage)
        val time: TextView = view.findViewById(R.id.time)

        imageView.setImageResource(arrayList[position].imageId)
        userName.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMessage
        time.text = arrayList[position].lastMsgTime

        return view
    }

}

