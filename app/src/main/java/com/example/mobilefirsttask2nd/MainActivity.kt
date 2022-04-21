package com.example.mobilefirsttask2nd

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // empty recycler view
        val recyclerview_empty = findViewById<RecyclerView>(R.id.recyclerview_empty)
        recyclerview_empty.layoutManager = LinearLayoutManager(this)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter()
        val adapterEmpty = CustomAdapterEmpty()

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        recyclerview_empty.adapter = adapterEmpty


        val shuffleButton: Button = findViewById(R.id.shuffle)
        shuffleButton.setOnClickListener {
            fullList.shuffle()
            recyclerview.adapter = adapter

        }
    }
}


