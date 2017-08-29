package com.example.lijix.myringtitle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RingTitle ringTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ringTitle = (RingTitle) findViewById(R.id.myRingTitle);
        ringTitle.setBgColor_ringTitle(Color.GREEN);
        ringTitle.setRadius_ringTitle(20);
        ringTitle.setTextSize_ringTitle(30);
        ringTitle.setText_ringTitle("3");
    }
}
