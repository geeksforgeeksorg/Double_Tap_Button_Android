package com.gfg.double_click_button

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declare the button from the layout file as Text View
        // Since the method works only on Views
        val dBtn:TextView = findViewById(R.id.btn)


        // Implementing a DoubleClickListener on the Button
        dBtn.setOnClickListener(object : DoubleClickListener() {
            override fun onDoubleClick(v: View?) {
                Toast.makeText(applicationContext,"Double Click",Toast.LENGTH_SHORT).show()
            }
        })
    }

    // This class has methods that check if two clicks were registered
    // within a span of DOUBLE_CLICK_TIME_DELTA i.e., in our case
    // equivalent to 300 ms
    abstract class DoubleClickListener : View.OnClickListener {
        var lastClickTime: Long = 0

        override fun onClick(v: View?) {
            val clickTime = System.currentTimeMillis()
            if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
                onDoubleClick(v)
            }
            lastClickTime = clickTime
        }

        abstract fun onDoubleClick(v: View?)

        companion object {
            //milliseconds
            private const val DOUBLE_CLICK_TIME_DELTA: Long = 300
        }
    }
}
