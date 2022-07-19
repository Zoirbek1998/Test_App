package dev.future.apptests.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.future.apptests.model.User
import dev.future.testapp.R
import dev.future.testapp.RecyclerActivity
import org.w3c.dom.Text

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var title = arrayOf("Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One",)
    private var detailes = arrayOf("Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One","Chapter One",)
    private var images = intArrayOf(R.drawable.a,R.drawable.b,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,R.drawable.a,)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView
        var itemSupTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.image)
            itemName = itemView.findViewById(R.id.name)
            itemSupTitle = itemView.findViewById(R.id.suptitle)

            itemView.setOnClickListener {
                val position : Int = adapterPosition
                Toast.makeText(itemView.context, "${title[position]}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rec_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.itemName.text = title[position]
        holder.itemSupTitle.text = detailes[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }


}