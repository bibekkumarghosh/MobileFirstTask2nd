package com.example.mobilefirsttask2nd

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var images = intArrayOf(R.drawable.baby_yoda, R.drawable.geralt_rivia,
        R.drawable.mandalorian, R.drawable.moonknight, R.drawable.morty_smith,
        R.drawable.peacemaker, R.drawable.rick_sanchez, R.drawable.satoru_gojo,
        R.drawable.yuji_itadori, R.drawable.empty) //R.drawable.vigilante,

    var titles = arrayOf("Baby Yoda", "Geralt Rivia", "Mandalorian", "Moon Knight",
        "Morty Smith", "Peacemaker", "Rick Sanchez", "Satoru Gojo", "Yuji Itadori",
        "empty")// "Vigilante",




    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.imageView.setImageResource(images_empty[position])
//
//        // sets the text to the textview from our itemHolder class
//        holder.textView.text = titles_empty[position]
        holder.imageView.setImageResource(images[fullList[position]])

        // sets the text to the textview from our itemHolder class
        holder.textView.text = titles[fullList[position]]
        Log.d("ADebugTag", "yahoo" + position)


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return titles.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener {
                val itemIndex: Int = adapterPosition
                Toast.makeText(itemView.context, "you clicked on ${itemIndex}", Toast.LENGTH_LONG).show()
                emptyList.add(itemIndex)
                emptyList.remove(9)
                fullList.add(9)
                fullList.remove(itemIndex)
            }
        }
    }

}

var emptyList = mutableListOf<Int>(9,9,9,9,9,9,9,9,9,9)
var fullList = mutableListOf<Int>(0,1,2,3,4,5,6,7,8,9)