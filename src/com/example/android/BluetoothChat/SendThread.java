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
    BluetoothChat myobject;
    Context myContext;
    SendThread(BluetoothChat object, Context mContext){
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
            try {
                //myobject.write(message.getBytes());
                myobject.sendMessage(message);
            }
            catch (Exception ex)
            {
                Log.e(this.toString(),ex.toString());
            }

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
