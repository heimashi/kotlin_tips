package com.sw.kotlin.tip4

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, frameId: Int) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(frameId, fragment)
    transaction.commit()
}


fun Activity.invokeActivity(cls: Class<*>) {
    startActivity(Intent(this, cls))
}