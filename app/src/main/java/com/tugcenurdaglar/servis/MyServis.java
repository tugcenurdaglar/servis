package com.tugcenurdaglar.servis;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyServis extends Service {
    /*bu classı manifests dosyasında belirt
    * bu şekilde:
    * </activity> bundan sonra

        <service android:name=".MyServis"/> bunu yaz*/

    private Handler h;

    //implements methods a tıklayınca onBind methodu oluştu
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        h = new Handler();

        h.postDelayed(runnable,5000); //gecikme miktarı 5 sn
        Toast.makeText(this,"Servis çalışmaya başladı", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Servis durdu", Toast.LENGTH_SHORT).show();
        h.removeCallbacks(runnable);
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Toast.makeText(MyServis.this,"Servis çalışmaya devam ediyor..", Toast.LENGTH_SHORT).show();

            MyServis.this.h.postDelayed(runnable,5000);
        }
    };
}
