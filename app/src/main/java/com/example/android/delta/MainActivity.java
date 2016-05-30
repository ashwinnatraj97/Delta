package com.example.android.delta;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("" + global.i);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save state to the savedInstanceState
        TextView textView = (TextView) findViewById(R.id.text);
        CharSequence save = textView.getText();
        savedInstanceState.putCharSequence("savedValue",save);
        String a = save.toString();
        global.i = Integer.parseInt(a);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state from savedInstanceState
        CharSequence save = savedInstanceState.getCharSequence("savedValue");
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(save);
    }
    public void action(View view)
    {
        global.i++;
        display(global.i);
        changeColor();
        global.red  = global.red + 25;
        global.blue = global.blue +30;
        global.green = global.green + 40;
        if(global.red > 255){
            global.red = 90;
        }
        if(global.green > 255){
            global.green = 40;
        }
        if(global.blue > 255){
            global.blue = 10;
        }
    }
    public void reset(View view)
    {
        global.i=0;
        display(global.i);
        global.red=-128;
        global.blue=-128;
        global.green=-128;
        changeColor();
    }
    public void display(int x)
    {
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("" + x);
    }
    public void changeColor()
    {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main_layout);
        linearLayout.setBackgroundColor(Color.rgb(global.red,global.blue,global.green));
    }
}

