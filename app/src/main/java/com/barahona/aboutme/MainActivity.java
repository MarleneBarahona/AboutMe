package com.barahona.aboutme;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri imageUri = Uri.parse("android.resource://com.barahona.aboutme/drawable/"+R.drawable.fotocircular);

                Intent sendIntent1 = new Intent();
                sendIntent1.setAction(Intent.ACTION_SEND);
                sendIntent1.setType("image/*");
                sendIntent1.putExtra(Intent.EXTRA_STREAM,imageUri);
                sendIntent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                sendIntent1.putExtra(Intent.EXTRA_TEXT,((TextView)findViewById(R.id.name)).getText().toString() +"\n"+ ((TextView)findViewById(R.id.carrera)).getText().toString()+"\n"+ ((TextView)findViewById(R.id.facebook)).getText().toString()
                        +"\n"+ ((TextView)findViewById(R.id.github)).getText().toString()+"\n"+ ((TextView)findViewById(R.id.wa)).getText().toString()+"\n"+ ((TextView)findViewById(R.id.correo)).getText().toString());

                if(sendIntent1.resolveActivity(getPackageManager()) != null){
                    startActivity(sendIntent1);
                }
            }
        });
    }

}
