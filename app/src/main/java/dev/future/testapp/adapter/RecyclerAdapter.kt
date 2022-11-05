package dev.future.testapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.future.testapp.R
import org.w3c.dom.Text

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    val name = arrayOf("Azim", "Azim", "Azim", "Azim", "Azim", "Azim", "Azim", "Azim", "Azim")
    val suptitle = arrayOf(
        "qalesan",
        "qalesan",
        "qalesan",
        "qalesan",
        "qalesan",
        "qalesan",
        "qalesan",
        "qalesan",
        "qalesan",

    )
    val image = arrayOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.a,
        R.drawable.a,
        R.drawable.a,
        R.drawable.a,
        R.drawable.a,
        R.drawable.a,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemName: TextView
        var itemSupTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.image)
            itemName = itemView.findViewById(R.id.title)
            itemSupTitle = itemView.findViewById(R.id.suptitle)

            itemView.setOnClickListener {
                val position : Int = adapterPosition
                Toast.makeText(itemView.context, "${name[position]}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rec_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(image[position])
        holder.itemName.text = name[position]
        holder.itemSupTitle.text =suptitle[position]
    }

    override fun getItemCount(): Int {
       return name.size
    }


}