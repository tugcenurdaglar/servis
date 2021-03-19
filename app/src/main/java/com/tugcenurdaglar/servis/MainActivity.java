package com.tugcenurdaglar.servis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    startService(new Intent(MainActivity.this, MyServis.class));
                    //MyServis deki onCreate metodunu çalıştırır

                }else {
                    stopService(new Intent(MainActivity.this, MyServis.class));
                    //MyServis deki onDestroy metodunu çalıştırır

                }

            }
        });
    }
}