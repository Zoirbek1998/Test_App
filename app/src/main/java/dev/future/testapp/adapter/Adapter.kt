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
import org.w3c.dom.Text

class Adapter(private val context: Activity,private val items : ArrayList<User>) : ArrayAdapter<User>(context,
    R.layout.list_item)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item,null)

        val image : ImageView= view.findViewById(R.id.profileimg)
        val name :TextView=  view.findViewById(R.id.personName)
        val lastMessage :TextView=  view.findViewById(R.id.lastMessage)
        val time :TextView=  view.findViewById(R.id.time)

        image.setImageResource(items[position].imageId)
        name.text = items[position].name
        lastMessage.text = items[position].lastMessage
        time.text = items[position].lastMsgTime

        return view

    }

}