package com.example.fusocial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, "ca-app-pub-8383353670808811~7169955886");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8383353670808811/8207705388");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }

    public void uniEvi(View view) {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

        } else {
            Intent intent = new Intent(getApplicationContext(), yemekList.class);
            startActivity(intent);
        }

    }









    public void itirafEt (View view)
    {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

        } else {
            Intent intent = new Intent(getApplicationContext(), itirafEt.class);
            startActivity(intent);
        }


    }

    public void devirActivity (View view)
    {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

        } else {
            Intent intent = new Intent(getApplicationContext(), devirActivity.class);
            startActivity(intent);
        }



    }



}
