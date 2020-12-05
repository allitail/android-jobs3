package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtclock;

    private static Handler cHandler;
    int imgCount = 0;
    Bitmap bmImg1 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/d.jpg");
    Bitmap bmImg2 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/e.jpg");
    Bitmap bmImg3 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/f.jpg");
    Bitmap bmImg4 = BitmapFactory.decodeFile("/storage/emulated/0/a/IMG/g.jpg");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        txtclock = findViewById(R.id.clock);


        cHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.d("",""+msg.what);
                Calendar cal = Calendar.getInstance();

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                String srTime = sdf.format(cal.getTime());

                txtclock = findViewById(R.id.clock);
                txtclock.setText(srTime);
                // TODO: 2020-10-07
                changeImg();

            }
        };

        class NewRunnable implements Runnable {
            @Override
//            Calendar cal = Calendar.getInstance();
//
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

            public void run() {
                while (true) {
//                    String srTime = sdf.format(cal.getTime());
//                    txtclock.setText(srTime);

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                    cHandler.sendEmptyMessage(0);

                }
            }
        }

        NewRunnable nr = new NewRunnable();
        Thread t = new Thread(nr);
        t.start();
    }

    void changeImg(){
        imgCount++;
        switch (imgCount){
            case 0:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg1);
                break;
            case 1:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg2);
                break;
            case 2:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg3);
                break;
            case 3:
                ((ImageView)findViewById(R.id.img)).setImageBitmap(bmImg4);
                imgCount = 0;
                break;
        }
    }
}