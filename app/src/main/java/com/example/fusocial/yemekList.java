package com.example.fusocial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;





public class yemekList extends AppCompatActivity {




    private TextView yemekList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_list);
        yemekList = (TextView)findViewById(R.id.yemekList);



        new RequestAsync().execute();




    }

    public class RequestAsync extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... strings) {
            try {


                // POST Request
                JSONObject postDataParams = new JSONObject();


                return RequestHandler.sendPost("http://yemek.muraat.com/yemeklist.php",postDataParams);
            }
            catch(Exception e){
                return new String("İnternet bağlantın yok \n :(");
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if(s!=null){

                yemekList.setText(s);
            }
        }


    }


}
