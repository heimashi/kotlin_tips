package com.sw.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sw.kotlin.tip4.invokeActivity
import com.sw.kotlin.tip6.Tip6Activity
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toTip6.setOnClickListener {
            invokeActivity(Tip6Activity::class.java)
        }
    }
}
