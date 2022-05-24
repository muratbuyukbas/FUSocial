package com.example.fusocial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class devirActivity extends AppCompatActivity {

    WebView devret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devir);

        devret = (WebView) findViewById(R.id.devret);
        devret.loadUrl("http://devir.yemek.muraat.com");
        devret.setWebViewClient(new devirActivity.MuratWebClientD());

        WebSettings webSettings = devret.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    private class MuratWebClientD extends WebViewClient {


        public void onReceivedError(WebView devir,int errorCode,String description,String failingUrl){
            try {
                devir.stopLoading();
            } catch (Exception e) {
            }

            if (devir.canGoBack()) {
                devir.goBack();
            }

            devir.loadUrl("about:blank");
            AlertDialog alertDialog = new AlertDialog.Builder(devirActivity.this).create();
            alertDialog.setTitle("Biz öğrenciler hep mi gariban? :(");
            alertDialog.setMessage("İnternet bağlantın yok. Bağlantını kontrol edip tekrar deneyebilirsin.");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Tekrar Dene", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    startActivity(getIntent());
                }
            });

            alertDialog.show();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    public void ilanYayin (View view) {

        Intent intent = new Intent(getApplicationContext(), ilanYayin.class);
        startActivity(intent);

    }




}
