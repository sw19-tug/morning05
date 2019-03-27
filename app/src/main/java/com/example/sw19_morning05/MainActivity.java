package com.example.sw19_morning05;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Launches an extra activity
        Button touchTheBlockActivityBtn = (Button)findViewById(R.id.secondActivityBtn);
        touchTheBlockActivityBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), TTBActivity.class);
                startActivity(startIntent);
            }
        });

        Button googleBtn = (Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String google_adress = "http://www.google.com";
                Uri webadress = Uri.parse(google_adress);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webadress);
                if (gotoGoogle.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}
