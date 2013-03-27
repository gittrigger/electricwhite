package com.docchomps.ok;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class Ashow extends Activity {

	Bundle bdx;

	public void onCreate(Bundle hbb) {
		super.onCreate(hbb);
		ctx = this;

		Intent idx = getIntent();
		if (idx != null) {
			bdx = idx.getExtras();
			if (bdx != null) {
				Log.i("ok", "message bundle received");
				Object[] bo = (Object[]) bdx.keySet().toArray();
				for (int i = 0; i < bo.length; i++) {
					if (bo[i] != null && bo[i].getClass() == String.class) {
						String k = (String) bo[i];
						// if (k != null && bdx.containsKey(k)) {
						// String kx = bdx.getString(k);
						// if (kx != null) {
						Log.i("ok", "" + i + " " + k + " ");// + " " +
															// kx.length());

						// }
						// }
					}
				}
			}

		}
		s4.sendEmptyMessageDelayed(2, 20);
	}

	Context ctx;
	Handler s4 = new Handler() {
		public void handleMessage(Message msg) {
			s5.sendEmptyMessageDelayed(2, 20);
			Log.i("ok", "message processing");
			Toast.makeText(ctx, "ok", 1880).show();
		}
	};
	Handler s5 = new Handler() {
		public void handleMessage(Message msg) {
			finish();
		}
	};

	Handler t4 = new Handler() {
		public void handleMessage(Message msg) {
		}
	};
	Handler t5 = new Handler() {
		public void handleMessage(Message msg) {
		}
	};

}
