package com.example.fusocial;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class itirafEt extends Activity {

    WebView itiraf;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itiraf_et);

        itiraf = (WebView) findViewById(R.id.itiraf);
        itiraf.loadUrl("http://itiraf.yemek.muraat.com");
        itiraf.setWebViewClient(new MuratWebClient());





    }

        private class MuratWebClient extends WebViewClient {


            public void onReceivedError(WebView itiraf,int errorCode,String description,String failingUrl){
                try {
                    itiraf.stopLoading();
                } catch (Exception e) {
                }

                if (itiraf.canGoBack()) {
                    itiraf.goBack();
                }

                itiraf.loadUrl("about:blank");
                AlertDialog alertDialog = new AlertDialog.Builder(itirafEt.this).create();
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





    }

