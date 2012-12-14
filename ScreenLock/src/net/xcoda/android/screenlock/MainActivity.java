package net.xcoda.android.screenlock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

	DevicePolicyManager deviceMgr;
	ComponentName comp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (BuildConfig.DEBUG) {
			Log.d("ScreenLock", "MainActivity oncreate.");
		}
		deviceMgr = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		comp = new ComponentName(this, ScreenLockDeviceAdminReceiver.class);
		if (!deviceMgr.isAdminActive(comp)) {
			Log.d("ScreenLock", "Main :admin is false");
			Intent intent = new Intent(
					DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, comp);
			intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
					getString(R.string.devicePolicyManagerMessage));

			startActivityForResult(intent, 0);
		} else {
			Log.d("ScreenLock", "Main : admin is true");
			deviceMgr.lockNow();
			finish();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		if (resultCode == RESULT_OK) {
			deviceMgr.lockNow();
		} else {
			Toast.makeText(this, R.string.failActivation, Toast.LENGTH_LONG)
				 .show();
		}
		finish();
	}

}
