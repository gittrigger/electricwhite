package com.docchomps.ok;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.docchomps.ok.R;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.provider.Contacts.People;
import android.provider.ContactsContract;

public class OKPeople extends ListActivity {

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Bundle fb = new Bundle();
		fb.putInt("v", position);
		fb.putInt("id", (int) id);
		Message hfb = new Message();
		hfb.setData(fb);
		columnv.sendMessageDelayed(hfb, 20);

	}

	@Override
	protected void onRestoreInstanceState(Bundle state) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(state);
	}

	Context ctx;
	int hid = -1;
	Uri um;
	Bundle ck;
	String[][] v;
	String col;
	String atitle = "";

	@Override
	protected void onCreate(Bundle sib2) {
		// TODO Auto-generated method stub
		super.onCreate(sib2);
		// setContentView(R.layout.main);

		ctx = getApplicationContext();
		hid = (int) System.currentTimeMillis();
		v = new String[100][0];
		Intent xi = getIntent();
		if (xi != null) {
			Bundle sib = xi.getExtras();

			if (sib != null) {
				if (sib.containsKey("title")) {
					atitle = sib.getString("title");
				}
				if (sib.containsKey("cu")) {
					um = Uri.parse(sib.getString("cu"));
				}

				if (sib.containsKey("cl")) {
					col = sib.getString("cl");
				}
				ck = new Bundle(sib);
				for (int i = 1; i < 100; i++) {
					if (ck.containsKey("c" + i)) {
						v[i] = ck.getString("c" + i).split("\n");
						// } else if (ck.containsKey("i" + i)) {
						// v[i] = ck.getString("i" + i).split("\n");
					} else {
						break;
					}
				}
			}
		}

		if (um == null) {
			um = ContactsContract.Data.CONTENT_URI;
			ck = new Bundle();
		}

		s01.sendEmptyMessageDelayed(2, 2);
	}

	int mxw = 75;
	int mxh = 88;
	int mwidth = 320;
	int mheight = 320;
	Handler s01 = new Handler() {
		public void handleMessage(Message msg) {

			Log.i("s01", "w/" + um.toString());

			Display sd = getWindowManager().getDefaultDisplay();
			mwidth = sd.getWidth();
			mheight = sd.getHeight();

			if (mwidth > mheight) {
				mxw = 120;
			} else {
				mxw = 88;
			}

			if (mheight / 88 > 5) {
				mxh = mheight / ((mheight / 88) - 1);
			}
			reshow.sendEmptyMessageDelayed(2, 2);
			column.sendEmptyMessageDelayed(3, 50);

			// column.removeMessages(2);
			// column.sendEmptyMessageDelayed(2, 1820);

		}
	};

	Handler reshow = new Handler() {
		Cursor lCursor;

		public void handleMessage(Message msg) {
			// Log.i(G, "vstart good xxx");
			Bundle bdl = msg.getData();

			// "strftime('%Y/%m/%d %H:%M',published) as published",
			String[] columns;
			String[] from;
			int sdkVersion = Integer.parseInt(Build.VERSION.SDK);
			String where = "1=1";
			String by = "updated desc";
			int[] to = new int[] { R.id.fielda, R.id.fieldb, R.id.fieldbx,
					R.id.fieldc, R.id.switcha, R.id.switchb, R.id.fieldid };

			if (sdkVersion < 5) {
				columns = new String[] { People._ID, People.NAME,
						People.LAST_TIME_CONTACTED, People.PRIMARY_EMAIL_ID,
						People.CONTENT_ITEM_TYPE };
				from = new String[] { People.CONTENT_ITEM_TYPE,
						People.DISPLAY_NAME, People.NAME,
						People.LAST_TIME_CONTACTED, People.PRIMARY_EMAIL_ID,
						People._ID };

			} else if (um.equals(ContactsContract.Data.CONTENT_URI)) {
				to = new int[] { R.id.fielda, R.id.fieldc };

				columns = new String[] { "_id", "display_name",// ContactsContract.Data.DISPLAY_NAME,
						"data1" };

				from = new String[] { "display_name", // ContactsContract.Data.DISPLAY_NAME,
						// ContactsContract.Data.DISPLAY_NAME,
						"data1"// ContactsContract.Data.DATA1,
				// "is_primary",//ContactsContract.Data.IS_PRIMARY,
				};

				where = ContactsContract.Data.MIMETYPE
						+ " = '"
						+ ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE
						+ "') GROUP BY (data1";
				// (distinct('data1')";
				by = "display_name ASC, is_primary DESC, data1 ASC";
			} else if (um.equals(Uri
					.parse("content://com.docchomps.ok/checkin"))) {
				to = new int[] { R.id.fielda, R.id.fieldb, R.id.fieldbx,
						R.id.fieldc, R.id.fieldid };

				columns = new String[] { "_id", "atitle", "anext", "atill",
						"rotation", "created", "updated" };
				from = new String[] { "atitle", "anext", "anext", "atill",
						"_id" };

			} else {

				to = new int[] { R.id.fieldid, R.id.fielda, R.id.fieldb,
						R.id.fieldbx, R.id.fieldc };

				// columns = new String[] { "_id", "atitle", "status",
				// "date(created) as cdate", "time(created) as tdate",
				// "created", "updated" };

				columns = new String(
						"_id,atitle,status,date(created) as cdate,time(created) as tdate,created,updated,"
								+ col).split(",");
				from = new String("_id," + col).split(",");

			}

			// android.provider.Contacts.CONTENT_URI
			// Uri.parse("content://com.android.contacts")
			lCursor = SqliteWrapper.query(ctx, getContentResolver(), um,
					columns, where, null, by);

			startManagingCursor(lCursor);

			// mHu.setVisibility(View.INVISIBLE);

			SimpleCursorAdapter entries = new SimpleCursorAdapter(ctx,
					R.layout.listrow, lCursor, from, to);

			getListView().setOnScrollListener(cssc);
			getListView().setOnHierarchyChangeListener(cssh);
			getListView().setDividerHeight(4);
			listr = true;

			if (atitle.length() > 0) {
				RelativeLayout vh = new RelativeLayout(ctx);
				while (findViewById(++hid) != null) {
				}
				vh.setId(hid);
				vh.setLayoutParams(new ListView.LayoutParams(-1, -2));
				vh.setBackgroundColor(Color.argb(145, 50, 50, 50));
				getListView().addHeaderView(vh, null, false);

				{
					TextView t1 = new TextView(ctx);
					RelativeLayout.LayoutParams t1r = new RelativeLayout.LayoutParams(
							-1, mxh);
					t1.setLayoutParams(t1r);
					while (findViewById(++hid) != null) {
					}
					t1.setId(hid);
					t1.setTextSize((float) 26);

					// t1.setGravity(Gravity.CENTER_VERTICAL);
					t1.setTextColor(Color.argb(255, 8, 180, 255));
					// t1.setGravity(Gravity.CENTER);
					t1.setPadding(1, 1, 1, 1);
					t1.setText(atitle);
					vh.addView(t1);
				}
			}

			setListAdapter(entries);

			// column.removeMessages(2);
			// column.sendEmptyMessageDelayed(2, 10);

			// FrameLayout.LayoutParams hn = (FrameLayout.LayoutParams)
			// getListView()
			// .getLayoutParams();
			// hn.setMargins(88, 88, (int) (mWidth / 3 > 240 ? 240 : mWidth /
			// 3),
			// (int) ((mHeight - 100) / 3));
			// getListView().setLayoutParams(hn);

			// getListView().setSelector(R.drawable.c3);
			// getListView().setBackgroundColor(Color.argb(120, 0, 102, 255));
			// getListView().requestFocusFromTouch();
			// getListView().setBackgroundColor(Color.argb(0, 0, 64, 171));
			// mHu.setBackgroundColor(Color.argb(0, 0, 64, 171));

			// registerForContextMenu(getListView());

		}
	};

	OnHierarchyChangeListener cssh = new OnHierarchyChangeListener() {

		public void onChildViewAdded(View a, View b) {

			// RelativeLayout ra = (RelativeLayout) b;
			// LinearLayout labb = (LinearLayout)
			// ra.getChildAt(0);
			// TextView fc = (TextView) labb.getChildAt(2);
			// if (fc != null) {
			// while (findViewById(++hid) != null) {
			// }
			// fc.setId(hid);
			// }
			// while (findViewById(++hid) != null) {
			// }
			// ra.setId(hid);
			// while (findViewById(++hid) != null) {
			// }
			// labb.setId(hid);

			column.removeMessages(2);
			column.sendEmptyMessageDelayed(2, 80);
			// columnx.removeMessages(2);
			// columnx.sendEmptyMessageDelayed(2, 20);

		}

		public void onChildViewRemoved(View a, View b) {
			column.removeMessages(2);
			column.sendEmptyMessageDelayed(2, 80);

			// RelativeLayout ra = (RelativeLayout) b;
			// LinearLayout labb = (LinearLayout)
			// ra.getChildAt(0);
			// TextView fc = (TextView) labb.getChildAt(2);
			// if (fc != null) {
			// fc.setBackgroundColor(Color.argb(0, 20, 0, 240));
			// }

		}
	};

	OnScrollListener cssc = new OnScrollListener() {
		long cm = 1;

		public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			if (cm < SystemClock.uptimeMillis()) {
				cm = SystemClock.uptimeMillis() + 1880;
				// column.removeMessages(2);
				// columnb.removeMessages(2);
				// column.sendEmptyMessageDelayed(2, 220);

			}

		}

		public void onScrollStateChanged(AbsListView arg0, int arg1) {
			// TODO Auto-generated method stub
			if (arg1 == SCROLL_STATE_IDLE
					|| arg1 == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
				cm = 1;
				// columnx.removeMessages(2);
				// columnb.removeMessages(2);
				column.removeMessages(2);
				column.sendEmptyMessageDelayed(2, 20);
			} else if (arg1 == SCROLL_STATE_FLING) {
				// RelativeLayout ra = (RelativeLayout) b;
				// LinearLayout labb = (LinearLayout) ra.getChildAt(1);
				// TextView fc;
				// for (int ix = 0; ix < labb.getChildCount(); ix++) {
				// fc = (TextView) labb.getChildAt(ix);
				// if (fc != null) {
				// fc.setBackgroundColor(Color.argb(0, 20, 0, 240));
				// }
				// }
				columnx.removeMessages(2);
				columnx.sendEmptyMessageDelayed(2, 20);

			}
		}

	};

	Handler columnx = new Handler() {
		public void handleMessage(Message msg) {
			columnx.removeMessages(2);

			for (int i = 0; i < getListView().getChildCount(); i++) {
				RelativeLayout ra = (RelativeLayout) getListView()
						.getChildAt(i);

				if (ra != null) {
					ra.setBackgroundColor(Color.argb(255, 99, 99, 99));
					// LinearLayout labb = (LinearLayout) ra.getChildAt(0);
					LinearLayout la1a = (LinearLayout) ra.getChildAt(1);
					LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);
					LinearLayout la2 = (LinearLayout) la1a.getChildAt(1);

					for (int fx = 0; fx < la2.getChildCount(); fx++) {
						ImageView fc1 = (ImageView) la2.getChildAt(fx);
						if (fc1 != null) {
							// fc1.setText("");
							fc1.setVisibility(View.INVISIBLE);
							fc1.setBackgroundColor(Color.argb(150, 190, 190,
									190));
						}
					}

					for (int fx = 0; fx < la1.getChildCount(); fx++) {
						TextView fc1 = (TextView) la1.getChildAt(fx);
						if (fc1 != null) {
							// fc1.setText("");
							fc1.setVisibility(View.INVISIBLE);
							fc1.setBackgroundColor(Color.argb(150, 190, 190,
									190));
						}
					}
				}

			}

		}
	};

	Handler columna = new Handler() {
		public void handleMessage(Message msg) {

			// columnb.removeMessages(2);
			// columnb.sendEmptyMessageDelayed(2, 100);
		}
	};
	boolean listr = false;
	Handler column = new Handler() {
		long xh = 0;

		public void handleMessage(Message msg) {

			if (!listr) {
				Log.i("ok", "column rest " + msg.what);
				column.sendEmptyMessageDelayed(msg.what, 1000 / 4);
				return;
			}
			column.removeMessages(msg.what);
			if (xh < SystemClock.uptimeMillis() && msg.what == 2) {
				xh = SystemClock.uptimeMillis() + 880;
			} else {
				Log.i("ok", "column rest b " + msg.what);
				column.sendEmptyMessageDelayed(msg.what, 1000 / 4);
				return;
			}

			column.removeMessages(3);
			Log.i("ok", "column " + getListView().getFirstVisiblePosition()
					+ " to " + getListView().getLastVisiblePosition());
			// for (int i = getListView().getFirstVisiblePosition(); i <=
			// getListView()
			// .getLastVisiblePosition(); i++) {
			for (int i = 0; i < getListView().getChildCount(); i++) {
				RelativeLayout ra = (RelativeLayout) getListView()
						.getChildAt(i);

				if (ra != null) {
					if (ra.getChildCount() < 2) {// header entry probably
						continue;
					}

					while (findViewById(++hid) != null) {
					}
					ra.setId(hid);
					ra.setBackgroundColor(Color.argb(255, 50, 50, 50));
					Bundle br = new Bundle();
					br.putInt("id", hid);
					br.putInt("v", i);
					Message hm = new Message();
					hm.setData(br);
					final Bundle fb = new Bundle(br);

					ra.setOnTouchListener(new OnTouchListener() {
						long ca = 1;
						float dif = 0f;
						float dx = 0f;

						public boolean onTouch(View a, MotionEvent ji) {
							// TODO Auto-generated method stub

							if (ji.getAction() == MotionEvent.ACTION_DOWN) {
								dif = ji.getX();
								ca = SystemClock.uptimeMillis() + 20;

								Message hfb = new Message();
								hfb.setData(fb);
								columnv.sendMessageDelayed(hfb, 20);

								// Log.i("wa", "" + (dif));
								// a.requestFocusFromTouch();
								return true;
							}
							if (ji.getAction() == MotionEvent.ACTION_MOVE) {

								if (ca < SystemClock.uptimeMillis()) {

									ca = SystemClock.uptimeMillis() + 20;
									dx = ji.getX();
									// Log.i("wash", "" + (dif - dx));

									if (dx > dif) {
										if (dx - dif > 88) {
											tg.sendEmptyMessageDelayed(2, 200);
											// return true;
										}
									}
									return true;
								}
							}

							return false;

						}
					});

					LinearLayout la = (LinearLayout) ra.getChildAt(0);

					while (findViewById(++hid) != null) {
					}
					la.setId(hid);

					TextView fc3 = (TextView) la.getChildAt(0);
					if (fc3 != null) {
						while (findViewById(++hid) != null) {
						}
						// fc3.setId(hid);
					}

					TextView fc = (TextView) la.getChildAt(2);
					if (fc != null) {
						while (findViewById(++hid) != null) {
						}
						// fc.setId(hid);
					}
					LinearLayout la1a = (LinearLayout) ra.getChildAt(1);
					while (findViewById(++hid) != null) {
					}
					la1a.setId(hid);

					LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);
					while (findViewById(++hid) != null) {
					}
					la1.setId(hid);

					LinearLayout la2 = (LinearLayout) la1a.getChildAt(1);
					while (findViewById(++hid) != null) {
					}
					la2.setId(hid);

					// LinearLayout la1 = (LinearLayout) ra.getChildAt(1);
					while (findViewById(++hid) != null) {
					}
					la1.setId(hid);

					TextView fc1 = (TextView) la1.getChildAt(1);
					if (fc1 != null) {
						while (findViewById(++hid) != null) {
						}
						fc1.setBackgroundColor(Color.argb(0, 0, 0, 0));
						fc1.setId(hid);
						fc1.setText("");
						fc1.setVisibility(View.VISIBLE);
					}

					TextView fc4 = (TextView) la1.getChildAt(0);
					if (fc4 != null) {
						while (findViewById(++hid) != null) {
						}
						fc4.setBackgroundColor(Color.argb(0, 0, 0, 0));
						fc4.setId(hid);
						fc4.setText("");
						fc4.setVisibility(View.VISIBLE);
					}

					ImageView fi41 = (ImageView) la2.getChildAt(1);
					if (fi41 != null) {
						while (findViewById(++hid) != null) {
						}
						fi41.setId(hid);
						fi41.setVisibility(View.INVISIBLE);
					}
					ImageView fi4 = (ImageView) la2.getChildAt(0);
					if (fi4 != null) {
						while (findViewById(++hid) != null) {
						}
						fi4.setId(hid);
						fi4.setVisibility(View.INVISIBLE);
					}

					columnv.sendMessageDelayed(hm, 20 + 50 * i);

				}

			}

			column.removeMessages(2);
			column.sendEmptyMessageDelayed(2, 20000);

		}
	};

	Handler tg = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "exit");
			finish();
		}
	};

	Handler columnv = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bd = msg.getData();
			int id = bd.getInt("id");
			int i = bd.getInt("v");
			RelativeLayout ra = (RelativeLayout) getListView().getChildAt(i);

			if (ra != null) {

				// ra.setId(id);
				ra.setBackgroundColor(Color.argb(55, 20, 125, 140));

				Bundle br = new Bundle();
				br.putInt("id", id);
				br.putInt("v", i);
				Message hm = new Message();
				hm.setData(br);
				columnr.sendMessageDelayed(hm, 20);

			}

		}
	};

	Handler columnr = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bd = msg.getData();
			int id = bd.getInt("id");
			int i = bd.getInt("v");

			RelativeLayout ra = (RelativeLayout) getListView().getChildAt(i);

			// RelativeLayout ra = (RelativeLayout) findViewById(id);
			if (ra != null) {

				ra.setBackgroundColor(Color.argb(70, 120, 0, 140));
				LinearLayout la = (LinearLayout) ra.getChildAt(0);
				TextView fc3 = (TextView) la.getChildAt(0);
				TextView fc = (TextView) la.getChildAt(2);
				LinearLayout la1a = (LinearLayout) ra.getChildAt(1);
				LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

				// LinearLayout la1 = (LinearLayout) ra.getChildAt(1);
				TextView fc1 = (TextView) la1.getChildAt(1);

				if (fc != null) {
					// fc.setBackgroundColor(Color.argb(120, 120, 0, 140));
					// Log.i("row",
					// "" + i + ": " + ra.getId() + " : " + labb.getId()
					// + " : " + fc.getId() + " : " + la1.getId()
					// + " : " + fc1.getId() + " : " + fc3.getId());

					Bundle ba = new Bundle();
					ba.putInt("id", id);
					ba.putInt("v", i);
					Message ma = new Message();
					ma.setData(ba);
					cktest.sendMessageDelayed(ma, 200 + i * 10);

				} else {
					Log.i("ok", "x " + i);
				}

			} else {
				Log.i("ok", "" + i + ". " + id);
			}
		}
	};

	Handler cktest = new Handler() {
		public void handleMessage(Message msg) {
			Bundle ba = msg.getData();

			int id = ba.getInt("id");
			int i = ba.getInt("v");
			RelativeLayout ta = (RelativeLayout) getListView().getChildAt(i);
			if (ta == null) {
				return;
			}
			ta.setBackgroundColor(Color.argb(50, 220, 0, 40));

			LinearLayout la = (LinearLayout) ta.getChildAt(0);
			TextView fc = (TextView) la.getChildAt(2);
			fc.setBackgroundColor(Color.argb(55, 0, 0, 240));

			Bundle bx = new Bundle(ba);
			Message mx = new Message();
			mx.setData(bx);
			cktest2.sendMessageDelayed(mx, 880);
		}
	};

	Handler cku = new Handler() {
		public void handleMessage(Message msg) {
			Bundle ba = msg.getData();

			int id = ba.getInt("id");
			int i = ba.getInt("v");
			RelativeLayout ta = (RelativeLayout) getListView().getChildAt(i);
			if (ta == null) {
				ta = (RelativeLayout) findViewById(id);
			}

			if (ta != null) {
				LinearLayout la1a = (LinearLayout) ta.getChildAt(1);
				LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

				// LinearLayout labb = (LinearLayout) ta.getChildAt(1);
				TextView fc = (TextView) la1.getChildAt(1);
				// fc.setText("");
				fc.setBackgroundColor(Color.argb(55, 220, 0, 240));

				for (int ic = 1; ic < 100; ic++) {
					if (ck.containsKey("c" + ic)) {
						// v[i] = ck.getString("c" + i).split("\n");
						Bundle bh = new Bundle(ba);
						bh.putInt("pvid", ic);
						Message mx = new Message();
						mx.setData(bh);
						cku1.sendMessageDelayed(mx, 200);

					} else {
						break;
					}
				}
			}
		}
	};

	Handler cku1 = new Handler() {
		public void handleMessage(Message msg) {
			Bundle ba = msg.getData();
			if (upause) {
				return;
			}
			int id = ba.getInt("id");
			int i = ba.getInt("v");
			final int vi = ba.getInt("pvid");
			RelativeLayout ta = (RelativeLayout) getListView().getChildAt(i);
			if (ta == null) {
				ta = (RelativeLayout) findViewById(id);
			}
			if (ta != null) {
				LinearLayout la = (LinearLayout) ta.getChildAt(0);

				TextView fa = (TextView) la.getChildAt(0);
				final String ffa = fa.getText().toString();
				TextView fc;
				if (v[vi][2].contains("fieldid")) {
					fc = (TextView) ta.getChildAt(2);

				} else if (v[vi][2].contains("fieldc")) {
					fc = (TextView) la.getChildAt(2);
					fc.setVisibility(View.VISIBLE);
				} else {
					fc = (TextView) ta.getChildAt(2);
				}
				final String ffc = fc.getText().toString();

				Cursor e = SqliteWrapper.query(ctx, getContentResolver(),
						Uri.parse(v[vi][0]), new String[] { v[vi][1], "_id" },
						v[vi][3] + " = \"" + ffc + "\"" + " ", null, null);

				LinearLayout la1a = (LinearLayout) ta.getChildAt(1);

				if (v[vi][4].contains("audio")) {
					LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);
					TextView fa1 = (TextView) la1.getChildAt(0);
					fa1.setBackgroundColor(Color.argb(55, 0, 0, 240));

					if (e != null && e.moveToFirst()) {
						byte[] g3;
						g3 = e.getBlob(0);
						if (g3 == null) {
							e.close();
							return;
						}

						Log.i("ok", i + " " + v[vi][1] + " " + v[vi][3]
								+ " = \"" + ffc + "\" " + ":" + e.getString(1)
								+ ": " + g3.length);

						fa1.setGravity(Gravity.CENTER);
						fa1.setTextSize(14);
						fa1.setText("" + g3.length);
						fa1.setBackgroundColor(Color.argb(55, 0, 240, 0));

						final byte[] fg = g3;
						fa1.setOnClickListener(new OnClickListener() {

							public void onClick(View a) {

								TextView ab = (TextView) a;
								Bundle hu = new Bundle();
								hu.putByteArray("audio", fg);
								hu.putInt("id", ab.getId());
								Message mu = new Message();
								mu.setData(hu);
								playaudio.sendMessageDelayed(mu, 20);

							}
						});

					}
					fa1.setLayoutParams(new LinearLayout.LayoutParams(mxw, mxh));
					fa1.setVisibility(View.VISIBLE);
				} else if (v[vi][4].contains("imagea")) {
					LinearLayout la2 = (LinearLayout) la1a.getChildAt(1);

					// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
					ImageView fi1 = (ImageView) la2.getChildAt(1);

					fi1.setBackgroundColor(Color.argb(55, 0, 0, 240));

					if (e != null && e.moveToFirst()) {
						byte[] g3;
						g3 = e.getBlob(0);
						if (g3 == null) {
							e.close();
							return;
						}

						fi1.setLayoutParams(new LinearLayout.LayoutParams(mxw,
								mxh));

						Bitmap xt = null;
						Bitmap xh = null;

						try {
							xt = BitmapFactory
									.decodeByteArray(g3, 0, g3.length);
							xh = Bitmap
									.createScaledBitmap(xt, xt.getWidth() / 5,
											xt.getHeight() / 5, true);

						} catch (OutOfMemoryError sf) {
							Log.w("OOM", "xxx " + sf.getLocalizedMessage());
						}
						fi1.setScaleType(ScaleType.FIT_XY);
						fi1.setImageBitmap(xh);
						fi1.setVisibility(View.VISIBLE);
					}

				} else if (v[vi][4].contains("imageb")) {
					LinearLayout la2 = (LinearLayout) la1a.getChildAt(1);

					// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
					ImageView fi1 = (ImageView) la2.getChildAt(0);

					fi1.setBackgroundColor(Color.argb(55, 0, 0, 240));

					if (e != null && e.moveToFirst()) {
						byte[] g3;
						g3 = e.getBlob(0);
						if (g3 == null) {
							e.close();
							return;
						}

						fi1.setLayoutParams(new LinearLayout.LayoutParams(mxw,
								mxh));

						Bitmap xt = null;
						Bitmap xh = null;

						try {
							xt = BitmapFactory
									.decodeByteArray(g3, 0, g3.length);
							xh = Bitmap
									.createScaledBitmap(xt, xt.getWidth() / 3,
											xt.getHeight() / 3, true);

						} catch (OutOfMemoryError sf) {
							Log.w("OOM", "xxx");
						}

						fi1.setScaleType(ScaleType.CENTER_CROP);
						// fi1.setImageDrawable(hi);
						fi1.setImageBitmap(xh);
						fi1.setVisibility(View.VISIBLE);
					} else {

						fi1.setVisibility(View.VISIBLE);
						fi1.setLayoutParams(new LinearLayout.LayoutParams(mxw,
								mxh));
					}

				} else if (v[vi][4].contains("string")) {
					// LinearLayout la1 = (LinearLayout) ta.getChildAt(1);
					LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

					TextView fc1 = (TextView) la1.getChildAt(1);

					fc1.setBackgroundColor(Color.argb(55, 0, 0, 240));
					if (e != null && e.moveToFirst()) {
						Log.i("ok", i + " " + v[vi][1] + " " + " " + v[vi][3]
								+ " = \"" + ffc + "\" " + ":" + e.getString(1)
								+ ": " + e.getString(0));

						fc1.setLayoutParams(new LinearLayout.LayoutParams(mxw,
								mxh));

						fc1.setGravity(Gravity.CENTER);
						// fc1.setLines(5);
						fc1.setText("" + e.getString(0));
						fc1.setTextSize(19);
						fc1.setClickable(false);
						// Log.i("row"," ")
						// fc1.setLayoutParams(new LinearLayout.LayoutParams(-2,
						// -2));

						fc1.setOnTouchListener(new OnTouchListener() {
							long ca = 1;
							float dif = 0f;
							float dx = 0f;
							int vl = 1;

							public boolean onTouch(View a, MotionEvent ji) {
								// TODO Auto-generated method stub
								if (ji.getAction() == MotionEvent.ACTION_UP
										|| ji.getAction() == MotionEvent.ACTION_CANCEL) {
									amover2.sendEmptyMessageDelayed(2, 2);
									// getListView().setClickable(true);
								}
								if (ji.getAction() == MotionEvent.ACTION_DOWN) {
									dif = ji.getX();
									ca = SystemClock.uptimeMillis() + 20;
									amover.sendEmptyMessageDelayed(2, 2);
									TextView ab = (TextView) a;
									if (ab.length() > 0) {
										if (ab.length() == 1) {
											try {
												vl = Integer.parseInt(ab
														.getText().toString());
											} catch (NumberFormatException em) {
												vl = 1;
											}
										} else {
											vl = Integer.parseInt(ab.getText()
													.toString());
										}
									}
									// Log.i("wa", "" + (dif));
									return true;
								}

								if (ji.getAction() == MotionEvent.ACTION_MOVE) {

									if (ca < SystemClock.uptimeMillis()) {

										ca = SystemClock.uptimeMillis() + 20;
										dx = ji.getX();
										// Log.i("wash", "" + (dif - dx));
										TextView ab = (TextView) a;
										if (dx < dif) {
											ab.setText(""
													+ (vl + (1 * (int) (dif - dx))));
										} else {
											ab.setText(""
													+ (vl + (10 * (int) (dif - dx))));
										}

										ab.setTextSize(12);

										// if (dx > dif) {
										// if (dx - dif > 88) {
										// tg.sendEmptyMessageDelayed(2, 200);
										// return true;
										// }
										// }
										return true;
									}
								}

								return false;

							}
						});

					} else {

						fc1.setLayoutParams(new LinearLayout.LayoutParams(mxw,
								mxh));
						fc1.setGravity(Gravity.CENTER);
						fc1.setText(">");
						fc1.setTextSize(50);
						fc1.setClickable(true);
						fc1.setOnTouchListener(new OnTouchListener() {

							public boolean onTouch(View arg0, MotionEvent arg1) {
								// TODO Auto-generated method stub
								return false;
							}
						});

						final Bundle fb = new Bundle(ba);
						fc1.setOnClickListener(new OnClickListener() {

							public void onClick(View arg0) {
								Cursor e = SqliteWrapper.query(ctx,
										getContentResolver(),
										Uri.parse(v[vi][0]),
										new String[] { v[vi][1] }, v[vi][3]
												+ " = \"" + ffc + "\"" + " ",
										null, null);

								if (e != null && e.moveToFirst()) {
									e.close();
								} else {
									ContentValues cx = new ContentValues();
									cx.put("email", ffc);
									cx.put("display", ffa);
									cx.put("rotation", 14);

									Uri xuri = SqliteWrapper.insert(
											ctx,
											ctx.getContentResolver(),
											Uri.parse("content://com.docchomps.ok/contact"),
											cx);
								}

								Message hfb = new Message();
								hfb.setData(fb);
								columnv.sendMessageDelayed(hfb, 200);
								// column.sendEmptyMessageDelayed(2, 200);

							}
						});

					}

				} else if (v[vi][4].contains("numeric")) {
					// LinearLayout la1 = (LinearLayout) ta.getChildAt(1);
					LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);

					TextView fc1 = (TextView) la1.getChildAt(1);

					fc1.setBackgroundColor(Color.argb(55, 0, 0, 240));
					if (e != null && e.moveToFirst()) {
						Log.i("ok", i + " " + v[vi][1] + " " + " " + v[vi][3]
								+ " = \"" + ffc + "\" " + ":" + e.getString(1)
								+ ": " + e.getString(0));

						fc1.setLayoutParams(new LinearLayout.LayoutParams(mxw,
								mxh));
						// fc1.setMinHeight(88);

						fc1.setGravity(Gravity.CENTER);
						// fc1.setLines(5);
						fc1.setText("" + e.getString(0));
						fc1.setTextSize(19);
						// fc1.setClickable(false);
						final String tab = e.getString(0);
						final Bundle fb = new Bundle(ba);
						fc1.setOnTouchListener(new OnTouchListener() {
							long ca = 1;
							float dif = 0f;
							float dx = 0f;
							int vl = 1;

							public boolean onTouch(View a, MotionEvent ji) {
								// TODO Auto-generated method stub
								if (ji.getAction() == MotionEvent.ACTION_DOWN) {
									Message mh = new Message();
									Bundle fx = new Bundle(fb);
									fx.putInt("x", (int) ji.getRawX());
									fx.putInt("y", (int) ji.getRawY());
									fx.putInt("n", Integer.parseInt(tab));
									fx.putInt("max", 24 * 60);
									fx.putInt("min", 0);

									mh.setData(fx);
									numeric.sendMessageDelayed(mh, 20);
									return true;
								}
								return false;
							}
						});
					}

				}

				if (e != null) {
					e.close();
				}

				// fc.setText("" + fc.getId());
				Bundle bh = new Bundle(ba);
				Message mx3 = new Message();
				mx3.setData(bh);
				cku2.sendMessageDelayed(mx3, 200);
			}

		}
	};

	Handler numeric = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bl = msg.getData();
			Bundle hx = new Bundle(bl);
			Intent nx = new Intent();
			nx.setClass(ctx, Anumeric.class);
			nx.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_NO_HISTORY);
			nx.putExtras(hx);
			startActivity(nx);

		}
	};
	Handler amover = new Handler() {
		public void handleMessage(Message msg) {

			getListView().setClickable(false);
		}
	};

	Handler amover2 = new Handler() {
		public void handleMessage(Message msg) {
			getListView().setClickable(true);
		}
	};
	int vin = 1;
	Handler playaudio = new Handler() {
		public void handleMessage(Message msg) {

			Bundle ba = msg.getData();
			byte[] s = ba.getByteArray("audio");
			int id = ba.getInt("id");
			TextView ho4 = (TextView) findViewById(id);
			if (ho4 != null) {
				ho4.setBackgroundColor(Color.argb(55, 0, 240, 0));
			}
			/*
			 * { File filea = new File(Environment.getExternalStorageDirectory()
			 * .getAbsolutePath(), "ok/opt"); filea.mkdirs();
			 * 
			 * File file = new File(filea.getAbsolutePath(), "vh" + (vsv) +
			 * ".3gp");
			 * 
			 * FileInputStream fs = null;
			 * 
			 * try { fs = new FileInputStream(file); byte[] bf = new byte[(int)
			 * file.length()]; fs.read(bf, 0, (int) file.length());
			 * e.put("aback", bf); // Toast.makeText( // ctx, //
			 * file.getAbsolutePath() + "\n" // + file.length() + "\n" // +
			 * e.getAsByteArray("aback").length, // 2300).show();
			 * 
			 * } catch (FileNotFoundException e2) {
			 * 
			 * e2.printStackTrace(); } catch (IOException e2) { // TODO
			 * Auto-generated catch block e2.printStackTrace(); } }//
			 */
			File filea = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath(), "ok/opt");
			filea.mkdirs();

			File file = new File(filea.getAbsolutePath(), "bh" + (++vin)
					+ ".3gp");

			FileOutputStream fs = null;

			try {
				fs = new FileOutputStream(file);
				// byte[] bf = new byte[(int) file.length()];
				fs.write(s);// , 0, (int) s.length);
				// e.put("aback", bf);
				// Toast.makeText(
				// ctx,
				// file.getAbsolutePath() + "\n"
				// + file.length() + "\n"
				// + e.getAsByteArray("aback").length,
				// 2300).show();
				fs.flush();
				fs.close();

				Bundle b8 = new Bundle();
				b8.putString("path", file.getAbsolutePath());
				Message m8 = new Message();
				m8.setData(b8);
				playaudio2.sendMessageDelayed(m8, 200);

			} catch (FileNotFoundException e2) {
				Log.e("whoo", e2.getLocalizedMessage());
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				Log.e("IO WH", e2.getLocalizedMessage());
			}

			// try {
			// } catch (IOException k5) {
			// setr("Drat " + k5.getLocalizedMessage());
			// }

		}
	};
	Handler playaudio2 = new Handler() {
		public void handleMessage(Message msg) {
			Bundle ba = msg.getData();
			String path = ba.getString("path");
			int id = ba.getInt("id");
			TextView ho4 = (TextView) findViewById(id);
			if (ho4 != null) {
				ho4.setBackgroundColor(Color.argb(55, 0, 0, 240));
			}

			xuut = new MediaPlayer();
			try {

				xuut.setDataSource(path);
				xuut.prepare();
				xuut.start();

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {

				if (e.getLocalizedMessage().contains("Prepare")) {
				} else {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}// .setDataSource(file.getAbsolutePath());

		}
	};

	MediaPlayer xuut;
	Handler cku2 = new Handler() {
		public void handleMessage(Message msg) {
			Bundle ba = msg.getData();

			int id = ba.getInt("id");
			int i = ba.getInt("v");
			final int vi = ba.getInt("pvid");

			RelativeLayout ta = (RelativeLayout) getListView().getChildAt(i);
			if (ta == null) {
				ta = (RelativeLayout) findViewById(id);
			}
			if (ta != null) {
				LinearLayout la1a = (LinearLayout) ta.getChildAt(1);
				LinearLayout la1 = (LinearLayout) la1a.getChildAt(0);
				LinearLayout la2 = (LinearLayout) la1a.getChildAt(1);

				if (v[vi][4].contains("audio")) {
					TextView fc = (TextView) la1.getChildAt(0);
					// fc.setText("");
					fc.setBackgroundColor(Color.argb(120, 0, 240, 0));
				} else if (v[vi][4].contains("imagea")) {
					// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
					ImageView fi1 = (ImageView) la2.getChildAt(1);
					fi1.setBackgroundColor(Color.argb(0, 0, 0, 240));

				} else if (v[vi][4].contains("imageb")) {
					// LinearLayout la2 = (LinearLayout) ta.getChildAt(3);
					ImageView fi1 = (ImageView) la2.getChildAt(0);
					fi1.setBackgroundColor(Color.argb(0, 0, 0, 240));

				} else if (v[vi][4].contains("string")) {
					TextView fc = (TextView) la1.getChildAt(1);
					fc.setBackgroundColor(Color.argb(120, 130, 0, 240));
				} else if (v[vi][4].contains("numeric")) {
					// LinearLayout labb = (LinearLayout) ta.getChildAt(1);
					TextView fc = (TextView) la1.getChildAt(1);
					fc.setBackgroundColor(Color.argb(120, 0, 210, 240));
					// fc.setText("");
				} // Bundle bh = new Bundle(ba);
					// Message mx3 = new Message();
					// mx3.setData(bh);cku2.sendMessageDelayed(mx3,200);
			}
		}
	};

	Handler cktest2 = new Handler() {
		public void handleMessage(Message msg) {
			Bundle ba = msg.getData();

			int id = ba.getInt("id");
			int i = ba.getInt("v");
			RelativeLayout ta = (RelativeLayout) getListView().getChildAt(i);

			if (ta != null) {
				ta.setBackgroundColor(Color.argb(56, 20, 0, 240));
				LinearLayout la = (LinearLayout) ta.getChildAt(0);
				TextView fc = (TextView) la.getChildAt(2);
				fc.setBackgroundColor(Color.argb(55, 0, 0, 240));

				if (ba.getInt("cc", 0) == 0) {
					Bundle bh = new Bundle(ba);
					bh.putInt("cc", 1);
					Message mx = new Message();
					mx.setData(bh);
					cku.sendMessageDelayed(mx, 200 + 10 * i);
				} else if (ba.getInt("cc") == 1) {
					return;
				}
				ba.putInt("cc", ba.getInt("cc", 0) + 1);

				Bundle bx = new Bundle(ba);
				Message mx = new Message();
				mx.setData(bx);
				cktest.sendMessageDelayed(mx, 880);
			} else {
			}

		}
	};

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		column.removeMessages(2);
		columnx.removeMessages(2);
		upause = true;
		Log.i("ok", "pause");
		if (xuut != null) {
			xuut.stop();
			xuut.release();
		}

	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("ok", "restart");

	}

	boolean upause = false;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("ok", "resume");
		upause = false;
		column.sendEmptyMessageDelayed(2, 80);
		columnx.sendEmptyMessageDelayed(2, 20);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		Log.i("ok", "search");
		return super.onSearchRequested();
	}

}
