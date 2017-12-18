package com.sw.kotlin.tip10;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class JavaExample10 {

    public void testClick(Context context) {
        TextView textView = new TextView(context);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle click
            }
        });
    }

}
