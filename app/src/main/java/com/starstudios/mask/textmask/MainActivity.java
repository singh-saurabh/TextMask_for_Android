package com.starstudios.mask.textmask;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

import it.gilvegliach.android.transparenttexttextview.TransparentTextTextView;

public class MainActivity extends AppCompatActivity {

    private GyroscopeObserver gyroscopeObserver;
    private PanoramaImageView panoramaImageView;
    private TransparentTextTextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();


    }
    void setViews(){
        textView = findViewById(R.id.textView) ;
        Typeface font= Typeface.createFromAsset(getAssets(), "fonts/Raleway-ExtraBold.ttf");
        textView.setTypeface(font);

        textView2 = findViewById(R.id.textView4);
        Typeface font2= Typeface.createFromAsset(getAssets(), "fonts/Raleway-Thin.ttf");
        textView2.setTypeface(font2);

        gyroscopeObserver = new GyroscopeObserver();
        gyroscopeObserver.setMaxRotateRadian(Math.PI/2);

        panoramaImageView = findViewById(R.id.panorama_image_view);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);

    }


    @Override
    protected void onResume() {
        super.onResume();
        gyroscopeObserver.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gyroscopeObserver.unregister();
    }
}
