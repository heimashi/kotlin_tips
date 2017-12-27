package com.sw.kotlin.tip6

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sw.kotlin.tip4.addFragmentToActivity
import com.sw.kotlin.tips.R

class Tip6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        var fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as Tip6Fragment?
        if (fragment == null) {
            fragment = Tip6Fragment()
            addFragmentToActivity(fragment, R.id.fragmentContainer)
        }
    }
}


