package com.ahmedkhaled.barcodereader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    String result;
    String scanFormat;
    TextView Result,ScanFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Result= (TextView) findViewById(R.id.Result);
        ScanFormat= (TextView) findViewById(R.id.ScanFormat);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult intentResult =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(intentResult != null){
             result =intentResult.getContents();
             scanFormat = intentResult.getFormatName();
            if (result!=null) {
//
                handleResult();
            }else {
                Toast.makeText(getApplicationContext(),"scanning was canceled ",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getApplicationContext(),"there is problem with scanning ",Toast.LENGTH_SHORT).show();
        }

    }

    public void scan_click(View view) {
        IntentIntegrator intentIntegrator =new IntentIntegrator(this);
        intentIntegrator.initiateScan();
    }

    void handleResult(){
        if (Patterns.WEB_URL.matcher(result).matches()){     //check if result is a URL
            Result.setAutoLinkMask(Linkify.ALL);            //make URL Clickable
            Result.setText(result);
            ScanFormat.setText(scanFormat);
        }else {
            Result.setText(result);
            ScanFormat.setText(scanFormat);
        }
    }



}
