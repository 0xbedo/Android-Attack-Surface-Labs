package com.bedo.poc_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_activity).setOnClickListener(v->startActivity(new Intent(this, Activity_Labs.class)));
        findViewById(R.id.btn_activity_result).setOnClickListener(v->startActivity(new Intent(this, ActivityResult_Hextree_Labs.class)));
        findViewById(R.id.btn_implicit_intent).setOnClickListener(v->startActivity(new Intent(this, Implicit_Intent_Labs.class)));
        findViewById(R.id.btn_deeplink).setOnClickListener(v->startActivity(new Intent(this, Deeplink_Labs.class)));
        findViewById(R.id.btn_broadcast).setOnClickListener(v->startActivity(new Intent(this, Broadcast_Labs.class)));
        findViewById(R.id.btn_pending_intent).setOnClickListener(v->startActivity(new Intent(this, Pending_Intent_Labs.class)));
        findViewById(R.id.btn_service).setOnClickListener(v->startActivity(new Intent(this, Service_Labs.class)));
        findViewById(R.id.btn_content_provider).setOnClickListener(v->startActivity(new Intent(this, Content_Provider_Labs.class)));
        findViewById(R.id.btn_file_provider).setOnClickListener(v->startActivity(new Intent(this, File_Provider_Labs.class)));
        findViewById(R.id.btn_webview).setOnClickListener(v->startActivity(new Intent(this, Webview_Labs.class)));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}