package net.xcoda.android.screenlock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class VolumeReceiver extends BroadcastReceiver {

	 @Override
     public void onReceive(Context context, Intent intent) {
             if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            	 Log.d("lock", "Media Button clicked");
             }
     }

}
