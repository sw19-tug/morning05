package com.example.sw19_morning05;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnClickEvent = (Button) findViewById(R.id.bt_switchLanguage);
        btnClickEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switchLanguage();
            }
        });
    }

    public void switchLanguage() {
        Configuration config = new Configuration();

        String lang = Locale.getDefault().getDisplayLanguage();
        Locale locale;

        if (lang.equals("English")) {
            locale = new Locale("de");
        } else {
            locale = new Locale("en");
        }

        Locale.setDefault(locale);
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        MainActivity.this.recreate();
    }
}
