package com.example.sw19_morning05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class TouchTheBlockActivity2 extends AppCompatActivity {

    @Override
    protected void  onCreate(Bundle saveInstantState){
        super.onCreate(saveInstantState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ttb);
    }
}
