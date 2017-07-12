package com.example.nluria.irememberyou;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static Button add_single;
    Typeface buttonFont;

//////
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFont= Typeface.createFromAsset(getAssets(), "tamir.ttf");

        addSingleClickListener();
    }


    public void addSingleClickListener()
    {
        add_single = (Button)findViewById(R.id.add_single);
       // add_single.setTypeface(buttonFont);
        add_single.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Toast.makeText(MainActivity.this,"aaaaaaaaaaaaaa", Toast.LENGTH_SHORT ).show();

/*
                        Intent intent = new Intent("com.example.nluria.irememberyou.AddSingle");
                        startActivity(intent);
*/

                    }
                }
        );
    }
}
