package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<Movies>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.the_shawshank_redemption,
            R.drawable.the_godfather,
            R.drawable.the_dark_knight,
            R.drawable.the_godfather_part_2,
            R.drawable.twelve_angry_men
        )
        heading = arrayOf(
            "The Shawshank Redemption 9.3" ,
            "The Godfather 9.2",
            "The Dark Knight 9.0",
            "The Godfather Part II 9.0" ,
            "12 Angry Men 9.0"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Movies>()
        getUserData()

    }

    private fun getUserData(){
        for (i in imageId.indices){
            val movies = Movies(imageId[i],heading[i])
            newArrayList.add(movies)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}