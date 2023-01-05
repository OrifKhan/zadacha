package com.example.zadacha_3.storis


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.zadacha_3.R

class StorisActivitiy : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storis_activitiy)
        val stor=intent.getParcelableExtra<Storis>("storis")
        val ingView= findViewById<ImageView>(R.id.imageViewseconAct)
        val textView= findViewById<TextView>(R.id.showTextStoris)
        if (stor != null) {
            ingView.setImageResource(stor.imegStoris)
            textView.text=stor.textStoris
        }
    }
}