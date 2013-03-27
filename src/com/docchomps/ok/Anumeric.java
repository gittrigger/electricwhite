package com.docchomps.ok;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Anumeric extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.numeric);
		ctx = this;
		Intent ix = getIntent();
		if (ix != null) {
			bbx = ix.getExtras();
			if (bbx != null) {
				n = bbx.getInt("n");
				immx = bbx.getInt("max", 100);
				immn = bbx.getInt("min", 0);

				Log.i("ok", "recovered bundle");
				// if (bbx != null && bbx.containsKey("x")) {
				// Log.i("ok", "x" + bbx.getInt("x") + "y" + bbx.getInt("y"));
				// }
			}
		}

		rxx = (TextView) findViewById(R.id.pcbga);
		hxxb = (RelativeLayout) findViewById(R.id.pca);
		hx = (RelativeLayout) findViewById(R.id.pcaa);
		sx = (ScrollView) findViewById(R.id.pcts);
		mtx = (TextView) findViewById(R.id.pcbgb);
		uxx = (TextView) findViewById(R.id.pcbgc);
		Animation ob = AnimationUtils.loadAnimation(ctx, R.anim.gho);
		hxxb.startAnimation(ob);

		{
			Bundle b8 = new Bundle();
			b8.putInt("n", n);
			Message m8 = new Message();
			m8.setData(b8);
			mxx.sendMessageDelayed(m8, 80);
		}

		hxss.sendEmptyMessageDelayed(2, 100);

	}

	TextView mtx;
	TextView rxx;
	TextView uxx;
	int n = 1;
	int immx = 1000;
	int immn = 0;
	int mwidth = 320;
	int mheight = 320;
	Handler sxx = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bl = msg.getData();
			sx.smoothScrollTo(bl.getInt("x"), bl.getInt("y"));

		}
	};

	float txs = 72f;
	Handler mxx = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bl = msg.getData();
			int nn = bl.getInt("n");

			if (nn == n) {
				rxx.setText("esc");
				uxx.setVisibility(View.INVISIBLE);
			} else {
				rxx.setText("" + n);// revert
				uxx.setVisibility(View.VISIBLE);
			}

			mtx.setGravity(Gravity.CENTER);
			mtx.setText("" + nn);
			Log.i("ok",
					"" + (mtx.getTextSize() * mtx.length()) + " "
							+ mtx.getMeasuredWidth() + " " + sx.getScrollY());
			float fg = (mtx.getTextSize() / 1.7f) * mtx.length();
			float fb = (mtx.getTextSize()) * mtx.length();

			if (fg > mtx.getMeasuredWidth() || fb > mtx.getMeasuredHeight()) {
				txs -= 3f;
				mtx.setTextSize(txs);
				{
					Bundle b8 = new Bundle();
					b8.putInt("n", nn);
					Message m8 = new Message();
					m8.setData(b8);
					mxx.sendMessageDelayed(m8, 10);
				}
			}

		}
	};

	Handler hxss = new Handler() {
		public void handleMessage(Message msg) {
			Display hd = getWindowManager().getDefaultDisplay();
			mwidth = hd.getWidth();
			mheight = hd.getHeight();
			if (mheight < hx.getMeasuredHeight()) {
				// sx.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
				bbx.putInt("y", 0);
			}

			int hrgg = (int) ((mheight / 3) * 2);
			if ((mheight - hrgg) / mheight < 0.3f) {
				hrgg = mheight;
			}
			RelativeLayout.LayoutParams hr = new RelativeLayout.LayoutParams(
					-2, hrgg);

			if (bbx != null && bbx.containsKey("x")) {
				Log.i("ok", "x" + bbx.getInt("x") + "-" + hx.getMeasuredWidth()
						+ "y" + bbx.getInt("y") + "-" + hx.getMeasuredHeight());

				// RelativeLayout.LayoutParams hg = new
				// RelativeLayout.LayoutParams(
				// -2, -2);
				int hh = bbx.getInt("y") - hx.getMeasuredHeight() / 4;
				int hw = bbx.getInt("x") - hx.getMeasuredWidth();
				// if (hh < 50) {
				hh = (mheight - hrgg) / 2;
				// }

				if (hw + hx.getMeasuredWidth() > mwidth) {
					hw = mwidth - hx.getMeasuredWidth() - 1;
				}

				hr.setMargins(hw > 0 ? hw : 0, hh > 0 ? hh : 0, 0, 0);
				hx.setLayoutParams(hr);

			} else {
				hr.setMargins(0, (mheight / 3) / 2, 0, 0);
				hx.setLayoutParams(hr);
			}

			// pcbga
			{
				Bundle h8 = new Bundle();
				h8.putInt("min", immn);
				h8.putInt("max", immx);
				h8.putInt("n", n);
				Message bm8 = new Message();
				bm8.setData(h8);
				hxssb.sendMessageDelayed(bm8, 280);
			}
			final int fim = immn;
			final int fix = immx;
			final int fn = n;
			rxx.setOnTouchListener(new OnTouchListener() {

				public boolean onTouch(View v, MotionEvent event) {
					if (event.getAction() == MotionEvent.ACTION_DOWN) {
						return true;
					} else if (event.getAction() == MotionEvent.ACTION_UP) {
						TextView uh = (TextView) v;

						if (uh.getText().toString().contentEquals("" + n)) {// revert
							{
								Bundle h8 = new Bundle();
								h8.putInt("min", fim);
								h8.putInt("max", fix);
								h8.putInt("n", fn);
								Message bm8 = new Message();
								bm8.setData(h8);
								hxssb.sendMessageDelayed(bm8, 80);
							}

							{
								Bundle b8 = new Bundle();
								b8.putInt("n", fn);
								Message m8 = new Message();
								m8.setData(b8);
								mxx.sendMessageDelayed(m8, 10);
							}
						} else {
							fxx.sendEmptyMessageDelayed(2, 10);
						}
						return true;
					}
					return false;
				}
			});
		}
	};

	Handler fxx = new Handler() {
		public void handleMessage(Message msg) {
			finish();
		}
	};

	Handler hxssb = new Handler() {
		public void handleMessage(Message msg) {

			Bundle bl = msg.getData();
			final int immx = bl.getInt("max");
			final int immn = bl.getInt("min");
			final int nn = bl.getInt("n");
			// int hu8 = sx.getHeight();
			int hdbb = immx - immn;
			int hxx = 10;
			hxx = hdbb / 10;
			if (hdbb < 10) {
				hxx = 1;
			}
			final int fhxx = hxx;
			{
				LinearLayout gl = (LinearLayout) sx.getChildAt(0);
				gl.removeAllViews();
				int hid = (int) SystemClock.uptimeMillis();
				// TextView ui = null;

				int cv = 1;
				for (int i = immn; i < hdbb + immn; i += hxx) {
					LinearLayout.LayoutParams up = new LinearLayout.LayoutParams(
							-1, 88);
					up.setMargins(0, 0, 0, 10);

					TextView ui = new TextView(ctx);
					final int fn = i;

					ui.setLayoutParams(up);
					while (findViewById(++hid) != null) {
					}
					ui.setId(hid);

					if (hxx > 1) {
						int itb = ((i + hxx) - 1);
						ui.setText("" + i + "-" + itb);

						if (cv == 1) {
							cv++;
							ui.setBackgroundColor(Color.argb(200, 10, 40, 180));
						} else {
							ui.setBackgroundColor(Color.argb(180, 10, 40, 180));
							cv = 1;
						}

						if (n >= i && n < i + hxx) {
							ui.setBackgroundColor(Color.argb(180, 95, 79, 168));
						}

						// float uit = 12f;
						// if (ui != null) {
						// uit = ui.getTextSize();
						// }
						// up = new LinearLayout.LayoutParams(-1,
						// (int) ((immx - immn) * (uit + 1)));
						// ui.setLayoutParams(up);

						ui.setOnTouchListener(new OnTouchListener() {
							long cb = 1;

							public boolean onTouch(View arg0, MotionEvent arg1) {

								if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
									return true;
								} else if (arg1.getAction() == MotionEvent.ACTION_UP) {
									{
										Bundle b8 = new Bundle();
										b8.putInt("n", fn);// + arg1.getY()));
										Log.i("ok", "at " + arg1.getY() + " "
												+ fn);

										Message m8 = new Message();
										m8.setData(b8);
										// mxx.sendMessageDelayed(m8, 10);
									}

									{
										Bundle h8 = new Bundle();
										h8.putInt("min", fn);
										h8.putInt("max", fn + fhxx);
										h8.putInt("n", fn);
										Message bm8 = new Message();
										bm8.setData(h8);
										hxssb.sendMessageDelayed(bm8, 10);

									}
									return true;
								} else if (arg1.getAction() == MotionEvent.ACTION_MOVE
										&& cb < SystemClock.uptimeMillis()) {
									{
										cb = SystemClock.uptimeMillis() + 180;

										Bundle b8 = new Bundle();
										b8.putInt("n",
												(int) ((fn) + arg1.getX()));
										Message m8 = new Message();
										m8.setData(b8);
										// mxx.sendMessageDelayed(m8, 10);
									}
									return true;
								}

								return false;
							}
						});

					} else {
						ui.setText("" + i);
						if (cv == 1) {
							cv++;
							// ui.setTextColor(Color.BLACK);
							ui.setBackgroundColor(Color.argb(220, 10, 60, 220));
						} else {
							// ui.setTextColor(Color.BLACK);
							ui.setBackgroundColor(Color.argb(200, 5, 30, 180));
							cv = 1;
						}

						if (i == n) {
							// ui.setTextColor(Color.WHITE);
							ui.setBackgroundColor(Color.argb(180, 95, 79, 168));
						} else if (i == nn) {
							// ui.setBackgroundColor(Color.argb(180, 25, 201,
							// 107));
						}

						ui.setTextSize(22f);
						ui.setOnTouchListener(new OnTouchListener() {
							long cb = 1;

							public boolean onTouch(View arg0, MotionEvent arg1) {

								if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
									return true;
								} else if (arg1.getAction() == MotionEvent.ACTION_UP) {
									{
										Bundle b8 = new Bundle();
										b8.putInt("n", fn);// + arg1.getY()));
										Log.i("ok", "at " + arg1.getY() + " "
												+ fn);

										Message m8 = new Message();
										m8.setData(b8);
										mxx.sendMessageDelayed(m8, 10);
									}
									return true;
								}
								return false;
							}
						});
					}

					ui.setTextSize(16);
					ui.setGravity(Gravity.RIGHT);
					ui.setPadding(10, 10, 10, 10);
					gl.addView(ui);

				}

				if (nn == n) {
					Bundle b8 = new Bundle();
					b8.putInt("y", (int) ((nn / hxx) * 88) + (nn / hxx) * 10);
					b8.putInt("x", 0);
					Message m8 = new Message();
					m8.setData(b8);
					sxx.sendMessageDelayed(m8, 180);
				} else {
					Bundle b8 = new Bundle();
					b8.putInt("y", 0);// (int) ((nn / hxx) * 88) + (nn / hxx) *
										// 10);
					b8.putInt("x", 0);
					Message m8 = new Message();
					m8.setData(b8);
					sxx.sendMessageDelayed(m8, 180);
				}

			}

		}
	};
	RelativeLayout hxxb;
	ScrollView sx;
	RelativeLayout hx;
	Bundle bbx;
	Context ctx;
}
