package net.xcoda.android.screenlock;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ScreenLockDeviceAdminReceiver extends DeviceAdminReceiver {
	@Override
	public void onEnabled(Context context, Intent intent) {
		super.onEnabled(context, intent);
		Toast.makeText(context, R.string.deviceAdminEnabled, Toast.LENGTH_LONG).show();

	}
	
	@Override
	public void onDisabled(Context context, Intent intent) {
		super.onDisabled(context, intent);
		Toast.makeText(context, R.string.disableDeviceAdmin, Toast.LENGTH_LONG).show();
		Uri uri = Uri.fromParts("package", "net.xcoda.android.screenlock", null);
		Intent i = new Intent(Intent.ACTION_DELETE,uri );
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}
	
}
