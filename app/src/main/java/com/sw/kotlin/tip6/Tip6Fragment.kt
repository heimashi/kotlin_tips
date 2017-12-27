package com.sw.kotlin.tip6

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.fragment_tip6.*


class Tip6Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_tip6, container, false)
        /*
        * 这时候不能在onCreateView方法里用view，需要在onViewCreate里，原理是插件用了getView来findViewById
        * */
        //tip6Tv.text = "test2"
        return view
    }

    /*
    * 需要在onViewCreate里，原理是插件用了getView来findViewById
    * */
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tip6Tv.text = "test"
    }
}