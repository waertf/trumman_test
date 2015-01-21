package com.example.android.BluetoothChat;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by wavegisAAA on 1/21/2015.
 */
public class SendThread extends Thread {
    BluetoothChatService myobject;
    Context myContext;
    SendThread(BluetoothChatService object, Context mContext){
        myobject=object;
        myContext=mContext;
    }
    public void run() {
        Random speedR = new Random();
        Random batteryR = new Random();
        Random totalDistnanceR = new Random();
        while (true)
        {
            final String message = speedR.nextInt(1000)+","+batteryR.nextInt(101)+","+totalDistnanceR.nextInt(1000)+";";
            myobject.write(message.getBytes());
            Handler handler = new Handler(Looper.getMainLooper());
            boolean post = handler.post(new Runnable() {
                public void run() {
                    // UI code goes here
                    Toast.makeText(myContext, message, Toast.LENGTH_SHORT).show();
                }
            });
            //Toast.makeText(myContext,message,Toast.LENGTH_SHORT).show();
            Log.d(this.toString(),message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
