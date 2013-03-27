package com.docchomps.ok;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;


/*
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
*/
/* import com.itextpdf.text.Anchor;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter; */

public class OKActivity extends Activity {
	@Override
	public void onCreate(Bundle si) {
		super.onCreate(si);
		// XXX
		setContentView(R.layout.pas);
		// getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		// Log.i("ok", "99.9999   ----------------create----------------");

		// Intent ix4 = getIntent();
		// if (ix4 != null) {
		// Bundle ib4 = ix4.getExtras();
		// ib4 = null;
		// }
		// ix4 = null;

		pbn = (RelativeLayout) findViewById(R.id.pbc);
		ctx = getApplicationContext();

		Display sd = getWindowManager().getDefaultDisplay();
		// sd.getOrientation();
		mwidth = sd.getWidth();
		mheight = sd.getHeight();
		sd = null;
		mmost = (mwidth > mheight ? mwidth : mheight);
		hid = (int) SystemClock.uptimeMillis();

		if (tips == null) {
			tips = new ImageView(ctx);
			RelativeLayout.LayoutParams dhdx = new RelativeLayout.LayoutParams(
					-1, -1);
			tips.setLayoutParams(dhdx);
			dhdx = null;
			tips.setScaleType(ScaleType.FIT_START);
			while (findViewById(++hid) != null) {
			}
			tips.setId(hid);
			tips.setBackgroundResource(R.drawable.ebon5);
			tips.setImageResource(R.drawable.dot);
			tips.setVisibility(View.INVISIBLE);
			pbn.addView(tips);
		}

		sreq01.sendEmptyMessageDelayed(2, 75);

	}

	private Handler sreq01 = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading " + msg.what);

			if (tips != null && tips.getVisibility() == View.INVISIBLE
					&& tipscs < SystemClock.uptimeMillis()) {
				tips.setVisibility(View.VISIBLE);
				Animation a4 = AnimationUtils.loadAnimation(ctx, R.anim.oomx12);
				tips.startAnimation(a4);
				tipscs = SystemClock.uptimeMillis() + a4.getDuration();
			}

			boomBoard = (RelativeLayout) findViewById(R.id.pbbc5);// ccx
			boomBoard.setVisibility(View.INVISIBLE);
			sparkEasel = (RelativeLayout) findViewById(R.id.pbbcn);

			{
				RelativeLayout.LayoutParams hiu = new RelativeLayout.LayoutParams(
						-1, -1);
				boomBoard.setBackgroundResource(R.drawable.ebin4);
				boomBoard.setLayoutParams(hiu);
			}

			// pba = (RelativeLayout) findViewById(R.id.pbaa);
			pbrus = (RelativeLayout) findViewById(R.id.pbrus);
			alls = (RelativeLayout) findViewById(R.id.alls);

			// 10m point xx
			sreq02.sendEmptyMessageDelayed(msg.what, 75);

		}
	};

	private Handler sreq02 = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading b " + msg.what);

			// pbspin = (RelativeLayout) findViewById(R.id.pbspin8);
			// ipb = (ImageView) findViewById(R.id.pbl);

			vmp = (RelativeLayout) findViewById(R.id.cmaprr);
			xmmbb = (RelativeLayout) findViewById(R.id.cmapbb);
			xmmd = (ImageView) findViewById(R.id.pbsd);
			xmme = (ImageView) findViewById(R.id.pbe);
			xmmi = (ImageView) findViewById(R.id.pbo);
			pbbx = (RelativeLayout) findViewById(R.id.pbbx);
			pbbxg = (TextView) findViewById(R.id.pbbxg);
			/*
			xmm = (MapView) findViewById(R.id.cmapb);

			viewapp_map = false;
			// ipb.setImageResource(R.drawable.pbo);
			xmmi.setVisibility(View.INVISIBLE);
			xmmd.setVisibility(View.INVISIBLE);
			xmme.setVisibility(View.INVISIBLE);
			pbbx.setVisibility(View.INVISIBLE);
			xmmbb.setDrawingCacheEnabled(true);
			xmmstation = 1;
			xmm.setSatellite(true);
			*/
			// 9-10 m
			sreq03.sendEmptyMessageDelayed(msg.what, 75);

		}
	};

	private Handler sreq03 = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading c " + msg.what);

			{
				RelativeLayout.LayoutParams dhdx;
				ImageView hj;
				int sx = dcelw;
				int sy = dcelh;
				int wx = 3;
				int wy = 3;
				int wspace = mwidth - 60;
				// sx = wspace/wx
				while (wspace / wx > sx) {
					if (wspace / wx > sx * 2) {
						wx++;
						continue;
					}
					sx++;
				}
				// draw up
				while (sx * wx > wspace) {
					sx--;
				}

				wy = 1 + (balls.length / wx);
				int hspace = boomBoard.getHeight() - 60;

				while (sy * (wy + 0) > hspace) {
					sy--;
				}
				while (sy * (wy + 0) < hspace) {
					sy++;
				}

				dcelw = sx;
				dcelh = sy;

				int cols = 0;
				int rows = 1;
				for (int x = 0; x < nalls.length; x++) {
					if (nalls[x] == null) {

						nalls[x] = Bitmap.createBitmap(
								(int) (pbn.getWidth() / 4),
								(int) (pbn.getHeight() / 4),
								Bitmap.Config.ARGB_8888);
						balls[x] = new Canvas(nalls[x]);
						cols++;
						// Dull

						if (cols > wx) {
							rows++;
							cols = 1;
						}

						hj = new ImageView(ctx);
						dhdx = new RelativeLayout.LayoutParams(sx, sy);
						dhdx.setMargins(30 + (sx * (cols - 1)), 30 + dcelh + 5
								+ (sy * (rows - 1)), 0, 0);
						hj.setLayoutParams(dhdx);
						dhdx = null;
						hj.setScaleType(ScaleType.FIT_CENTER);
						while (findViewById(++hid) != null) {
						}
						halls[x] = hid;

						// hj.setBackgroundResource(R.drawable.nano);
						hj.setImageBitmap(nalls[x]);
						hj.setId(halls[x]);
						hj.setOnTouchListener(markUI);
						alls.addView(hj);
						// pageb
					}
				}
			}

			if (bla2 == null && bla[0] == null) {
				Log.i("ok", "Mark pokes");
				bla2 = BitmapFactory.decodeResource(getResources(),
						R.drawable.cloud);
				for (int ki = 0; ki < 5; ki++) {
					int ni = 1;
					switch (ki) {
					case 1:
						ni = R.drawable.pokeeb;
						break;
					case 2:
						ni = R.drawable.pokeeo;
						break;
					case 3:
						ni = R.drawable.pokeeg;
						break;
					case 4:
						ni = R.drawable.pokeec;
						break;
					default:
						ni = R.drawable.pokee;
					}

					bla[ki] = BitmapFactory.decodeResource(getResources(), ni);
					blm[ki] = Bitmap.createScaledBitmap(bla[ki],
							bla[ki].getWidth() / 4, bla[ki].getHeight() / 4,
							true);
				}

				dw = bla[0].getWidth();
				dh = bla[0].getHeight();

			}

			if (boxerfil == null) {
				Log.i("ok", "Document Thumbnail");
				{
					boxerfil = new ImageView(ctx);
					RelativeLayout.LayoutParams f8 = new RelativeLayout.LayoutParams(
							(int) (dcelw * 1.5), dcelh);
					f8.setMargins(30, 30, 0, 0);
					boxerfil.setLayoutParams(f8);
					while (findViewById(++hid) != null) {
					}
					boxerfil.setId(hid);
					// boxerfil.setFocusable(true);
					boxerfil.setBackgroundResource(R.drawable.filem);
					alls.addView(boxerfil);
				}

				{
					ImageView boxerfil = new ImageView(ctx);
					RelativeLayout.LayoutParams f8 = new RelativeLayout.LayoutParams(
							(int) (dcelw * 1.5), dcelh);
					f8.setMargins(30, 30, 0, 0);
					boxerfil.setLayoutParams(f8);
					while (findViewById(++hid) != null) {
					}
					boxerfil.setId(hid);
					// boxerfil.setFocusable(true);
					boxerfil.setBackgroundResource(R.drawable.fileb);
					alls.addView(boxerfil, 0);
				}
			}

			// ebon
			// "atitle"
			if (boxertit == null) {
				Log.i("ok", "Document Editable Title");
				boxertit = new EditText(ctx);
				RelativeLayout.LayoutParams f8 = new RelativeLayout.LayoutParams(
						-1, -2);
				f8.addRule(RelativeLayout.ALIGN_TOP, boxerfil.getId());
				f8.addRule(RelativeLayout.ALIGN_BOTTOM, boxerfil.getId());
				f8.setMargins((int) (30 + (dcelw * 1.5) + 5), 30, 30, 0);
				boxertit.setLayoutParams(f8);
				while (findViewById(++hid) != null) {
				}
				boxertit.setId(hid);
				// boxertit.setBackgroundColor(Color.argb(10, 0,
				// 0, 110));
				boxertit.setGravity(Gravity.BOTTOM);
				boxertit.setTextSize(22f);
				boxertit.setSaveEnabled(true);
				boxertit.setPadding(8, 0, 8, 0);
				// boxertit.setLines(1);
				boxertit.setText("Boom Boom");// Boom Boom
				boxertit.setBackgroundResource(R.drawable.dot);
				alls.addView(boxertit);
			}

			// 10
			sreq04.sendEmptyMessageDelayed(2, 75);

		}

	};
	private Handler sreq04 = new Handler() {
		// Animation anhub4;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              initial loading d " + msg.what);
			pbn.setOnTouchListener(sparkBoardUI);

			started = true;
			if (resume) {
				handleResume.sendEmptyMessageDelayed(2, 75);
			}
		}
	};
	public Handler handleResume = new Handler() {
		public void handleMessage(Message msg) {
			if (!started) {
				resume = true;
				Log.i("ok", "99.9999                  handle Resume when ready");
				return;
			}
			Log.i("ok", "99.9999                  handle Resume");

			resume = false;

			upause = false;

			pwt = 0;
			pww = 0;
			smx = 0;
			smct = 0;
			smat = 0;

			Display sd = getWindowManager().getDefaultDisplay();
			// sd.getOrientation();
			mwidth = sd.getWidth();
			mheight = sd.getHeight();
			sd = null;
			mmost = (mwidth > mheight ? mwidth : mheight);
			hid = (int) SystemClock.uptimeMillis();

			if (mwidth > mheight) {
				hbpathL = new Path();
				hbpathL.addCircle((int) ((mwidth) / 2), (int) ((mheight) / 2),
						(int) ((mheight) / 2) - 40, Path.Direction.CCW);
			} else {
				hbpathL = new Path();
				hbpathL.addCircle((int) ((mwidth) / 2), (int) ((mheight) / 2),
						(int) ((mwidth) / 2) - 40, Path.Direction.CCW);
			}
			// tapcn
			{
				reg = ctx.getSharedPreferences("Preferences",
						Context.MODE_WORLD_WRITEABLE);
				edt = reg.edit();
			}

			reg.registerOnSharedPreferenceChangeListener(underDingo);
			// tips.startAn
			smartSpark.sendEmptyMessageDelayed(2, (1880 / 6) * 1);
			recordService.sendEmptyMessageDelayed(3, (1880 / 6) * 2);
			sensorSurvey.sendEmptyMessageDelayed(2, (1880 / 6) * 3);
			//gpslink.sendEmptyMessageDelayed(2, (1880 / 6) * 4);
			//viewLocation.sendEmptyMessageDelayed(-1, (1880 / 6) * 5);
			dingoSparkInactive.sendEmptyMessageDelayed(2, (1880 / 6) * 6);

			pbn.setVisibility(View.VISIBLE);
			
			// if (mwidth > mheight) {
			// hiu.setMargins(0, 0, 0 + pbook.getWidth(), 0);
			// } else {// cols
			// hiu.setMargins(0, 0, 0, 0 + pbook.getHeight());
			// }

			// if (boomBoard.getVisibility() == View.INVISIBLE) {
			// boomBoard.setVisibility(View.VISIBLE);
			// Animation anhub4 = AnimationUtils.loadAnimation(ctx,
			// R.anim.oomx9);
			// boomBoard.startAnimation(anhub4);
			// }
			// nanoactive = false;

			// anhub4.setStartOffset(880);

			if (boxerhugtt < SystemClock.uptimeMillis()) {
				boxerhugon.sendEmptyMessageDelayed(2, 750);
				if (tips != null && tips.getVisibility() == View.INVISIBLE
						&& tipscs < SystemClock.uptimeMillis()) {
					Animation a4 = AnimationUtils.loadAnimation(ctx,
							R.anim.oomx12);
					tips.setVisibility(View.VISIBLE);
					tips.startAnimation(a4);
					tipscs = SystemClock.uptimeMillis() + a4.getDuration();
				}

			}
			
			if (boxerhug == null) {
				boxerhug = new RelativeLayout(ctx);
				while (findViewById(++hid) != null) {
				}
				boxerhug.setId(hid);
				boxerhug.setBackgroundResource(R.drawable.wh6);
				// boxerhug.setBackgroundColor(Color.argb(10,
				// 70,
				// 0, 110));
				// boxerhug.setMinimumHeight(30);
				// boxerhug.setSaveEnabled(true);
				// boxerhug.setPadding(8, 0, 8, 0);
				// boxerhug.setText("Like this; like that.");// Boom Boom
				boxerhug.setEnabled(true);
				pbn.addView(boxerhug);

				hugis = new TextView(ctx);
				while (findViewById(++hid) != null) {
				}
				hugis.setId(hid);
				hugis.setLines(1);
				hugis.setGravity(Gravity.BOTTOM | Gravity.LEFT);
				hugis.setBackgroundResource(R.drawable.dot);

				// boxerhugaware = false;
				hugis.setVisibility(View.INVISIBLE);
				pbn.addView(hugis, 0);

			} else {
				hugis.setText(ctt);
				hugis.setVisibility(View.VISIBLE);
				// boxerhugware = true;
				boxerhug.removeAllViews();
			}

			// tips
			{
				RelativeLayout.LayoutParams f8 = new RelativeLayout.LayoutParams(
						-1, (mheight / 8) * 5);
				f8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);
				f8.setMargins(0, 0, 0, 0);
				boxerhug.setLayoutParams(f8);
				boxerhug.setVisibility(View.INVISIBLE);
				boxerhugaware = false;

				int dra = R.drawable.nano8;
				int margtop = 65;// ble.wh
				int margside = 15;
				supert9top = ((mheight - 30) / 8) * 3;
				supert9w = (int) ((mwidth - margside * 2) / 3f);
				supert9h = (int) ((((mheight - 45) / 8f) * 5f - margtop - 5f) / 4f);

				RelativeLayout.LayoutParams ho = new RelativeLayout.LayoutParams(
						-1, -2);
				ho.addRule(RelativeLayout.ALIGN_TOP, boxerhug.getId());
				ho.setMargins(0, 0, 0, 0);
				hugis.setText(" ");
				hugis.setLayoutParams(ho);
				hugis.setTextSize(30f);
				hugis.setVisibility(View.INVISIBLE);

				// 0
				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					r8.setMargins(margside + supert9w * 1, supert9h * 3, 0, 15);
					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("0");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					r8.setMargins(margside + supert9w * 1, supert9h * 3, 0, 15);
					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[11] = hid;
					j8.setId(josh[11]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("directory");
					j8.setBackgroundResource(dra);
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				{//
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, supert9h * 3, 0, 15);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("*");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, supert9h * 3, 0, 15);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[10] = hid;
					j8.setId(josh[10]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("space");
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				{// #
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, supert9h * 3, 0, 15);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("#");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, supert9h * 3, 0, 15);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					while (findViewById(++hid) != null) {
					}
					josh[12] = hid;
					j8.setId(josh[12]);
					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("enter");
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				// 1
				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, 0, 0,
							15 + supert9h * 3);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("1");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, 0, 0,
							15 + supert9h * 3);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					while (findViewById(++hid) != null) {
					}
					josh[1] = hid;
					j8.setId(josh[1]);
					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("abc");
					j8.setBackgroundResource(dra);

					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				// 2
				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 1, 0, 0,
							15 + supert9h * 3);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("2");
					j8.setTextColor(Color.argb(200, 50, 50, 50));

					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 1, 0, 0,
							15 + supert9h * 3);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[2] = hid;
					j8.setId(josh[2]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("def");
					j8.setBackgroundResource(dra);

					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				// 3
				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, 0, 0,
							15 + supert9h * 3);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("3");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, 0, 0,
							15 + supert9h * 3);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[3] = hid;
					j8.setId(josh[3]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("ghi");
					j8.setBackgroundResource(dra);

					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				{// 4
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, 0, 0,
							15 + supert9h * 2);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("4");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, 0, 0,
							15 + supert9h * 2);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[4] = hid;
					j8.setId(josh[4]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("jkl");
					j8.setBackgroundResource(dra);
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				{// 5
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 1, 0, 0,
							15 + supert9h * 2);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("5");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 1, 0, 0,
							15 + supert9h * 2);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[5] = hid;
					j8.setId(josh[5]);
					j8.setPadding(4, 4, 4, 4);
					j8.setBackgroundResource(dra);

					j8.setText("mno");
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				{// 6
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, 0, 0,
							15 + supert9h * 2);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setText("6");
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, 0, 0,
							15 + supert9h * 2);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[6] = hid;
					j8.setId(josh[6]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("pqr");
					j8.setBackgroundResource(dra);
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				// 7
				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, 0, 0,
							15 + supert9h * 1);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("7");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 0, 0, 0,
							15 + supert9h * 1);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[7] = hid;
					j8.setId(josh[7]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("stu");
					j8.setBackgroundResource(dra);
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				// 8
				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 1, 0, 0,
							15 + supert9h * 1);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("8");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 1, 0, 0,
							15 + supert9h * 1);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[8] = hid;
					j8.setId(josh[8]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("vwx");
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					j8.setBackgroundResource(dra);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

				// 9
				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, 0, 0,
							15 + supert9h * 1);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("9");
					j8.setTextColor(Color.argb(200, 50, 50, 50));
					j8.setGravity(Gravity.CENTER_HORIZONTAL);
					// j8.setBackgroundColor(Color.argb(30, 110, 10, 20));
					j8.setTextSize(30f);
					boxerhug.addView(j8);
				}

				{
					TextView j8 = new TextView(ctx);
					RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(
							supert9w, supert9h);
					r8.setMargins(margside + supert9w * 2, 0, 0,
							15 + supert9h * 1);
					r8.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1);

					j8.setLayoutParams(r8);
					while (findViewById(++hid) != null) {
					}
					josh[9] = hid;
					j8.setId(josh[9]);
					j8.setPadding(4, 4, 4, 4);
					j8.setText("yz");
					j8.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
					// j8.setBackgroundColor(Color.argb(30, 210, 210, 210));
					j8.setBackgroundResource(dra);
					j8.setTextSize(18f);
					boxerhug.addView(j8);
				}

			}


		}
	};
	public Handler operationsPunctuation = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok",
					"99.9999                   Operations Punctionion, Define Spark "
							+ msg.what
							+ " ("
							+ (actwin > SystemClock.uptimeMillis() ? "pending "
									+ (actwin - SystemClock.uptimeMillis())
									: "ready since "
											+ (SystemClock.uptimeMillis() - actwin))
							+ ")");
			Bundle hx = msg.getData();
			operationsPunctuation.removeMessages(msg.what);

			if (actwin > SystemClock.uptimeMillis()) {
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.what = 2;
				ml.setData(bx);
				operationsPunctuation.sendMessageDelayed(ml, 1820);
				hx = null;
				return;
			}

			if (xuri == null) {
				Log.w("ok", "99.9999                  WHA punc      super");
				return;
			}

			{

				// atitle SqliteWrapper.query
				// SqliteWrapper.update(ctx, ctx.getContentResolver(),
				// Uri.parse("content://com.docchomps.ok/moment"), gi,
				// "_id=" + xuri.getLastPathSegment(), null);
				Cursor k = SqliteWrapper.query(ctx, getContentResolver(),
						Uri.parse("content://com.docchomps.ok/moment"),
						new String[] { "_id", "atitle" },
						"_id=" + xuri.getLastPathSegment(), null, null);
				String atitle = (k != null && k.moveToFirst()) ? k.getString(1)
						: "stored " + k.getInt(0);
				if (k != null) {
					k.close();
				}
				boolean err = false;
				if (!xuri.toString().contentEquals(hx.getString("row"))) {
					err = true;
					atitle = "STATIC ERROR";
				}
				xuri = null;

				if (gpd == null) {
					err = true;
					atitle = "Sliced Between";
					Log.i("ok", "slice between early b          999");
				}

				Bundle b8 = new Bundle();
				b8.putString("content", atitle);
				b8.putInt("duration", ADURATION);
				Message m8 = new Message();
				m8.setData(b8);
				ddpuk.sendMessageDelayed(m8, 1);
				m8 = null;
				b8 = null;
				if (err) {
					return;
				}
			}

			// Uri xu = Uri.parse(hx.getString("row"));

			// Keep
			Log.i("ok", "operationsPunctuation " + SystemClock.uptimeMillis());

			// dingoSparkInactive.removeMessages(2);
			// dingoSparkInactive.sendEmptyMessageDelayed(2, anoob.getDuration()
			// + 3500
			// - anhib.getDuration());

			// displayLocation.removeMessages(2);
			// displayLocation.sendEmptyMessageDelayed(2, 20);

			// Bundle hu4 = new Bundle(hx);
			// Message mi = new Message();
			// mi.setData(hu4);
			// mi.what = 2;
			// ob.setStartOffset(220);
			// oopla.removeMessages(2);
			// oopla.sendMessageDelayed(mi, ob.getDuration());
			// Animation ob = AnimationUtils.loadAnimation(ctx, R.anim.oob);
			// if (ipb != null) {
			// ipb.startAnimation(ob);
			// ipbcs = SystemClock.uptimeMillis() + ob.getDuration();
			// }
			int gvsv = vsv;
			// indrawing = false;
			// gxf.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
			// gxfx.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
			// gxfx = null;
			// gxf = null;

			// FINE

			{
				smartSparkService.removeMessages(5);

				smartSpark.removeMessages(2);
				smartSpark.sendEmptyMessageDelayed(2, 10);
				ballson++;
				if (ballson >= falls.length) {
					ballson = 0;
				}
				ballsdeep.sendEmptyMessageDelayed(2, 10);
				ballsService.sendEmptyMessageDelayed(2, 100);
			}

			{
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.setData(bx);
				drawslice.sendMessageDelayed(ml, (1880 / 8) * 1);
				ml = null;
				bx = null;
			}

			{
			//	recordService.sendEmptyMessageDelayed(3, (1880 / 8) * 3);
			}

			// sm01.send
			{
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.setData(bx);
			//	aplace.sendMessageDelayed(ml, (1880 / 8) * 5);
				ml = null;
				bx = null;
			}

			{
				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				bx.putInt("f", gvsv);
				ml.setData(bx);
				aheard.sendMessageDelayed(ml, (1880 / 8) * 7);
				ml = null;
				bx = null;
			}

			hx = null;

		}
	};

	private Handler drawsliceb = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                     Operation/Drawslice b "
					+ msg.what);

			Bundle hx = msg.getData();

			// tapClear.removeMessages(2);
			// tapClear.sendEmptyMessageDelayed(2, 1000);

			{

				Bundle bx = new Bundle(hx);
				Message ml = new Message();
				ml.setData(bx);
				drawslicec.sendMessageDelayed(ml, 10);
				ml = null;
				bx = null;
			}
			hx = null;

		}
	};
	private Handler drawslicec = new Handler() {

		public void handleMessage(Message msg) {
			final Bundle hx = msg.getData();
			Uri xu = Uri.parse(hx.getString("row"));
			try {
				mngxu = Integer.parseInt(xu.getLastPathSegment());
				mngx8 = mngxu;
			} catch (NumberFormatException en) {
				Log.i("ok", "id mng");
				return;
			}
			// boomBoard.setVisibility(View.VISIBLE);
			// sparkEasel.setVisibility(View.VISIBLE);
			// pbn.bringChildToFront(sparkEasel);
			// pbn.bringChildToFront(boomBoard);

			dhd4w = (int) (mwidth * 0.18f);// uimvr.getWidth();
			dhd4h = (int) (mheight * 0.18f);// uimvr.getHeight();

			// hiscave
			// Brain Blood to UI to the Cloud conceptualization.
			{
				// if (reg == null) {
				// reg = ctx.getSharedPreferences("Preferences",
				// Context.MODE_WORLD_WRITEABLE);
				// edt = reg.edit();
				// }
				aspark = reg.getInt("aspark", 0);

				ContentValues uq = new ContentValues();
				uq.put("aspark", aspark);
				uq.put("atref", mngxu);
				uq.put("attable", "content://com.docchomps.ok/moment");
				uq.put("atcolumn", "aslide");
				uq.put("atwidth", dhd4w);
				uq.put("atheight", dhd4h);
				uq.put("atx", (dhd4w / 2) + 22);
				uq.put("aty", mheight - (dhd4h / 2) - 30);

				Uri uj = SqliteWrapper.insert(ctx, getContentResolver(),
						Uri.parse("content://com.docchomps.ok/refplay"), uq);
				uq = null;
				if (uj == null) {
					Log.w("ok", "sparkMark entry a");
				} else {
					Log.i("ok", "sparkMark entry " + uj.toString());
				}
			}
			// drawslice

			// dingoSparkToggle.sendEmptyMessageDelayed(3, 10);

		}
	};
	private Handler drawslice = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                     Operation/Drawslice  "
					+ msg.what);

			if (gpd == null) {
				Log.i("ok", "slice between second b         999");
				return;
			}

			if (productiondash != null) {
				Animation oh = AnimationUtils.loadAnimation(ctx, R.anim.oomx5);// oomx8
				productiondash.startAnimation(oh);
				hiscave.sendEmptyMessageDelayed(productiondash.getId(),
						oh.getDuration());
				oh = null;
			}

			if (surfacedash != null) {
				Animation oh5 = AnimationUtils.loadAnimation(ctx, R.anim.oomx5);
				surfacedash.startAnimation(oh5);
				hiscave.sendEmptyMessageDelayed(surfacedash.getId(),
						oh5.getDuration());
				oh5 = null;
			}

			Bundle hx = msg.getData();
			Uri xu = Uri.parse(hx.getString("row"));
			try {
				// if (dhd4 != null) {
				// sparkEasel.removeView(dhd4);
				// }

				ContentValues e = new ContentValues();
				ByteArrayOutputStream st;

				if (gpd != null) {
					st = new ByteArrayOutputStream();
					if (st != null) {
						gpd.compress(CompressFormat.PNG, 0, st);
						e.put("aslide", st.toByteArray());
						gppd5 = BitmapFactory.decodeByteArray(st.toByteArray(),
								0, st.size());
					}
					st = null;
				}
				// gpdd = null;

				if (gpdx != null) {
					// gppd5x = Bitmap.createBitmap(gpddx);
					st = new ByteArrayOutputStream();
					if (st != null) {
						gpdx.compress(CompressFormat.PNG, 0, st);
						e.put("aslope", st.toByteArray());
						gppd5x = BitmapFactory.decodeByteArray(
								st.toByteArray(), 0, st.size());
					}
					st = null;
				}
				// gpddx = null;

				SqliteWrapper.update(ctx, ctx.getContentResolver(),
						Uri.parse("content://com.docchomps.ok/moment"), e,
						"_id=" + xu.getLastPathSegment(), null);
				e = null;
				// dhdin.sendEmptyMessageDelayed(2, 20);

				// gpd = null;
				// gpdx = null;
				// productiondash = null;
				// surfacedash = null;

			} catch (OutOfMemoryError sf) {
				Log.w("ok", "wha c " + sf.getLocalizedMessage());
			}

			{
				Bundle hu = new Bundle(hx);
				// hu.putInt("grr", productiondash.getId());
				Message mu = new Message();
				mu.setData(hu);
				drawsliceb.sendMessageDelayed(mu, 10);
			}

		}
	};

	public Handler recordService = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              record service "
					+ msg.what
					+ " "
					+ (cs > 1 ? (SystemClock.uptimeMillis() - cs)
							+ "ms last slice" : "first recording"));
			cs = SystemClock.uptimeMillis();
			// if (smct > 1) {
			// Log.i("ok", "sound clear rest " + msg.what);
			// recordService.removeMessages(msg.what);
			// recordService.sendEmptyMessageDelayed(msg.what, 2000);
			// return;
			// }

			recordService.removeMessages(2);
			if (actwin > SystemClock.uptimeMillis() - 2000 && msg.what != 3) {
				Log.i("ok", "-sound clear rest " + msg.what);

				recordService.sendEmptyMessageDelayed(2, 2000);
				return;
			}

			if (msg.what == 3) {
				recordService.removeMessages(3);
			}

			if (upause) {
				return;
			}

			// Log.i("ok", "99.9999999999999          recordService "
			// + datetime(System.currentTimeMillis()));
			// if (ipb != null) {
			// ipb.setImageResource(R.drawable.pbo);
			// }
			// u4 = Camera.open();

			// android.media.CamcorderProfile c7 = CamcorderProfile
			// .get(CamcorderProfile.QUALITY_HIGH);
			if (u8 != null) {

				// u8.reset();
				// u8.stop();
				try {
					u8.stop();
				} catch (RuntimeException e2) {
				}

				// u8 = null;
				// recordService.sendEmptyMessageDelayed(2, 2000);
				// return;

				// e2.printStackTrace();
				// } catch (IllegalStateException e1) {
				// e1.printStackTrace();
				u8.reset();
				u8.release();

				u8 = null;
			} else {

			} // u8.setCamera();
			recordServiceb.sendEmptyMessageDelayed(2, 20);

		}
	};
	private Handler recordServiceb = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service b " + msg.what);

			try {
				u8 = new MediaRecorder();
				u8.setAudioSource(MediaRecorder.AudioSource.MIC);
				// u8.setVideoSource(MediaRecorder.VideoSource.DEFAULT);
				u8.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			} catch (RuntimeException e2) {
				Log.w("ok", "wha n b " + e2.getLocalizedMessage());
			}

			recordServicec.sendEmptyMessageDelayed(2, 20);
		}
	};
	private Handler recordServicec = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service c " + msg.what);

			// File filea = new File(Environment.getExternalStorageDirectory()
			// .getAbsolutePath(), "ok/opt");
			// filea.mkdirs();

			// if (filea.exists()) {

			if (++vsv > 5) {
				vsv = 1;
			}

			Date b = new Date();
			String d1 = ""
					+ (b.getYear() + 1900)
					+ ""
					+ (b.getMonth() < 9 ? "0" + (b.getMonth() + 1) : b
							.getMonth() + 1) + ""
					+ (b.getDate() < 10 ? "0" + (b.getDate()) : b.getDate());

			String d2 = ""
					+ (b.getHours() < 10 ? "0" + (b.getHours()) : b.getHours())
					+ ""
					+ (b.getMinutes() < 10 ? "0" + (b.getMinutes()) : b
							.getMinutes())
					+ ""
					+ (b.getSeconds() < 10 ? "0" + (b.getSeconds()) : b
							.getSeconds());

			File dir = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath(), "data/com.docchomps.ok/" + d1);
			dir.mkdirs();
			File file = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath(), "data/com.docchomps.ok/" + d1 + "/"
					+ d2 + ".3gp");

			vsvfiles[vsv] = file.getAbsolutePath();
			file = null;
			dir = null;
			d2 = null;
			d1 = null;
			b = null;

			recordServiced.sendEmptyMessageDelayed(2, 20);

		}
	};
	private Handler recordServiced = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service d " + msg.what);

			// ffd = new FileDescriptor();
			if (u8 == null) {
				Log.w("ok", "wha sound reset mid process");

				// recordService.sendEmptyMessageDelayed(2, 1880);// u8 = null;
				return;
			}

			u8.setOutputFile(vsvfiles[vsv]);
			try {
				u8.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			} catch (IllegalStateException eb) {
				Log.i("ok", "AUDIO " + eb.getLocalizedMessage());
				return;
			}
			// u8.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);

			recordServicee.sendEmptyMessageDelayed(2, 20);

		}
	};
	private Handler recordServicee = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service e " + msg.what);
			try {
				u8.stop();
			} catch (RuntimeException e2) {
				Log.w("ok", "wha n" + e2.getLocalizedMessage());
				// } catch (IllegalStateException e5) {
				// Log.w("ok", "wha c" + e5.getLocalizedMessage());
			}

			try {
				Log.i("ok", " DIAGNOSE (" + u8.getMaxAmplitude() + ")");

				u8.notifyAll();
				u8.prepare();
				u8.start();
				// if (ipb != null) {
				// ipb.setImageResource(R.drawable.pbl);
				// }

			} catch (IllegalStateException e) {
				Log.w("ok", "wha " + e.getLocalizedMessage());

				// recordService.sendEmptyMessageDelayed(2, 1880);// u8 = null;
				return;
			} catch (RuntimeException e) {
				Log.w("ok", "wha " + e.getLocalizedMessage());
				// if (u8 != null) {
				// u8.release();
				// }
				// u8 = null;

				// recordService.sendEmptyMessageDelayed(2, 1880);
				return;
			} catch (IOException e) {
				// e.printStackTrace();
				Log.w("ok", "IO Exception: " + e.getLocalizedMessage());
				// Toast.makeText(ctx, "Error\n" + e.getLocalizedMessage(),
				// 1880)
				// .show();

				// recordService.sendEmptyMessageDelayed(2, 1880);// u8 = null;
				return;
			}

			recordServicef.sendEmptyMessageDelayed(2, 20);

		}
	};
	private Handler recordServicef = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              record service f " + msg.what);

			Cursor bi = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://com.docchomps.ok/moment"),
					new String[] { "count(*)" }, "created > '"
							+ datetime(System.currentTimeMillis() - 5 * 60000)
							+ "'", null, null);
			if (bi != null && bi.moveToFirst()) {
				int cc = bi.getInt(0);
				Log.i("ok", "99.99999999             found " + cc
						+ " moments records");

				if (cc == 0) {
					for (int u9 = 1; u9 <= 5 && vsvfiles[u9] != null; u9++) {
						File file = new File(vsvfiles[u9]);
						if (file.exists()) {
							int dgg = (int) (System.currentTimeMillis() - file
									.lastModified());
							if (dgg < 40000) {
								Log.i("ok",
										"99.99999999                 removing "
												+ file.getAbsolutePath());
								file.delete();
							}
						}
						file = null;
					}
				}
			}

			if (bi != null) {
				bi.close();
			}
			bi = null;
			recordService.sendEmptyMessageDelayed(2, 20000);

		}
	};

	private Handler aplace = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                 Location Recording "
					+ msg.what);
			aplace.removeMessages(msg.what);
			Bundle hx = msg.getData();

			// if (smx > 0) {
			// Log.i("ok", "aplace rest");
			// Bundle bl = new Bundle(hx);
			// Message ml = new Message();
			// ml.setData(bl);
			// aplace.sendMessageDelayed(ml, 280);

			// return;
			// }

			Uri xu = Uri.parse(hx.getString("row"));
			ContentValues e = new ContentValues();

			try {
				// Log.i("ok", "goto gpslink b");

				double labb = (double) reg.getFloat("lat", 1f);
				double lobb = (double) reg.getFloat("lon", 1f);
				double ldbb = (double) reg.getFloat("adeep", 1f);
				if (labb != 1 || lobb != 1 || ldbb != 1) {
					Log.i("ok", "aplace using saved location ");
					e.put("lat", labb);
					e.put("lon", lobb);
					e.put("adeep", ldbb);
				}

				if (st4map != null) {
					Log.i("ok", "aplace including amap " + st4map.size());
					e.put("amap", st4map.toByteArray());
				}
			} catch (OutOfMemoryError sf) {
				Log.w("ok", "wha c " + sf.getLocalizedMessage());
			} finally {
				SqliteWrapper.update(ctx, ctx.getContentResolver(),
						Uri.parse("content://com.docchomps.ok/moment"), e,
						"_id=" + xu.getLastPathSegment(), null);

				e = null;
				xu = null;
			}
		}
	};

	private Handler aheard = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                    Media Recording "
					+ msg.what);

			Bundle hx = msg.getData();

			Uri xu = Uri.parse(hx.getString("row"));
			ContentValues e = new ContentValues();
			String ax = "";
			File fileg;
			int c = 1;
			for (c = 0; c < vsvfiles.length; c++) {
				if (vsvfiles[c] == null) {
					continue;
				}
				fileg = new File(vsvfiles[c]);
				if (fileg.exists()) {
					if ((int) (System.currentTimeMillis() - fileg
							.lastModified()) < 5 * 60000) {

						ax += vsvfiles[c] + ",";
					}
				}
			}// 1:11 PM veggie fried rice w/ side shrimp and lobster sauce or
				// sweet and sour pork
			e.put("aheardlist", ax);
			// Log.i("ok", "heard " + ax);
			// monkey("heard " + c);

			ax = null;
			int fvsv = hx.getInt("f");
			try {

				if (fvsv == vsv) {
					fvsv = fvsv > 1 ? fvsv - 1 : 5;
				}

				File file = vsvfiles[fvsv] != null ? new File(vsvfiles[fvsv])
						: null;

				if (packau && file.exists()) {
					int dgg = (int) (System.currentTimeMillis() - file
							.lastModified());

					if (dgg < 60000) {

						FileInputStream fs = null;
						try {
							fs = new FileInputStream(file);

							byte[] bf = new byte[(int) file.length()];
							byte[] b9 = new byte[0];
							byte[] b8 = new byte[0];

							int i = 0;
							int ig = 0;

							while (-1 < fs.read(bf)) {

								b9 = b8;

								b8 = new byte[b9.length + bf.length];
								for (; i < b9.length; i++) {
									b8[i] = b9[i];
								}

								for (; ig < bf.length; ig++) {
									b8[i++] = bf[ig];
								}

							}
							e.put("aback", b8);// "afront"

							b8 = null;
							b9 = null;
							bf = null;

						} catch (FileNotFoundException e2) {
							Log.i("ok", "wha io e 7");
						} catch (IOException e2) {

							Log.i("ok", "wha io e 6");
						}

					}

				}

			} catch (OutOfMemoryError em2) {
				Log.i("ok", "wha io e 8");
			} finally {

				SqliteWrapper.update(ctx, ctx.getContentResolver(),
						Uri.parse("content://com.docchomps.ok/moment"), e,
						"_id=" + xu.getLastPathSegment(), null);
				e = null;
				xu = null;

			}

		}
	};
	// * *********************************/
	public Handler dingoSparkToggle = new Handler() {
		public void handleMessage(Message msg) {// msg.what
			// XXX
			Log.i("ok", "99.9999                          draw sparkMark "
					+ msg.what);
			dingoSparkInactive.removeMessages(2);
			dingoSparkActive.removeMessages(2);

			if (asparks[aspark] == 0) {
				Log.i("ok",
						"99.9999              ASPARK                                  ASPARK");
				asparkr = new RelativeLayout(ctx);
				RelativeLayout.LayoutParams d7 = new RelativeLayout.LayoutParams(
						-1, -1);

				asparkr.setLayoutParams(d7);
				d7 = null;
				while (findViewById(++hid) != null) {
				}
				asparks[aspark] = hid;
				asparkr.setId(asparks[aspark]);
				// asparkr.setBackgroundResource(R.drawable.snano);
				boomBoard.addView(asparkr);

			}

			Log.i("ok", "99.9999                        toggle sparkMark "
					+ nanoactive);

			if (!nanoactive) {
				// nanoactive = true;
				dingoSparkActive.sendEmptyMessageDelayed(2, 10);
			} else if (nanoactive) {
				// msg.what = 3;
				// nanoactive = false;
				dingoSparkInactive.sendEmptyMessageDelayed(2, 10);
			}

			return;
		}
	};
	public Handler dingoSparkInactive = new Handler() {
		Animation ao5;

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                   SPARK OFF " + msg.what);
			dingoSparkInactive.removeMessages(msg.what);

			if (pbjj > SystemClock.uptimeMillis() || (!nanoactive && pbjj > 1)) {
				Log.i("ok",
						"selector off rest "
								+ (pbjj - SystemClock.uptimeMillis()) + " "
								+ nanoactive);
				return;
			}
			if (ao5 == null) {
				ao5 = AnimationUtils.loadAnimation(ctx, R.anim.oomx9);
			}

			pbjj = SystemClock.uptimeMillis() + 1370;
			pbn.bringChildToFront(sparkEasel);
			pbn.bringChildToFront(tips);
			pbn.bringChildToFront(hugis);
			pbn.bringChildToFront(boxerhug);
			boomBoard.startAnimation(ao5);
			boxertit.setFocusable(false);
			boxertit.setEnabled(false);

			// boxerhug.setEnabled(false);
			boomBoard.setVisibility(View.VISIBLE);

			if (!boxerhugaware && boxerhugtt < SystemClock.uptimeMillis()) {
				boxerhug.setVisibility(View.VISIBLE);
				boxerhugaware = true;

				Animation ruu = AnimationUtils
						.loadAnimation(ctx, R.anim.boomp4);
				boxerhug.startAnimation(ruu);
				if (hugis.getVisibility() == View.VISIBLE) {
					Animation ru5 = AnimationUtils.loadAnimation(ctx,
							R.anim.boom4);
					hugis.startAnimation(ru5);
				}
				boxerhugtt = SystemClock.uptimeMillis() + ruu.getDuration()
						+ 100;
			}

			// dingoSparkInactive.sendEmptyMessageDelayed(2, ao5.getDuration());
			// hidetips.sendEmptyMessageDelayed(2, 75);

			nanoactive = false;
			pjsw = 2;

		}
	};

	Handler hidetips = new Handler() {
		public void handleMessage(Message msg) {
			if (tips != null) {
				Animation a4 = AnimationUtils.loadAnimation(ctx, R.anim.oomx13);
				tips.clearAnimation();
				tips.startAnimation(a4);
				hidetipsb.sendEmptyMessageDelayed(2, 1370);
			}
		}
	};

	Handler hidetipsb = new Handler() {
		public void handleMessage(Message msg) {
			tips.setVisibility(View.INVISIBLE);
		}
	};

	public Handler dingoSparkActive = new Handler() {
		// dingoSparkActive.send
		// dingoSparkActive.remove
		Animation anhub4;

		// Dear Cathy, First, thank you for thinking of me. I have been working
		// with Anroid for three years solid. I have published over a hundred
		// applications and developed many unpublished studies. My seventeen
		// year background in Internet age skillset toating wins effecting
		// oodles of people provides guru X2 combo bonuses with tech likes. And
		// I do it with a smile. Or pick me because I score awesomely in
		// comparisons; I encourage fast, reliable, scalable, innovations on
		// time.

		// Dear Maggie, to impress your hire with my three years of Android
		// without a special doubt being layed would be unconciousable. I have
		// seventeen years experience being first among brilliant minds in a
		// career started five years after a computer science college course
		// when I was thirteen. When I put these pieces together it reviels I
		// was Dougie Houser's brother. Walking instead of crawling. Truth be
		// told I struggled in my independence and that continues today where
		// brief moments of happiness exist in our dot world I am so compatible
		// with, what with my adrenaline powered thinking. To feel regular I
		// tend to overshare.
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999           Spark ON 		" + msg.what);

			if (nanoactive) {
				Log.i("ok",
						"selector view rest "
								+ (pbjj - SystemClock.uptimeMillis()) + " "
								+ nanoactive + " " + smx);
				return;
			}

			if (pbjj > SystemClock.uptimeMillis()) {
				Log.i("ok",
						"selector view rest "
								+ (pbjj - SystemClock.uptimeMillis()) + " "
								+ nanoactive + " " + smx);
				dingoSparkActive.sendEmptyMessageDelayed(msg.what, 820);
				return;
			}

			if (anhub4 == null) {
				anhub4 = AnimationUtils.loadAnimation(ctx, R.anim.oomx7);
			}
			// tf"
			// boomBoard =

			// id.alls
			// boomBoard.setBackgroundColor(Color.argb(150, 0, 0, 20));
			boomBoard.setVisibility(View.VISIBLE);
			if (boxerhugaware && boxerhugtt < SystemClock.uptimeMillis()) {

				Animation ruu = AnimationUtils.loadAnimation(ctx, R.anim.boom4);
				boxerhug.startAnimation(ruu);
				Animation ru5 = AnimationUtils.loadAnimation(ctx, R.anim.boom4);
				hugis.startAnimation(ru5);

				boxerhide.sendEmptyMessageDelayed(2, ruu.getDuration());
				boxerhugtt = SystemClock.uptimeMillis() + ruu.getDuration()
						+ 100;
			}

			pbn.bringChildToFront(tips);
			pbn.bringChildToFront(boomBoard);
			// .rotate
			nanoct = 1;
			nanoat = 1;
			boomBoard.setOnTouchListener(dingoSparkUI);
			// pbn.bringChildToFront(sparkEasel);
			pbjj = SystemClock.uptimeMillis() + anhub4.getDuration();
			// anhub4.setStartOffset(200);
			boxertit.setFocusable(true);
			boxertit.setEnabled(true);
			boxertit.setClickable(true);
			// boxerhug.setEnabled(true);

			boomBoard.startAnimation(anhub4);
			nanoactive = true;
			viewapp_map = false;
			// ballson++
			dingoSparkMarks.sendEmptyMessageDelayed(msg.what, 250);

			// anhub4 = null;

			if (tips != null && tips.getVisibility() == View.INVISIBLE
					&& tipscs < SystemClock.uptimeMillis()) {
				tips.setVisibility(View.VISIBLE);
				Animation a4 = AnimationUtils.loadAnimation(ctx, R.anim.oomx12);
				tips.startAnimation(a4);
				tipscs = SystemClock.uptimeMillis() + a4.getDuration();

			}

		}
	};
	public OnTouchListener dingoSparkUI = new OnTouchListener() {

		public boolean onTouch(View av, MotionEvent ae) {
			if (!nanoactive) {
				return false;
			}

			if (ae.getAction() == MotionEvent.ACTION_MOVE) {
				dingoSparkInactive.removeMessages(2);

			} else if (ae.getAction() == MotionEvent.ACTION_DOWN) {
				dingoSparkInactive.removeMessages(2);

				Log.i("ok",
						"nano DOWN                  DOWN                       DOWN "
								+ nanod + " (" + ae.getRawX() + ","
								+ ae.getRawY() + ")" + " " + nanoactive);
				// nano.clearAnimation();
				nanox[0] = ae.getRawX();
				nanoy[0] = ae.getRawY();
				nanospark++;
				nanoat = 1;
				nanoct = 1;
				nanod = 0;

				// nanoService.sendEmptyMessageDelayed(3, 2);
				// nanoServiceOff.removeMessages(2);
				// return true;
			} else if (ae.getAction() == MotionEvent.ACTION_UP) {
				dingoSparkInactive.removeMessages(2);

				Log.i("ok",
						"nano UP                 UP                       UP "
								+ nanod + " " + nanoactive);
				dingoSparkInactive.sendEmptyMessageDelayed(2, 1880 * 4);

				// nanoServiceOff.sendEmptyMessageDelayed(2, 1880);

				// return true;
			}

			if (nanoct > nanox.length - 5) {// 911 overflow, nanoService not
											// active
				nanoct = 1;
				nanoat = 1;
			}
			nanox[nanoct] = ae.getRawX();
			nanoy[nanoct] = ae.getRawY();
			nanoct++;
			// ballson++
			if (!nanoactive) {
				return false;
			}

			return true;

		}
	};
	public Handler dingoSparkMarks = new Handler() {
		ImageView j9;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                    SPARK GROUP " + msg.what);
			// boomBoard = bringChild
			// er dingoSparkInactive
			// dingoSparkInactive.sendEmptyMessageDelayed(2, 1880);

			// dingoSparkActive.sendEmptyMessageDelayed(2, 10);
			// boomBoard.setVisibility(View.VISIBLE);
			// pbn.bringChildToFront(boomBoard);

			Cursor bi = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://com.docchomps.ok/refplay"),
					new String[] { "_id", "atref", "attable", "atcolumn",
							"atwidth", "atheight", "atx", "aty" }, "aspark = "
							+ aspark, null, "created desc");
			int shc = 1;
			// + " "
			// + (xuri != null ? "AND atref != "
			// + xuri.getLastPathSegment() : "")

			if (bi != null && bi.moveToFirst()) {
				Log.i("ok", "all items for " + aspark + " at " + bi.getCount());
				// Animation ob = AnimationUtils.loadAnimation(ctx, R.anim.hub);
				for (int i = 0; i < bi.getCount(); i++) {
					bi.moveToPosition(i);

					if (msg.what == 3 && bi.getInt(1) != mngx8) {
						if (reftouiv.containsKey("" + bi.getInt(1) + "-"
								+ aspark)) {
							int v7 = reftouiv.getAsInteger("" + bi.getInt(1)
									+ "-" + aspark);
							j9 = (ImageView) findViewById(v7);
							if (j9 != null) {
								Log.i("ok",
										"                     reshow "
												+ bi.getInt(1) + "-" + aspark);
								j9.setVisibility(View.INVISIBLE);
								j9 = null;
							}

							continue;
						}

					}
					// Blood
					if (msg.what == 2) {

						if (reftouiv.containsKey("" + bi.getInt(1) + "-"
								+ aspark)) {
							int v7 = reftouiv.getAsInteger("" + bi.getInt(1)
									+ "-" + aspark);
							j9 = (ImageView) findViewById(v7);
							if (j9 != null) {
								Log.i("ok",
										"                     reshow "
												+ bi.getInt(1) + "-" + aspark);
								j9.setBackgroundResource(R.drawable.dot);
								j9.setVisibility(View.VISIBLE);
								j9 = null;
								continue;
							}
						}

					}

					Bundle b9 = new Bundle();
					b9.putString("attable", bi.getString(2));
					b9.putString("atcolumn", bi.getString(3));
					b9.putInt("atref", bi.getInt(1));
					b9.putInt("atwidth", bi.getInt(4));
					b9.putInt("atheight", bi.getInt(5));
					b9.putInt("atx", bi.getInt(6));
					b9.putInt("aty", bi.getInt(7));
					b9.putInt("atype", msg.what);
					Message m9 = new Message();
					m9.setData(b9);
					m9.what = shc++;

					sparkMark.sendMessageDelayed(m9, 10);
					b9 = null;
					m9 = null;

				}

				j9 = null;
			} else {
				Log.i("ok", "no items for " + aspark);
			}
			if (bi != null) {

				bi.close();
			}

			bi = null;
			// ImageView uh = new ImageView(ctx);
			// RelativeLayout.LayoutParams d5 = new RelativeLayout.LayoutParams(
			// -1, -1);
			// uh.setLayoutParams(d5);
			// while (findViewById(++hid) != null) {
			// }
			// uh.setId(hid);
			// uh.setScaleType(ScaleType.MATRIX);
			// boomBoard.addView(uh);

		}
	};

	private Handler sparkMark = new Handler() {
		// Animation ob = null;

		public void handleMessage(Message msg) {
			Bundle hx = msg.getData();
			String attable = hx.getString("attable");
			String atcolumn = hx.getString("atcolumn");
			int atref = hx.getInt("atref");
			int atwidth = hx.getInt("atwidth");
			int atheight = hx.getInt("atheight");
			int atx = hx.getInt("atx");
			int aty = hx.getInt("aty");
			Log.i("ok", "99.9999                    SPARK " + atref + " "
					+ attable + " " + atcolumn);

			if (atwidth < 30 || atheight < 30) {
				atwidth = 80;
				atheight = 180;
			}

			if (reftouiv.containsKey("" + atref + "-" + aspark)) {
				int v7 = reftouiv.getAsInteger("" + atref + "-" + aspark);
				ImageView j9 = (ImageView) findViewById(v7);
				if (j9 != null) {
					Log.i("ok", "                     reshow " + atref + "-"
							+ aspark);
					if (j9.getVisibility() == View.INVISIBLE) {
						sparkMarkActive.sendEmptyMessageDelayed(j9.getId(),
								msg.what * 20);
						j9 = null;
					}
					return;
				} else {
					Log.i("ok", "                     target b " + atref + "-"
							+ aspark);
				}
			}

			{// getMinute
				Log.i("ok", "                     show " + atref + "-" + aspark
						+ " " + atcolumn + "(" + attable + ")");

				Bitmap xt = null;
				Bitmap xh = null;// compress for multiple images on
									// screen
									// markService

				Cursor bi = SqliteWrapper.query(ctx, getContentResolver(),
						Uri.parse(attable), new String[] { "_id", atcolumn },
						"_id=" + atref, null, "created desc limit 1");
				/*
				 * The first and only time my ideal romantic situation came into
				 * being found me. We were twenty seven and in love since day
				 * one. Our culture is private for personal matters. Over a
				 * fifty mile city of life and lights we saw in hundreds of
				 * shades from our skyscraper at the marina was our view.
				 * 
				 * And, and how I like to use that word to finish a paragraph
				 * with begining a sentence,
				 */
				if (bi != null && bi.moveToFirst()) {
					byte[] g3;
					g3 = bi.getBlob(1);
					if (g3 == null) {
						Log.w("ok", " slide missing");
						return;
					}
					try {
						xt = BitmapFactory.decodeByteArray(g3, 0, g3.length);
						if (xt != null) {
							xh = Bitmap.createScaledBitmap(xt, atwidth,
									atheight, true);
						}

					} catch (OutOfMemoryError sf) {
						Log.w("ok", "wha xxx");
					}
				}
				if (bi != null) {
					bi.close();
				}

				if (xh != null) {

					Log.i("ok", "                     image " + atref + "-"
							+ aspark + " (" + atwidth + "x" + atheight + ") ");

					ImageView uh = new ImageView(ctx);
					RelativeLayout.LayoutParams d5 = new RelativeLayout.LayoutParams(
							atwidth, atheight);

					d5.setMargins(atx - (atwidth / 2), aty - (atheight / 2), 0,
							0);
					uh.setLayoutParams(d5);

					uh.setAdjustViewBounds(true);
					while (findViewById(++hid) != null) {
					}

					uh.setId(hid);

					uivtoref.put("" + uh.getId() + "-" + aspark, atref);
					reftouiv.put("" + atref + "-" + aspark, uh.getId());
					reftowidth.put("" + atref + "-" + aspark, atwidth);
					reftoheight.put("" + atref + "-" + aspark, atheight);

					uh.setScaleType(ScaleType.FIT_CENTER);
					uh.setImageBitmap(xh);
					uh.setOnTouchListener(markUI);

					int ai = asparks[aspark];
					asparkr = (RelativeLayout) findViewById(ai);
					if (asparkr == null) {
					}

					uh.setVisibility(View.INVISIBLE);

					if (asparkr != null) {
						asparkr.addView(uh);

						if (atref == mngx8) {
							// dingoSparkActive.sendEmptyMessageDelayed(2, 1);
							sparkMarkActive.sendEmptyMessageDelayed(uh.getId(),
									20);
						} else {
							Log.i("ok", "                       build for "
									+ aspark + " " + atref + " (" + mngxu + "="
									+ mngx8 + ")");
						}
					} else {
						Log.i("ok", "         target " + aspark + " " + ai);
					}

					uh = null;
				}

			}

		}
	};
	public Handler sparkMarkActive = new Handler() {
		ImageView uh = null;

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                     smarkMark Active");
			uh = (ImageView) findViewById(msg.what);
			if (uh != null) {
				uh.setOnTouchListener(markUI);
				uh.setVisibility(View.VISIBLE);
				uh = null;
			}

		}
	};
	private OnTouchListener markUI = new OnTouchListener() {
		int ub = 1;

		public boolean onTouch(View av, MotionEvent ae) {
			if (!nanoactive) {
				return false;
			}

			if (ae.getAction() == MotionEvent.ACTION_MOVE) {
				// dingoSparkInactive.sendEmptyMessageDelayed(2, 10);
				// uimv.sendEmptyMessageDelayed(2, 10);

				if (ae.getPointerCount() == 1) {
					uix[uict] = ae.getRawX();
					uiy[uict] = ae.getRawY();
					uict++;
					uix4++;
					ub++;
					if (ub > 15) {
						ub = 1;
						markUIMove.sendEmptyMessageDelayed(-1, 12);
					}
					// Boom Boom
				} else {
					uix[uict] = ae.getRawX();
					uiy[uict] = ae.getRawY();
					uict++;
					uix4++;

					double xx = (double) ((ae.getX(0) > ae.getX(1) ? ae.getX(0)
							- ae.getX(1) : ae.getX(1) - ae.getX(0)));

					double yy = (double) ((ae.getY(0) > ae.getY(1) ? ae.getY(0)
							- ae.getY(1) : ae.getY(1) - ae.getY(0)));

					double uu = Math.sqrt((xx * xx) + (yy * yy));
					if (uu < grow) {
						dhd4w = (int) (dhd4w - (grow / uu) * mwidth / 250);
						dhd4h = (int) (dhd4h - (grow / uu) * mheight / 250);
						dhd4w = dhd4w < mwidth / 8 ? mwidth / 8 : dhd4w;
						dhd4h = dhd4h < mheight / 8 ? mheight / 8 : dhd4h;
					} else {
						dhd4w = (int) (dhd4w + (uu / grow) * mwidth / 250);
						dhd4h = (int) (dhd4h + (uu / grow) * mheight / 250);
						dhd4w = dhd4w > mwidth ? mwidth : dhd4w;
						dhd4h = dhd4h > mheight ? mheight : dhd4h;
					}

					// Log.i("ok", "resize " + dhd4w + "," + dhd4h);
					if (uict == 8) {
						markUIMove.sendEmptyMessageDelayed(-1, 12);
					}

				}
			} else if (ae.getAction() == MotionEvent.ACTION_DOWN) {

				dingoSparkInactive.removeMessages(2);
				ImageView i8 = (ImageView) av;
				i8.clearAnimation();
				// i8.setBackgroundColor(Color.argb(30, 5, 12, 180));
				i8.setBackgroundResource(R.drawable.deep6);
				// i8.setBackgroundResource(R.drawable.snano);
				markUIOn.sendEmptyMessageDelayed(av.getId(), 2);

				mark = av.getId();
				// int atref = uivtoref.getAsInteger("" + av.getId() + "-"
				// + aspark);
				boomBoard.bringChildToFront(i8);
			} else if (ae.getAction() == MotionEvent.ACTION_UP) {
				dingoSparkInactive.removeMessages(2);
				ImageView i8 = (ImageView) av;

				// if (uivtoref.containsKey("" + av.getId() + "-" + aspark)) {
				i8.setBackgroundResource(R.drawable.dot);
				// } else {
				// i8.setBackgroundResource(R.drawable.deep6);
				// }
				// i8.setBackgroundColor(Color.argb(0, 5, 12, 180));
				markUIUp.sendEmptyMessageDelayed(2, 2);
				dingoSparkInactive.sendEmptyMessageDelayed(2, 1880);

			} else if (ae.getAction() == MotionEvent.ACTION_POINTER_2_DOWN) {

				double xx = (double) ((ae.getX(0) > ae.getX(1) ? ae.getX(0)
						- ae.getX(1) : ae.getX(1) - ae.getX(0)));

				double yy = (double) ((ae.getY(0) > ae.getY(1) ? ae.getY(0)
						- ae.getY(1) : ae.getY(1) - ae.getY(0)));

				grow = Math.sqrt((xx * xx) + (yy * yy));

				// Log.i("ok",
				// "dual on (" + grow + ") " + ae.getX(0) + "," + ae.getY(0)
				// + " to  " + ae.getX(1) + "," + ae.getY(1)
				// + " (" + xx + "," + yy + ")");

			} else if (ae.getAction() == MotionEvent.ACTION_POINTER_2_UP) {

				if (uivtoref.containsKey("" + av.getId() + "-" + aspark)) {
					int atref = uivtoref.getAsInteger("" + av.getId() + "-"
							+ aspark);
					reftowidth.put("" + atref + "-" + aspark, dhd4w);
					reftoheight.put("" + atref + "-" + aspark, dhd4h);
				} else {

				}
			}

			return true;
		}
	};
	private Handler markUIMove = new Handler() {
		// pukdate
		int aspeed = 1000 / 64;
		int avisit = 32 * 3;
		int cn = 1;
		int rcn = 1;

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999              markService UI Move " + uiat
					+ "/" + uict + " " + uix4);
			// Boom Boom
			if (uix4 < 5) {
				return;
			}

			if (uimvr != null) {
				// if (uiat < uict) {
				// uiat++;
				// }

				RelativeLayout.LayoutParams v5 = new RelativeLayout.LayoutParams(
						dhd4w, dhd4h);

				for (; uiat < uict; uiat++) {
					v5.setMargins((int) (uix[uiat] - (dhd4w / 2)),
							(int) (uiy[uiat] - (dhd4h / 2)), 0, 0);
					uimvr.setLayoutParams(v5);
					rcn++;
				}
				// uimvr =

				if (uict > uix.length - (uix.length / 5)) {
					uict = 1;
					uiat = 1;
				}

				if (msg.what < 0) {
					uimvr.postInvalidate();
					return;
				}

				// selector view rest
				if (cn < avisit) {
					cn++;
					markUIMove.sendEmptyMessageDelayed(2, aspeed);
				} else {
					// dingoSparkInactive.removeMessages(2);
					// dingoSparkInactive.sendEmptyMessageDelayed(2, 1880 * 2);
					// if (uict > 100) {
					// uict = 1;
					// uiat = 1;
					// }
					// selector off
					if (rcn > 1) {
						markUIMove.sendEmptyMessageDelayed(2, aspeed);
					}
					rcn = 1;
					cn = 1;
				}
				// 2492

			}

		}
	};

	private Handler markUIOn = new Handler() {

		public void handleMessage(Message msg) {

			try {

				uimvr = (ImageView) findViewById(msg.what);
				if (uimvr != null) {
					if (uivtoref.containsKey("" + msg.what + "-" + aspark)) {
						mngxu = uivtoref.getAsInteger("" + msg.what + "-"
								+ aspark);
						// } else if (uivtoref != null) {
						// mngxu = uivtoref.getAsInteger("" + msg.what);
					}

				} else {
					Log.w("ok", "wha image d");
				}

			} catch (ClassCastException eu) {
				Log.w("ok", "wha image");
			}

			if (uimvr != null) {

				if (!reftowidth.containsKey("" + mngxu + "-" + aspark)) {
					dhd4w = dcelw;
					dhd4h = dcelh;
				} else {
					dhd4w = reftowidth.getAsInteger("" + mngxu + "-" + aspark);
					dhd4h = reftoheight.getAsInteger("" + mngxu + "-" + aspark);
				}
				RelativeLayout.LayoutParams v = new RelativeLayout.LayoutParams(
						dhd4w, dhd4h);
				for (; uiat < uict; uiat++) {
					v.setMargins((int) (uix[uiat] - (dhd4w / 2)),
							(int) (uiy[uiat] - (dhd4h / 2)), 0, 0);
					uimvr.setLayoutParams(v);
				}
				uimvr.clearAnimation();

				markUIMove.sendEmptyMessageDelayed(2, 2);
				uics = SystemClock.uptimeMillis();

			} else {
				Log.i("ok", "wha image b");
			}

			// dingoSparkToggle.sendEmptyMessageDelayed(1, 200);

		}
	};
	private Handler markUIUp = new Handler() {
		public void handleMessage(Message msg) {
			markUIMove.removeMessages(2);

			if (uimvr != null && uix4 > 0) {
				Log.i("ok",
						"update size(" + uimvr.getWidth() + "x"
								+ uimvr.getHeight() + ") location("
								+ uix[uict - 1] + "," + uiy[uict - 1] + "x"
								+ aspark + ") of " + mngxu);

				{
					ContentValues uq = new ContentValues();
					uq.put("aspark", aspark);
					uq.put("atwidth", dhd4w);
					uq.put("atheight", dhd4h);
					uq.put("atx", (int) uix[uict - 1]);
					uq.put("aty", (int) uiy[uict - 1]);

					SqliteWrapper.update(ctx, getContentResolver(),
							Uri.parse("content://com.docchomps.ok/refplay"),
							uq, "atref=" + mngxu + " AND aspark = " + aspark,
							null);
					uq = null;
				}

				RelativeLayout px = (RelativeLayout) uimvr.getParent();
				if (px != null) {
					if (px.getId() == sparkEasel.getId()) {
						Log.i("ok", "d              drawn");
						uimvr.setVisibility(View.INVISIBLE);
						int ui8 = 1;
						if (reftouiv.containsKey("" + mngxu + "-" + aspark)) {
							ui8 = reftouiv.getAsInteger("" + mngxu + "-"
									+ aspark);
						} else {
							Log.w("ok", "wha " + mngxu + "<=");
						}

						if (ui8 != 1) {
							Log.i("ok", "           here goes ");
							uimvr = (ImageView) findViewById(ui8);
							Animation ob = AnimationUtils.loadAnimation(ctx,
									R.anim.oomx5);
							uimvr.startAnimation(ob);
							ob = null;
							uimvr.setVisibility(View.VISIBLE);
							if (uimvr != null) {
								RelativeLayout.LayoutParams v = new RelativeLayout.LayoutParams(
										dhd4w, dhd4h);
								if (uiat > 1) {
									uiat--;
								}
								for (; uiat < uict; uiat++) {
									v.setMargins(
											(int) (uix[uiat] - (dhd4w / 2)),
											(int) (uiy[uiat] - (dhd4h / 2)), 0,
											0);
									uimvr.setLayoutParams(v);
								}
								v = null;
							}
						}
					} else if (px.getId() == boomBoard.getId()) {
					} else {
						Log.w("ok", "      target k " + px.getId());
					}
				}
				uict = 0;
				uiat = 0;
				uix4 = 0;

			}

			// uimvr = null;
		}
	};
	public Handler markService = new Handler() {
		int b = 1;
		int ki = 1;
		ImageView hj;

		// double xuu = 0;
		// long buics = 1;
		// long bnics = 1;
		// int pxx = 1;
		// int pyy = 1;

		public void handleMessage(Message msg) {

			Log.i("ok", "99.9999                  markService " + smat + ">/"
					+ lsmat);
			if (smx == 0) {
				b = 1;
				pww = 0;
				Log.i("ok",
						"99.9999999999               Smart Mark Drawing Cleared "
								+ msg.what + " (" + tapcn + " " + indrawing
								+ ")");
				smartSparkService.removeMessages(5);
				// SERVICE
				return;
			}
			if (b > 64) {
				markService.removeMessages(2);
				b = 1;
			} else {
				b++;
			}
			// Boom Boom
			try {

				if (!viewapp_map) {
					operationsPunctuation.removeMessages(2);

					if (smww > smct - 8) {// manage to allow ballson
											// increment but
						// no tap image
						return;
					}// gp =
					if (smat == 0) {
						g4f.drawColor(Color.argb(2, 2, 2, 2),
								PorterDuff.Mode.CLEAR);
					}

					// Boom Boom
					for (; smat < smct; smat++) {
						for (ki = 0; ki < smd[smat]; ki++) {
							// if (sm8[smat][ki] > ((mheight - 30) / 8) * 3) {
							// int sy = (int) (((sm8[smat][ki] - ((mheight - 30)
							// /
							// 8) * 3) - 60) / supert9h);
							// int snx = (int) ((sm9[smat][ki] - 15) /
							// supert9w);
							// Log.i("ok", "translate press " + snx + "," + sy
							// + " " + ((snx + 1) * (sy + 1)) + "");
							//
							// tapcn = 1;
							// continue;
							// }

							balls[ballson].drawBitmap(blm[ki],
									(int) (sm9[smat][ki] / 4 - dw / 4 / 2),
									(int) (sm8[smat][ki] / 4 - dh / 4 / 2), gp);

							gxf.drawBitmap(bla[ki],
									(int) (sm9[smat][ki] - dw / 2),
									(int) (sm8[smat][ki] - dh / 2), gp);

							g4f.drawBitmap(bla[ki],
									(int) (sm9[smat][ki] - dw / 2),
									(int) (sm8[smat][ki] - dh / 2), gp);

							gxfx.drawPoint(sm9[smat][ki], sm8[smat][ki], gppb);
							if (smat > 1) {
								gxfx.drawLine((sm9[smat - 1][ki]),
										(int) (sm8[smat - 1][ki]),
										(sm9[smat][ki]), (int) (sm8[smat][ki]),
										gppx);
							}
						}
						oalls0x[ballson][smat] = sm9[smat];
						oalls0y[ballson][smat] = sm8[smat];
						oalls0d[ballson][smat] = smd[smat];
					}

					// over
					// fildash.postInvalidate();
					productiondash.postInvalidate();
					// surfacedash.postInvalidate();
					falls[ballson] = System.currentTimeMillis();
				} else {
					// Log.i("ok",
					// "99.9999                 mark to map service "
					// + smat + " /" + smct);
					for (; smat < smct; smat++) {
						oalls0x[ballson][smat] = sm9[smat];
						oalls0y[ballson][smat] = sm8[smat];
						oalls0d[ballson][smat] = smd[smat];
					}

					// if (smd[smat] == 1 && smat > pww) {
					driftDrive.sendEmptyMessageDelayed(2, 32);
					// }
					// viewLocation
					if (smd[smat] == 2 && smd[pwt] == 1) {
						pwt = smat;
					} else {
						if (smat > pwt + 4) {
							expressLane.sendEmptyMessageDelayed(2, 32);
						}
					}
				}

				if (smct > sm8.length - (sm8.length / 5)) {
					pww = 1;
					pwt = 1;
					smct = 1;
					smat = 1;
				}

			} catch (RuntimeException eb) {
				Log.i("ok",
						"(recycled bla during stocking stuffing) "
								+ eb.getLocalizedMessage());
			}

			if (smat == lsmat) {
				if (ccn > 5) {
					// pww = 0;
					// pwt = 0;
					// smct = 0;
					// smat = 0;
					// smx = 0;
					ccn = 1;
					Log.i("ok", "99.9999           markService service off");
					return;
				}
				ccn++;
			} else {
				ccn = 1;
			}
			lsmat = smat;
			markService.sendEmptyMessageDelayed(2, 1000 / 32);

		}

		int lsmat = 1;
		int ccn = 1;
	};
	public Handler expressLane = new Handler() {
		int xx = 1;
		int yy = 1;
		int xa = 1;
		int ya = 1;

		// MapView xmm;
		// MapController xui;
		double nu = 1;
		double uu = 1;

		long cs = 1;

		public void handleMessage(Message msg) {
			expressLane.removeMessages(2);
			/*
			if (xui == null) {
				xui = xmm.getController();

			}*/

			if (smct == 0 || smd[pwt] != 2 || pwt == smat) {
				if (smd[smat] == 2) {
					pwt = smat;
				}
				return;
			}

			// was
			xx = (int) ((sm9[pwt][0] < sm9[pwt][1] ? sm9[pwt][1] - sm9[pwt][0]
					: sm9[pwt][0] - sm9[pwt][1]));

			yy = (int) ((sm8[pwt][0] < sm8[pwt][1] ? sm8[pwt][1] - sm8[pwt][0]
					: sm8[pwt][0] - sm8[pwt][1]));
			uu = Math.sqrt((xx * xx) + (yy * yy));

			// is
			xa = (int) ((sm9[smat][0] < sm9[smat][1] ? sm9[smat][1]
					- sm9[smat][0] : sm9[smat][0] - sm9[smat][1]));

			ya = (int) ((sm8[smat][0] < sm8[smat][1] ? sm8[smat][1]
					- sm8[smat][0] : sm8[smat][0] - sm8[smat][1]));
			nu = Math.sqrt((xa * xa) + (ya * ya));

			// Math.sqrt Haven >?:

			if ((int) nu != (int) uu) {
				try {

					if (cs < SystemClock.uptimeMillis()) {

						if (nu < uu && nu < uu - 2f) {
							Log.i("ok", "99.9999             strech on " + uu
									+ " to " + nu + " -(" + (uu - nu) + ")");
									/*
							xui.zoomOut();
							*/
							cs = SystemClock.uptimeMillis() + 1000 / 3;
							pwt = smat;
							refreshAnalyze.removeMessages(4);
							refreshAnalyze.sendEmptyMessageDelayed(4, 1880 * 2);

						} else if (nu > uu && nu > uu + 2f) {
							Log.i("ok", "99.9999             strech in " + uu
									+ " to " + nu + " +(" + (nu - uu) + ")");
									/*
							xui.zoomIn();
							*/
							cs = SystemClock.uptimeMillis() + 1000 / 3;
							pwt = smat;
							refreshAnalyze.removeMessages(4);
							refreshAnalyze.sendEmptyMessageDelayed(4, 1880 * 2);

						}

						// belayGetScanLocation.removeMessages(4);
						// belayGetScanLocation.sendEmptyMessageDelayed(4, 120);
						// getScanLocation.sendEmptyMessageDelayed(4, 10);

					} else {
						Log.i("ok", "99.9999               strech bypass");
					}

				} catch (OutOfMemoryError eg) {

					{
						Bundle b8 = new Bundle();
						b8.putString("content", "Map API Memory Issue b");
						Message m8 = new Message();
						m8.setData(b8);
						ddpuk.sendMessageDelayed(m8, 10);
						m8 = null;
						b8 = null;
					}

				}

			}

		}
	};
	public Handler driftDrive = new Handler() {
		int xx = 1;
		int yy = 1;
		int cc = 1;
		int gx = 1;
		int gy = 1;
		int jx = 1;
		int jy = 1;

		// MapView xmm;
		// MapController xui;

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                driftDrive " + msg.what + " "
					+ pww + "/" + smat + " " + cc);
/*
			if (xui == null) {
				// xmm = (MapView) findViewById(R.id.cmapb);
				xui = xmm.getController();
				// xmm = null;
			}*/

			driftDrive.removeMessages(msg.what);
			if (smct == 0 || pww == smat) {
				return;
			}
			// setZoom
			// xx = (int) (sm9[pww][0] - sm9[smat][0]);
			// yy = (int) (sm8[pww][0] - sm8[smat][0]);
			// pww = smat;

			try {

				for (pww++; pww < smat; pww++) {
					if (xx != (int) sm9[pww][0] || yy != (int) sm8[pww][0]) {
						if (sm9[pww][0] > 0 && sm8[pww][0] > 0) {

							xx = (int) sm9[pww][0];
							yy = (int) sm8[pww][0];
							gx = (int) (sm9[pww - 1][0] < xx ? (sm9[pww - 1][0] - xx)
									: (xx - sm9[pww - 1][0]) * -1);
							gy = (int) (sm8[pww - 1][0] < yy ? (sm8[pww - 1][0] - yy)
									: (yy - sm8[pww - 1][0]) * -1);

							if ((jx > gx ? jx - gx : gx - jx) > 5
									|| (jy > gy ? jy - gy : gy - jy) > 5) {
								jx = gx;
								jy = gy;
								cc = 1;
								/*
								xui.scrollBy(gx, gy);
								*/
								break;
							}
						}
						// xui.scrollBy((int) sm9[pww][0], (int) sm8[pww][0]);
					}
				}

				if (pww + 1 < smat && cc < 20) {
					cc++;
					driftDrive.sendEmptyMessageDelayed(2, 32);
					// xmm.postInvalidate();
					// viewLocation.removeMessages(2);
					if (cc > 2) {
						viewLocation.sendEmptyMessageDelayed(2, 75);
					}
					// getScanLocation
				}
			} catch (OutOfMemoryError eg) {

				{
					Bundle b8 = new Bundle();
					b8.putString("content", "Map API Memory Issue c");
					Message m8 = new Message();
					m8.setData(b8);
					ddpuk.sendMessageDelayed(m8, 10);
					m8 = null;
					b8 = null;
				}

			}

			// distinct a
			// stored dn =
			// xmm.postInvalidate();

			// xmm.computeScroll();
			// xmmbb.postInvalidate();

			// refreshAnalyze.removeMessages(4);
			// refreshAnalyze.sendEmptyMessageDelayed(4, 1880 * 2);
			// tapcn == 3
			// Log.i("ok", "99.9999             scroll viewer " + " ("
			// + (sm9[pww - 1][0]) + "," + (sm8[pww - 1][0]) + ") -> ("
			// + (xx) + "," + (yy) + ") " + pww + "/" + smat);

		}

	};
	// * *********************************/
	public Handler smartSpark = new Handler() {
		// Bitmap h1 = null;
		// Bitmap xt2 = null;
		// long cs = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                  establish sparkMark board "
					+ msg.what);

			smartSpark.removeMessages(2);
			try {// smartSpark.send dhd =

				gppb = new android.graphics.Paint();
				gppb.setColor(Color.BLACK);
				gppb.setStrokeWidth(4f);

				gppd5 = null;
				gppd5x = null;

				RelativeLayout.LayoutParams dhdx;
				ImageView hj = null;

				// (boomBoard.getHeight() / nalls.length)
				for (int x = 0; x < nalls.length; x++) {

					// balls[x].drawColor(Color.argb(2, 2, 2, 2),
					// PorterDuff.Mode.CLEAR);
					hj = (ImageView) findViewById(halls[x]);
					if (hj != null) {
						hj.postInvalidate();
					}

				}

				pwt = 0;
				pww = 0;
				smx = 0;
				smct = 0;
				smat = 0;

				if (gpd == null) {
					gpd = Bitmap.createBitmap(pbn.getWidth(), pbn.getHeight(),
							Bitmap.Config.ARGB_8888);
					gxf = new Canvas(gpd);
					g4d = Bitmap.createBitmap(pbn.getWidth(), pbn.getHeight(),
							Bitmap.Config.ARGB_8888);
					g4f = new Canvas(g4d);
					gp = new android.graphics.Paint();
					gp.setAlpha(200);

				} else {
					gxf.drawColor(Color.argb(2, 2, 2, 2), PorterDuff.Mode.CLEAR);
				}

				if (gpdx == null) {
					gpdx = Bitmap.createBitmap(pbn.getWidth(), pbn.getHeight(),
							Bitmap.Config.ARGB_8888);
					gxfx = new Canvas(gpdx);
					gppx = new android.graphics.Paint();
					gppx.setColor(Color.argb(200, 10, 120, 255));
					gppx.setStrokeWidth(2f);
				} else {
					gxfx.drawColor(Color.argb(2, 2, 2, 2),
							PorterDuff.Mode.CLEAR);
				}

				{
					productiondash = new ImageView(ctx);
					dhdx = new RelativeLayout.LayoutParams(-1, -1);
					productiondash.setLayoutParams(dhdx);
					dhdx = null;
					while (findViewById(++hid) != null) {
					}
					productiondash.setId(hid);
					productiondash.setScaleType(ScaleType.MATRIX);
					sparkEasel.addView(productiondash);
				}
				productiondash.setImageBitmap(gpd);

				{
					fildash = new ImageView(ctx);
					dhdx = new RelativeLayout.LayoutParams(boxerfil.getWidth(),
							boxerfil.getHeight());
					dhdx.setMargins(30, 30, 0, 0);
					fildash.setLayoutParams(dhdx);
					dhdx = null;
					while (findViewById(++hid) != null) {
					}
					fildash.setId(hid);
					fildash.setScaleType(ScaleType.FIT_CENTER);
					boomBoard.addView(fildash);
				}
				fildash.setImageBitmap(g4d);

				{
					surfacedash = new ImageView(ctx);
					dhdx = new RelativeLayout.LayoutParams(-1, -1);
					surfacedash.setLayoutParams(dhdx);
					dhdx = null;
					while (findViewById(++hid) != null) {
					}
					surfacedash.setId(hid);
					surfacedash.setScaleType(ScaleType.MATRIX);
					surfacedash.setVisibility(View.INVISIBLE);
					sparkEasel.addView(surfacedash, 0);
				}
				surfacedash.setImageBitmap(gpdx);

				// sparksurface.sendEmptyMessageDelayed(2, 2);
				// smartSpark.send xmct = 0

			} catch (NullPointerException em) {
				em.printStackTrace();

			} catch (OutOfMemoryError em) {
				// gpd = null;
				// gxf = null;
				Log.w("ok", "OOM wha " + em.getLocalizedMessage());
				return;
				// em.printStackTrace();
			} finally {

			}

		}
	};

	public Handler scheduleOperation = new Handler() {
		public void handleMessage(Message msg) {
			operationsPunctuation.removeMessages(2);
			recordService.removeMessages(2);

			if (nanoactive || viewapp_map) {
				return;
			}

			if (xuri == null || actwin < SystemClock.uptimeMillis()) {
				// stocking awareness
				Log.i("ok", "stocking filling UUUUUUUUUUUUUUU");
				// {
				// Animation oh = AnimationUtils
				// .loadAnimation(ctx, R.anim.oom);
				// ipb.startAnimation(oh);
				// ipbcs = SystemClock.uptimeMillis() + oh.getDuration();
				// oh = null;
				// }

				ContentValues cx = new ContentValues();
				String dn = "Boom";
				if (!cx.containsKey("atitle")) {

					if (geox != null && geox.getAdminArea() != null) {
						if (geox.getLocality() != null) {
							dn = geox.getLocality();
						} else {
							dn = geox.getAdminArea();
						}
					}

					dn = reg.getString("defactoprefacto", dn);
					// dn.length() > 0 ? Uri.encode(dn)
					// : file.exists() ? dn : dn);

					int dnc = (reg.getInt("numerofactodefacto" + dn, 0) + 1);
					edt.putInt("numerofactodefacto" + dn, dnc);
					cx.put("atitle", dn + " " + +dnc);
					dn = null;
				}

				boxertit.setText(cx.getAsString("atitle"));
				// boxerhug.setText(reg.getString("geostory", "comment"));
				xuri = SqliteWrapper.insert(ctx, ctx.getContentResolver(),
						Uri.parse("content://com.docchomps.ok/moment"), cx);

				cx = null;

				edt.putString("row", xuri.toString());
				try {
					edt.commit();
				} catch (OutOfMemoryError sf) {
					Log.w("ok", "wha bb");
				}

				b88 = new Bundle();
				b88.putString("row", xuri.toString());
				m88 = new Message();
				m88.setData(b88);
				m88.what = 2;
			}

			if (b88 != null && xuri != null) {
				Log.i("ok",
						"99.9999            ((((((()))))))         stocking awareness "
								+ (actwin - SystemClock.uptimeMillis() - (msg.what)));

				m88 = new Message();
				m88.setData(b88);
				m88.what = 2;
				operationsPunctuation.sendMessageDelayed(m88, msg.what);
				actwin = SystemClock.uptimeMillis() + msg.what;// ADURATION
				productiondash.postInvalidate();
				// surfacedash.postInvalidate();
			}

		}
	};

	public Handler smartSparkService = new Handler() {
		int ccn = 1;
		ImageView hj;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok",
					"99.9999            ((((((()))))))       SMART SERVICE "
							+ msg.what + "(" + smx + "," + smct + "," + smat
							+ ") " + ccn + " " + viewapp_map);
			smartSparkService.removeMessages(msg.what);
			if (upause) {
				Log.i("ok",
						"99.9999               smart service in active for pause");
				return;
			}

			if (!viewapp_map) {

				if (productiondash != null && surfacedash != null) {
					productiondash.postInvalidate();

					hj = (ImageView) findViewById(halls[ballson]);
					if (hj != null) {
						hj.postInvalidate();
					}
					fildash.postInvalidate();
					// surfacedash.postInvalidate();
				}

				if (smct > 1) {
					operationsPunctuation.removeMessages(2);
					scheduleOperation.sendEmptyMessageDelayed(ADURATION, 1880);
					// sparkMachine.sendEmptyMessageDelayed(2, 1000 / 16);// 4,8
					// too
					ccn = 1;
				} else {
					ccn++;
				}

				if (ccn > 50) {
					Log.i("ok",
							"99.9999            ((((((()))))))       SERVICE REST "
									+ smx);
					return;
				}

				if (smartservicecs2 < SystemClock.uptimeMillis()) {
					// stocking awareness

					if (smx == 0) {
						Log.i("ok",
								"99.9999            +_-^* +_-^* +_-^*           Interaction Awareness off ("
										+ smx + "," + smct + "," + smat + ") "
										+ ccn);
						return;
					}
					// smct = 1
					smartservicecs2 = SystemClock.uptimeMillis() + 880;
					// smartSpark.sendEmptyMessageDelayed(2, 5);
					// xmmishow.sendEmptyMessageDelayed(2, 220);//
					// xmmi.setVisibility(View.VISIBLE);
					operationsPunctuation.removeMessages(2);
					if (gxf != null && bla != null && bla2 != null
							&& productiondash != null && surfacedash != null) {

						Log.i("ok",
								"99.9999            +_-^* +_-^* +_-^*           interaction awareness "
										+ (((SystemClock.uptimeMillis() - smartservicecs2) > 1250 ? (SystemClock
												.uptimeMillis() - smartservicecs2) - 1250
												: (SystemClock.uptimeMillis() - smartservicecs2)))
										+ "par 9999 (" + smx + "," + smct + ","
										+ smat + ") " + ccn);
						markService.sendEmptyMessageDelayed(2, 2);
						return;
					} else {
						Log.i("ok",
								"99.9999            +_-^* -_-^* +_-^*           interaction awareness "
										+ (((SystemClock.uptimeMillis() - smartservicecs2) > 1250 ? (SystemClock
												.uptimeMillis() - smartservicecs2) - 1250
												: (SystemClock.uptimeMillis() - smartservicecs2)))
										+ "par ****************** (" + smx
										+ "," + smct + "," + smat + ") " + ccn);

						smartSpark.sendEmptyMessageDelayed(2, 75);
					}

				}
			} else {
				hideLocation.removeMessages(2);
				hideLocation.sendEmptyMessageDelayed(2, 1880 * 3);

				markService.sendEmptyMessageDelayed(2, 25);
				return;
			}

			smartSparkService.sendEmptyMessageDelayed(5, 1000 / 4);
		}
	};

	// * *********************************/
	Handler hugistext = new Handler() {
		// Typeface c8;

		// float sgg = 1f;
		// TextView lj;
		Animation ao;

		public void handleMessage(Message msg) {
			// hugistext.removeMessages(msg.what);
			hugis.setText(ctt);

			// if (ctt.length() * hugis.getTextSize() * 0.5 > hugis.getWidth())
			// {
			// sgg -= 4f;
			// hugis.setTextSize(sgg);
			// hugis.postInvalidate();
			// }

			// if (ctm.length() > 0) {
			// sgg = 1f;
			// Log.i("ok", "99.9999     ENTER " + ctm);
			// ctm = "";
			// }

			if (losh[msg.what] < SystemClock.uptimeMillis()) {
				TextView lj = (TextView) findViewById(josh[msg.what]);

				if (lj != null) {
					Animation ao = AnimationUtils.loadAnimation(ctx,
							R.anim.hoom);
					boxerhug.bringChildToFront(lj);
					ao.setZAdjustment(Animation.ZORDER_TOP);
					lj.startAnimation(ao);
				}// wh6 supert9
				losh[msg.what] = SystemClock.uptimeMillis() + 271 + 270;

			}

		}
	};
	Handler superhider = new Handler() {
		public void handleMessage(Message msg) {
			Animation ruu = AnimationUtils.loadAnimation(ctx, R.anim.boom4);

			// Unique Distinct Early Setting
			ruu.setStartOffset(180);
			boxerhug.startAnimation(ruu);
			if (hugis.getVisibility() == View.VISIBLE) {
				Animation ru5 = AnimationUtils.loadAnimation(ctx, R.anim.boom4);
				ru5.setStartOffset(180);
				hugis.startAnimation(ru5);
			}
			boxerhide.sendEmptyMessageDelayed(2, ruu.getDuration());
			pbn.bringChildToFront(sparkEasel);
			pbn.bringChildToFront(tips);
			pbn.bringChildToFront(boxerhug);
			// Unique Distinct Early
			sparkEasel.postInvalidate();
			if (productiondash != null) {
				productiondash.postInvalidate();
			}

		}
	};

	public OnTouchListener sparkBoardUI = new OnTouchListener() {
		// XXX
		int ki = 1;
		int smmc = 1;
		int smnt = 1;
		int sny = 1;
		int snx = 1;
		int nxx = 1;
		int xc = 1;
		long hugiscs = 1;

		public boolean onTouch(View mv, MotionEvent mb) {
			// if (action != MotionEvent.ACTION_CANCEL) {
			xc = mb.getAction();
			smd[smct] = mb.getPointerCount();
			for (ki = 0; ki < smd[smct]; ki++) {
				sm9[smct][ki] = mb.getX(ki);
				sm8[smct][ki] = mb.getY(ki);

			}

			if (boxerhugaware) {
				// !viewapp_map && !nanoactive &&
				Log.i("ok", "HUG AWARE " + sm8[smct][0] + " >/ " + supert9top);
				// mwidth - 120
				if (!viewapp_map) {
					if (sm8[smat][0] < 120 && sm9[smat][0] > mwidth - 120) {
						// Unique Distinct Early
						viewapp_map = true;
						viewLocation.sendEmptyMessageDelayed(2, 10);

						boxerhugaware = false;
						boxerhugtt = SystemClock.uptimeMillis() + 1370 + 100;
						superhider.sendEmptyMessageDelayed(2, 75);

						smct++;
						smx++;
						smmc++;

						sparkAction.sendEmptyMessageDelayed(mb.getAction(), 10);
						smartSparkService.sendEmptyMessageDelayed(5, 25);

						return true;
					}
				}
				if (sm8[smct][0] < supert9top) {
					Log.i("ok", "convert to draw mode " + (boxerhugtt) + " ");
					if (boxerhugtt < SystemClock.uptimeMillis()) {
						boxerhugaware = false;
						boxerhugtt = SystemClock.uptimeMillis() + 1370 + 100;
						superhider.sendEmptyMessageDelayed(2, 75);

						smct++;
						smx++;
						smmc++;

						sparkAction.sendEmptyMessageDelayed(mb.getAction(), 10);
						smartSparkService.sendEmptyMessageDelayed(5, 25);

						return true;
					}

				} else if (sm8[smct][0] > supert9top + 55) {

					for (ki = 0; ki < smd[smct]; ki++) {
						if (sm8[smct][ki] > supert9top + 55) {
							sny = (int) ((sm8[smct][ki] - supert9top - 55) / supert9h);
							nxx = ((snx + 1) + 3 * (sny + 0));
							snx = (int) ((sm9[smct][ki] - 15) / supert9w);
							Log.i("ok", "translate press " + snx + "," + sny
									+ " " + nxx + "");
							tapcn = 1;

							if (hugis.getVisibility() == View.INVISIBLE) {
								Animation r8 = AnimationUtils.loadAnimation(
										ctx, R.anim.boomp4);
								hugis.startAnimation(r8);
								hugis.setBackgroundResource(R.drawable.wcc);
								hugis.setVisibility(View.VISIBLE);

								ctt = "";
							} else {
							}

							if (xc == MotionEvent.ACTION_UP) {
								if (nxx == 10) {
									ctt += " ";
								} else if (nxx == 11) {
									ctt += "0";
								} else if (nxx == 12) {
									ctm = ctt;
									ctt = "";
								} else if (nxx == 13) {
									ctt += "  ";
								} else {
									ctt += "" + nxx;
								}
								hugistext.sendEmptyMessageDelayed(nxx, 10);
							}
						}
					}

					return true;
				} else if (sm8[smct][0] > supert9top
						&& sm8[smct][0] < supert9top + 55
						&& hugiscs < SystemClock.uptimeMillis()) {
					Log.i("ok", "Enter Text (" + ctm + ") (" + ctt + ")");

					if (hugis.getVisibility() == View.VISIBLE) {
						Animation r8 = AnimationUtils.loadAnimation(ctx,
								R.anim.hoom);
						hugis.startAnimation(r8);
						hugiscs = SystemClock.uptimeMillis() + r8.getDuration()
								+ 100;
					} else {
						Animation r8 = AnimationUtils.loadAnimation(ctx,
								R.anim.boomp4);
						hugis.startAnimation(r8);
						hugis.setBackgroundResource(R.drawable.wcc);
						hugis.setVisibility(View.VISIBLE);
						hugiscs = SystemClock.uptimeMillis() + r8.getDuration()
								+ 100;
					}
					if (hugis.getText().toString().contentEquals(ctt)) {
						hugis.setTextColor(Color.argb(255, 200, 250, 255));
					} else {
						hugis.setTextColor(Color.argb(255, 255, 255, 255));
					}
					String c = ctt;
					ctt = ctm;
					ctm = c;

					hugis.setText(ctt);
					return true;
				}

			}

			smct++;
			smx++;
			smmc++;

			// for (smnt = 0; smnt < smct; smnt++) {
			// sm8[smnt][0] - ((mheight - 30) / 8) * 3;
			// }

			// scrollBy
			if (xc != MotionEvent.ACTION_MOVE) {

				sparkAction.sendEmptyMessageDelayed(mb.getAction(), 10);
				// smartSparkService.sendEmptyMessageDelayed(5, 75);
				// sparkMachine.sendEmptyMessageDelayed(2, 75);
				if (!viewapp_map) {

					operationsPunctuation.removeMessages(2);
					scheduleOperation.sendEmptyMessageDelayed(ADURATION, 1880);
					// } else {
					// hideLocation.removeMessages(2);
					// hideLocation.sendEmptyMessageDelayed(2, 1880);
				}
			} else {

				if (smmc >= 5) {
					smmc = 1;
					operationsPunctuation.removeMessages(2);
					smartSparkService.sendEmptyMessageDelayed(5, 2);

					// if (viewapp_map) {
					// hideLocation.removeMessages(2);
					// hideLocation.sendEmptyMessageDelayed(2, 1880);
					// }
					if (nanoactive) {
						if (smct > sm8.length - (sm8.length / 5)) {
							pwt = 0;
							pww = 0;
							smct = 1;
							smat = 1;
							Log.i("ok",
									"99.9999           BONUS  CAUGHT OVERFLOW b");
						}

						return false;
					}
				}
			}

			return true;
		}

	};

	private Handler sparkAction = new Handler() {

		public void handleMessage(Message msg) {
			int action = msg.what;

			if (action == MotionEvent.ACTION_DOWN) {
				// hideLocation.removeMessages(2);
				// operationsPunctuation.removeMessages(2);
				sparkBoardOn.sendEmptyMessageDelayed(3, 10);
			} else if (action == MotionEvent.ACTION_UP) {
				// hideLocation.removeMessages(2);
				// operationsPunctuation.removeMessages(2);
				sparkBoardUp.sendEmptyMessageDelayed(4, 10);
			} else if (action == MotionEvent.ACTION_POINTER_2_DOWN) {
			} else if (action == MotionEvent.ACTION_POINTER_2_UP) {
			} else if (action == MotionEvent.ACTION_POINTER_1_DOWN) {
			} else if (action == MotionEvent.ACTION_POINTER_1_UP) {
			} else if (action == MotionEvent.ACTION_POINTER_3_DOWN) {
/*
				if (viewapp_map) {
					switch (xmmstation) {
					case 1:
						xmm.setTraffic(true);
						xmmstation = 5;
						break;
					case 5:
						xmm.setStreetView(true);
						xmmstation = 4;
						break;
					case 4:
						xmm.setSatellite(false);
						xmm.setTraffic(false);
						xmm.setStreetView(true);
						xmmstation = 3;
						break;
					case 3:
						xmm.setSatellite(false);
						xmm.setTraffic(true);
						xmmstation = 2;
						break;
					case 2:
						xmm.setSatellite(true);
						xmmstation = 1;
						break;
					}
				}*/
				// smarttrip.sendEmptyMessageDelayed(2, 10);
			} else if (action == MotionEvent.ACTION_POINTER_3_UP) {
			}
		}
	};
	private Handler sparkBoardOn = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                            SMART ON "
					+ msg.what);
			smww = smct > 0 ? smct - 1 : 0;
			pww = smat;
			pwt = smat;

			if (smat == 0) {

				Log.i("ok",
						"99.9999                          first down _________vvvvvvv******===== "
								+ tapcn + " " + indrawing);

				// markService.sendEmptyMessageDelayed(2, 2);
				smartservicecs2 = SystemClock.uptimeMillis();

			}

			smartSparkService.sendEmptyMessageDelayed(5, 2);

			// if (viewapp_map) {
			// hideLocation.removeMessages(2);
			// hideLocation.sendEmptyMessageDelayed(2, 1880 * 2);
			// }

			// dingoSparkInactive.sendEmptyMessageDelayed(2, 1880);

		}
	};
	private Handler sparkBoardUp = new Handler() {
		Animation a9;
		long tapcs4 = 1;
		ImageView jh;

		// MapView xmm;
		// MapController xui;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                 SMART UP " + msg.what + " "
					+ nanoactive);

			tapClear.removeMessages(2);
			tapClear.sendEmptyMessageDelayed(2, 1880 / 2);

			// Boom Boom
			if (smct - smww < 5) {
				Log.i("ok", "tapflat up _______---------- " + (smct) + " "
						+ tapcn);
				tapcn++;

				if (!viewapp_map) {
					if (sm8[smat][0] < 120 && sm9[smat][0] > mwidth - 120) {
						// Unique Distinct Early
						viewapp_map = true;
						if (boxerhugaware) {
							superhider.sendEmptyMessageDelayed(2, 75);
						}

						viewLocation.sendEmptyMessageDelayed(2, 10);

						return;
					}
				} else {
					if (sm8[smat][0] < 120 && sm9[smat][0] > mwidth - 120) {
						refreshLocation.sendEmptyMessageDelayed(2, 10);
						return;
					}
					if (sm8[smat][0] > mheight - 120
							&& sm9[smat][0] > mwidth - 120) {
						// Unique Distinct Early
						viewapp_map = false;
						hideLocation.sendEmptyMessageDelayed(2, 10);
						return;
					}
				}

				if (!boxerhugaware) {
					if (sm8[smat][0] > mheight - 120 && sm9[smat][0] < 120) {
						if (boxerhugtt < SystemClock.uptimeMillis()) {
							hideLocation.sendEmptyMessageDelayed(2, 10);

							Animation ruu = AnimationUtils.loadAnimation(ctx,
									R.anim.boomp4);
							boxerhug.startAnimation(ruu);
							boxerhug.setVisibility(View.VISIBLE);
							boxerhugaware = true;

							hugis.setVisibility(View.INVISIBLE);
							boxerhugtt = SystemClock.uptimeMillis()
									+ ruu.getDuration();
							tapcn = 1;
							// operationsPunctuation.removeMessages(2);
							// scheduleOperation.sendEmptyMessageDelayed(
							// ADURATION, 1880);
							return;
						}
					}

				} else {
					if (sm8[smat][0] > mheight - 120
							&& sm9[smat][0] > mwidth - 120) {
						if (boxerhugtt < SystemClock.uptimeMillis()) {
							boxerhugaware = false;
							boxerhugtt = SystemClock.uptimeMillis() + 1370 + 100;
							superhider.sendEmptyMessageDelayed(2, 75);
							return;
						}
					}
				}

				// scheduleOperation.sendEmptyMessageDelayed(75, ADURATION);

			} else {
				Log.i("ok", "draw up ~~~~~------- " + smct + " " + tapcn + " ("
						+ smww + " " + smct + " " + smx + ")");
				tapcn = 1;

				if (!viewapp_map) {
					scheduleOperation
							.sendEmptyMessageDelayed(75, ADURATION * 2);
					return;
				} else {
					// return;
				}
			}

			if (viewapp_map) {

				if (tapcn == 3 && tapcs4 < SystemClock.uptimeMillis()) {
					try {
						hideLocation.removeMessages(2);
						hideLocation.sendEmptyMessageDelayed(2, 1880 * 8);
						xuizoomin.sendEmptyMessageDelayed(2, 10);
					} catch (OutOfMemoryError eg) {

						{
							Bundle b8 = new Bundle();
							b8.putString("content", "Map API Memory Issue");
							Message m8 = new Message();
							m8.setData(b8);
							ddpuk.sendMessageDelayed(m8, 10);
							m8 = null;
							b8 = null;
						}

					}
				}
				// if (tapcn > 2 && smct > 1) {

				if (tapcn == 2 && tapcs4 < SystemClock.uptimeMillis()
						&& smx < 10) {
					hideLocation.removeMessages(2);
					hideLocation.sendEmptyMessageDelayed(2, 1880 * 8);
/*
					if (xui == null) {
						xui = xmm.getController();
					}
*/
					tapcs4 = SystemClock.uptimeMillis() + 880;

					float nx = (sm9[smat][0] < mwidth / 2 ? ((mwidth / 2) - sm9[smat][0])
							* -1
							: sm9[smat][0] - (mwidth / 2));
					float ny = (sm8[smat][0] < mheight / 2 ? ((mheight / 2) - sm8[smat][0])
							* -1
							: sm8[smat][0] - (mheight / 2));
							/*
					xui.scrollBy((int) nx, (int) ny);*/

					// refreshAnalyze.removeMessages(4);
					// refreshAnalyze.sendEmptyMessageDelayed(4, 1000);
/*
					GeoPoint rc = xmm.getMapCenter();
					Log.i("ok",
							" single tap relocate study " + rc.getLatitudeE6()
									+ "," + rc.getLongitudeE6() + " "
									+ (xmm.getLatitudeSpan() * (0.5f)) + ","
									+ (xmm.getLongitudeSpan() * (0.5f)) + " ("
									+ sm9[smat][0] + "," + sm8[smat][0] + ") ("
									+ nx + ") (" + ny + ")");
*/
				}

			} else

			if (!nanoactive) {
				if (tapcn == 3) {
					Log.i("ok", "99.9999              activeate nano ("
							+ sm9[smww][0] + "," + sm8[smww][0] + ")");
					// nanoactive = true;
					dingoSparkActive.sendEmptyMessageDelayed(2, 10);
				}

				if (smx > 10) {
					scheduleOperation.sendEmptyMessageDelayed(75, 10);
				} else {

					if (productiondash != null) {
						Animation oh = AnimationUtils.loadAnimation(ctx,
								R.anim.oomx5);// oomx8
						productiondash.startAnimation(oh);
						hiscave.sendEmptyMessageDelayed(productiondash.getId(),
								oh.getDuration());
						oh = null;
					}

					if (surfacedash != null) {
						Animation oh5 = AnimationUtils.loadAnimation(ctx,
								R.anim.oomx5);
						surfacedash.startAnimation(oh5);
						hiscave.sendEmptyMessageDelayed(surfacedash.getId(),
								oh5.getDuration());
						oh5 = null;
					}

					// if (ipb != null && ipbcs < SystemClock.uptimeMillis()) {
					// Animation o9 = AnimationUtils.loadAnimation(ctx,
					// R.anim.oobs);
					// ipb.startAnimation(o9);
					// ipbcs = SystemClock.uptimeMillis() + o9.getDuration();
					// o9 = null;
					// }

					smartSparkService.removeMessages(5);

					smartSpark.removeMessages(2);
					smartSpark.sendEmptyMessageDelayed(2, 10);
					ballson++;
					if (ballson >= falls.length) {
						ballson = 0;
					}
					ballsdeep.sendEmptyMessageDelayed(2, 10);
					ballsService.sendEmptyMessageDelayed(2, 100);

				}

			}

		}
	};

	// drawslice
	// operationsPunctuation.removeMessages(2);
	// sparkMachine.removeMessages(2);

	// smx = 0;
	// smat = 0;
	// smct = 0;

	// dingoSparkActive.removeMessages(2);
	// recordService.removeMessages(2);
	// tapcn = 1
	// tapClear.removeMessages(2);
	// tapClear.sendEmptyMessageDelayed(2, 1000);

	// nalls[ballson] = Bitmap.createBitmap(gpd);

	// falls[ballson] = System.currentTimeMillis();
	// balls[ballson].drawColor(Color.argb(2, 2, 2, 2),
	// PorterDuff.Mode.CLEAR);
	// balls[ballson].drawBitmap(gpd, 0, 0, gp);

	// drawLine
	// hj = (ImageView) findViewById(halls[ballson]);
	// hj.postInvalidate();

	// gxf = null;
	// gpd = null;
	// productiondash = null;

	// gxfx = null;
	// gpdx = null;
	// surfacedash = null;

	// vr.rotate
	// draw up

	Handler ballsdeep = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok",
					"99.9999                                     balls proceeding "
							+ ballson);

			ImageView jh;
			if (balls[ballson] != null) {
				balls[ballson].drawColor(Color.argb(2, 2, 2, 2),
						PorterDuff.Mode.CLEAR);
				jh = (ImageView) findViewById(halls[ballson]);
				if (jh != null) {
					jh.setBackgroundResource(R.drawable.deep5);
				}
			}

			if (ballson > 0 && balls[ballson - 1] != null) {
				jh = (ImageView) findViewById(halls[ballson - 1]);
				if (jh != null) {
					jh.setBackgroundResource(R.drawable.dot);// deep6
				}
			}
			if (ballson == 0 && balls[halls.length - 1] != null) {
				jh = (ImageView) findViewById(halls[halls.length - 1]);
				if (jh != null) {
					jh.setBackgroundResource(R.drawable.dot);// deep6
				}
			}
		}
	};

	Handler xuizoomin = new Handler() {
		// MapView xmm;
		// MapController xui;

		public void handleMessage(Message msg) {

			try {
				/*
				if (xui == null) {
					// xmm = (MapView) findViewById(R.id.cmapb);
					xui = xmm.getController();
					// xmm = null;
				}

				if (msg.what > 2) {
					xui.setZoom(msg.what);
				} else {
					xui.zoomIn();
				}*/

			} catch (OutOfMemoryError e9) {
				Log.i("ok", "mem 39 " + e9.getMessage());
			}

		}
	};
	Handler xuizoomout = new Handler() {

		public void handleMessage(Message msg) {
			/*
			if (xui == null) {
				// xmm = (MapView) findViewById(R.id.cmapb);
				xui = xmm.getController();
				// xmm = null;
			}
			xui.setZoom(msg.what);
			*/
		}
	};

	@Override
	protected void onResume() {
		super.onResume();

		// XXX
		Log.i("ok",
				"99.9999               ----------------continue----------------");

		handleResume.sendEmptyMessageDelayed(2, 10);
	}

	public Handler ballsService = new Handler() {
		// ImageView jh;

		public void handleMessage(Message msg) {
			ballsService.removeMessages(2);
			Log.i("ok", "99.9999                BALLS ");

			int useb = 0;
			for (int x = 0; x < nalls.length; x++) {
				if (nalls[x] == null) {
					continue;
				}
				long ax = (System.currentTimeMillis() - falls[x]);
				// Log.i("ok", "Balls                BALLS " + x + " " + ax);

				if (ax < 30000) {
					useb++;
				}
			}

			if (useb > 0) {
				ballsService.sendEmptyMessageDelayed(2, 1000 * 3);
			} else {
				Log.i("ok", "Balls                 BALLS SERVICE OFF");
			}

			// stock
		}
	};

	public Handler tapClear = new Handler() {
		public void handleMessage(Message msg) {
			tapcn = 1;
			tapcs = 1;
			Log.i("ok", "tap clear " + smx + " " + smat + " /" + smct + " ("
					+ pww + ")");

		}
	};

	public Handler ddpuk = new Handler() {

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.999999               DD PUK " + msg.what);

			if (!indrawing) {
				return;
			}

			Bundle hx = msg.getData();
			int du = hx.getInt("duration", ADURATION);
			String[] gs = hx.getStringArray("contentlist");
			String gg = hx.getString("content");
			if (gs == null) {
				gs = new String[] { "", (gg != null ? gg : "") };
			}
			if (gs.length == 1) {
				gs = new String[] { gs[0], "" };
			}
			if (gg == null) {
				gg = "";
			}
			if (gs[0].length() == 0 && gs[1].length() == 0) {
				pukdate.sendEmptyMessageDelayed(2, 2);
				return;
			}

			try {
				LinearLayout ru = null;
				pbn.bringChildToFront(pbrus);

				ru = new LinearLayout(ctx);
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
						-1, -2);
				lp.setMargins((mwidth / 8), 20, (mwidth / 8), (mheight / 8));
				lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
				ru.setOrientation(LinearLayout.VERTICAL);
				ru.setBackgroundResource(R.drawable.ewdate);
				ru.setGravity(Gravity.CENTER);
				ru.setScrollContainer(true);

				ru.setLayoutParams(lp);
				while (findViewById(++hid) != null) {
				}
				ru.setId(hid);
				Animation ruu = AnimationUtils
						.loadAnimation(ctx, R.anim.boomp4);
				ru.startAnimation(ruu);

				ruuoff.sendEmptyMessageDelayed((int) ru.getId(),
						du + ruu.getDuration());
				ruu = null;
				// cspuk = SystemClock.uptimeMillis() + 1370 +
				// ruu.getDuration();
				pbrus.addView(ru);

				if (gs[0].length() > 0) {
					TextView hdday = new TextView(ctx);
					hdday.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
					hdday.setText(gs[0]);
					gg = gs[0];
					hdday.setGravity(Gravity.CENTER);
					hdday.setTextSize(36);
					ru.addView(hdday);
				}

				if (gs[1].length() > 0) {
					TextView hdd = new TextView(ctx);
					hdd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
					hdd.setGravity(Gravity.CENTER);
					gg += (gs[0].length() > 0 ? "\n" : "") + gs[1];
					hdd.setText(gs[1]);
					hdd.setTextSize(21);
					ru.addView(hdd);
				}

				for (int ik = 2; ik < (gs.length < 500 ? gs.length : 500); ik++) {
					TextView hdd = new TextView(ctx);
					hdd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
					// hdd.setGravity(Gravity.LEFT);
					hdd.setText(gs[ik]);
					hdd.setTextSize(18);
					ru.addView(hdd);
					gg += "\n" + gs[ik];
				}
				if (gs.length > 500) {
					Toast.makeText(ctx, "remarkable", ADURATION).show();
					gg += "\n\nremarkable list is larger than 500\n";
				}
				boolean hasButtons = false;
				if (hasButtons) {
					int[] bh = new int[10];
					{
						Button hdd = timebutton("5 m", 0, 5);
						bh[0] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = timebutton("15 m", 0, 15);
						bh[1] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = timebutton("1 h", 1, 0);
						bh[2] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = timebutton("1 m", 0, 1);
						bh[3] = hdd.getId();
						ru.addView(hdd);
					}
					{
						Button hdd = emailbutton("email");
						bh[4] = hdd.getId();
						ru.addView(hdd);
					}
					final int[] fbh = bh;

					ru.setOnTouchListener(new OnTouchListener() {
						int ta = 1;

						public boolean onTouch(View v, MotionEvent n) {
							// Log.i("ok", "touch " + n.getAction());
							// if (n.getAction() == MotionEvent.ACTION_UP) {
							// return true;
							// }

							if (n.getAction() == MotionEvent.ACTION_DOWN) {
								ta++;
								if (ta == 2) {
									// String hk = "";
									for (int i = 0; i < fbh.length; i++) {
										if (fbh[i] != 0) {
											bvis.sendEmptyMessageDelayed(
													fbh[i], 10 + 80 * i);
										}
									}

									ruuoff.removeMessages(v.getId());
									return true;
								}
								if (ta == 3) {
									ruuoff.sendEmptyMessageDelayed(v.getId(),
											10);
									return true;
								}
								ta = 1;
							}
							return false;
						}
					});
				}

			} catch (OutOfMemoryError eg) {
				Log.w("ok", "wha v " + eg.getMessage());
			}

		}

		Button emailbutton(String content) {
			Button hdd = new Button(ctx);
			LinearLayout.LayoutParams hn = new LinearLayout.LayoutParams(-1, -2);
			hdd.setLayoutParams(hn);
			hdd.setPadding(20, 2, 2, 20);
			hdd.setGravity(Gravity.CENTER);
			hdd.setText(content);
			hdd.setTextSize(14);
			while (findViewById(++hid) != null) {
			}
			hdd.setId(hid);
			// final int fhours = hours;
			// final int fmins = mins;

			final String fcontent = content;
			hdd.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Bundle b4 = new Bundle();
					b4.putString("message", fcontent);
					// b4.putInt("hours", fhours);
					// b4.putInt("mins", fmins);
					Message m4 = new Message();
					m4.setData(b4);
					// bclick.sendMessageDelayed(m4, 10);

				}
			});
			hdd.setVisibility(View.GONE);
			return hdd;
		}

		Button timebutton(String content, int hours, int mins) {
			Button hdd = new Button(ctx);
			LinearLayout.LayoutParams hn = new LinearLayout.LayoutParams(-1, -2);
			hdd.setLayoutParams(hn);
			hdd.setPadding(20, 2, 2, 20);
			hdd.setGravity(Gravity.CENTER);
			hdd.setText(content);
			hdd.setTextSize(14);
			while (findViewById(++hid) != null) {
			}
			hdd.setId(hid);
			final int fhours = hours;
			final int fmins = mins;
			final String fcontent = content;
			hdd.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Date v5d = new Date();
					Bundle b4 = new Bundle();
					b4.putString("message", fcontent);
					b4.putInt("hours", v5d.getHours() + fhours);
					b4.putInt("mins", v5d.getMinutes() + fmins);
					Message m4 = new Message();
					m4.setData(b4);
					bclick.sendMessageDelayed(m4, 10);

				}
			});
			hdd.setVisibility(View.GONE);
			return hdd;
		}

	};
	Handler boxerhugoff = new Handler() {
		public void handleMessage(Message msg) {
			if (boxerhugaware && boxerhugtt < SystemClock.uptimeMillis()) {
				Animation ruu = AnimationUtils.loadAnimation(ctx, R.anim.boom4);
				boxerhug.startAnimation(ruu);
				boxerhide.sendEmptyMessageDelayed(2, ruu.getDuration());
				boxerhugtt = SystemClock.uptimeMillis() + ruu.getDuration();
			}
		}
	};
	Handler boxerhugon = new Handler() {
		public void handleMessage(Message msg) {
			if (!boxerhugaware && boxerhugtt < SystemClock.uptimeMillis()) {
				pbn.bringChildToFront(sparkEasel);
				pbn.bringChildToFront(tips);
				pbn.bringChildToFront(hugis);
				pbn.bringChildToFront(boxerhug);

				Animation ruu = AnimationUtils
						.loadAnimation(ctx, R.anim.boomp4);
				boxerhug.startAnimation(ruu);
				boxerhug.setVisibility(View.VISIBLE);
				boxerhugaware = true;

				boxerhugtt = SystemClock.uptimeMillis() + ruu.getDuration();
			}
		}
	};

	private OnSharedPreferenceChangeListener underDingo = new OnSharedPreferenceChangeListener() {

		public void onSharedPreferenceChanged(SharedPreferences c, String b) {
			Log.i("ok", "99.9999                 Preferences Awareness " + b
					+ " " + upause);
			if (upause) {
				reg.unregisterOnSharedPreferenceChangeListener(underDingo);
				return;
			}

			if (b.contentEquals("anetwork")) {
				networkOn.sendEmptyMessageDelayed((int) c.getLong(b, 2), 100);
			} else if (b.contentEquals("lat")
					&& xmmi.getVisibility() == View.INVISIBLE) {
			} else {

			}

		}
	};

	public Handler viewLocation = new Handler() {
		public void handleMessage(Message msg) {
			viewLocation.removeMessages(msg.what);
			if (locpr > SystemClock.uptimeMillis()) {
				return;
			}
			locpr = SystemClock.uptimeMillis() + 1370 + 1770 + 100;

			// cmaprr);
			Bundle b5 = new Bundle();
			/*
			GeoPoint rc = xmm.getMapCenter();
			b5.putFloat("lat", rc.getLatitudeE6() / 1000000f);
			b5.putFloat("lon", rc.getLongitudeE6() / 1000000f);
			*/
			Message m4 = new Message();
			m4.setData(b5);
			m4.what = msg.what;

			if (!viewapp_map || vmp.getVisibility() == View.INVISIBLE) {
				viewapp_map = true;

				if (tips != null && tips.getVisibility() == View.INVISIBLE
						&& tipscs < SystemClock.uptimeMillis()) {
					Animation a4 = AnimationUtils.loadAnimation(ctx,
							R.anim.oomx12);
					tips.setVisibility(View.VISIBLE);
					tips.clearAnimation();
					// a4.setStartOffset(880);
					tips.startAnimation(a4);
					tipscs = SystemClock.uptimeMillis() + a4.getDuration();

				}

				Animation a6 = AnimationUtils
						.loadAnimation(ctx, R.anim.oomx19r);
				xmmi.setVisibility(View.VISIBLE);
				xmmi.startAnimation(a6);
				xmmihide.sendEmptyMessageDelayed(2, 1370 + 1770);

				Animation a8 = AnimationUtils
						.loadAnimation(ctx, R.anim.oomx19r);
				xmmd.setVisibility(View.VISIBLE);
				xmmd.startAnimation(a8);

				vmpshow.sendEmptyMessageDelayed(2, 1370);

			} else {
				vmp.postInvalidate();
			}

			pbn.bringChildToFront(xmmi);
			pbn.bringChildToFront(vmp);
			pbn.bringChildToFront(tips);
			pbn.bringChildToFront(hugis);
			pbn.bringChildToFront(boxerhug);

			getScanLocation.removeMessages(msg.what);
			getScanLocation.sendMessageDelayed(m4, 300);
			refreshAnalyze.removeMessages(4);
			refreshAnalyze.sendEmptyMessageDelayed(4, 1380);
			// getScanLocation.sendEmptyMessageDelayed(2, 75);

			hideLocation.removeMessages(2);
			hideLocation.sendEmptyMessageDelayed(2, 1370 + 1770 + 1880 * 8);

		}
	};
	Handler vmpshow = new Handler() {
		public void handleMessage(Message msg) {
			viewapp_map = true;// principal
			if (vmp.getVisibility() == View.INVISIBLE) {
				Animation a5 = AnimationUtils.loadAnimation(ctx, R.anim.laybop);
				vmp.setVisibility(View.VISIBLE);
				vmp.startAnimation(a5);
			}
		}
	};
	public Handler hideLocation = new Handler() {
		public void handleMessage(Message msg) {
			hideLocation.removeMessages(2);

			if (locpr > SystemClock.uptimeMillis()) {
				return;
			}
			locpr = SystemClock.uptimeMillis() + 380 + 1770 + 100;
			viewapp_map = false;

			pbn.bringChildToFront(sparkEasel);
			pbn.bringChildToFront(tips);

			Animation a5 = AnimationUtils.loadAnimation(ctx, R.anim.laybopb);// laybopb);
			a5.setStartOffset(380);

			vmp.startAnimation(a5);
			xmmi.setVisibility(View.VISIBLE);
			xmmd.setVisibility(View.VISIBLE);
			if (tips != null && tips.getVisibility() == View.VISIBLE) {
				// Animation a4 = AnimationUtils.loadAnimation(ctx,
				// R.anim.oomx13);
				tips.clearAnimation();
				// tips.startAnimation(a4);
				// hidetips.sendEmptyMessageDelayed(2, a4.getDuration());

			}

			// xmmi.setVi
			locationDim.removeMessages(2);
			// locationDim.sendEmptyMessageDelayed(2, 1880 * 2);

			hideLocationb.sendEmptyMessageDelayed(2, 880);
			// xmmi.setVisibility(View.VISIBLE);

			hideLocationc.sendEmptyMessageDelayed(2, 1770);
		}
	};

	public Handler hideLocationb = new Handler() {
		public void handleMessage(Message msg) {

			Animation a6 = AnimationUtils.loadAnimation(ctx, R.anim.oomx19);
			// a6.setStartOffset(880);
			xmmi.clearAnimation();
			xmmi.startAnimation(a6);
			Animation a7 = AnimationUtils.loadAnimation(ctx, R.anim.oomx19);
			// a7.setStartOffset(880);
			xmmd.startAnimation(a7);

			// xmmihide.sendEmptyMessageDelayed(xmmi.getId(),
			// a6.getDuration());

		}
	};

	public Handler hideLocationc = new Handler() {
		public void handleMessage(Message msg) {
			hideLocationb.removeMessages(2);

			vmp.setVisibility(View.INVISIBLE);

		}
	};

	public Handler refreshAnalyze = new Handler() {

		public void handleMessage(Message msg) {
			Log.i("ok", "99.999               refresh ANALYZE");
			refreshAnalyze.removeMessages(msg.what);

			Bundle b5 = new Bundle();
			/*
			GeoPoint rc = xmm.getMapCenter();
			b5.putFloat("lat", rc.getLatitudeE6() / 1000000f);
			b5.putFloat("lon", rc.getLongitudeE6() / 1000000f);
			*/
			Message m4 = new Message();
			m4.setData(b5);
			m4.what = msg.what;

			analyzeLocation.removeMessages(msg.what);
			analyzeLocation.sendMessageDelayed(m4, 10);

		}
	};

	private Handler networkOn = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			{
				Log.i("ok", "99.9999                 neton " + msg.what);

				if (cs < SystemClock.uptimeMillis()) {
					Animation oh = AnimationUtils.loadAnimation(ctx,
							R.anim.onnet);
					// ipb.startAnimation(oh);
					cs = SystemClock.uptimeMillis() + oh.getDuration();

					ImageView ph = new ImageView(ctx);
					while (findViewById(++hid) != null) {
					}
					ph.setId(hid);
					ph.setImageResource(R.drawable.frame);
					ph.setScaleType(ScaleType.FIT_XY);
					Animation waft = AnimationUtils.loadAnimation(ctx,
							R.anim.waft);
					ph.startAnimation(waft);
					waftoff.sendEmptyMessageDelayed(ph.getId(),
							waft.getDuration());

					if (tips != null) {
						if (mwidth > mheight) {
							RelativeLayout.LayoutParams hi = new RelativeLayout.LayoutParams(
									tips.getWidth(), -1);
							ph.setLayoutParams(hi);
							hi = null;
						} else {
							RelativeLayout.LayoutParams hi = new RelativeLayout.LayoutParams(
									-1, tips.getHeight());
							ph.setLayoutParams(hi);
							hi = null;
						}
						// addView(tips
						pbn.addView(ph, 0);
					}

					waft = null;
					ph = null;
					oh = null;
				}
			}

		}
	};

	private Handler waftoff = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                     network on ani off "
					+ msg.what);
			ImageView gu = (ImageView) findViewById(msg.what);
			if (gu != null) {
				gu.setVisibility(View.INVISIBLE);
				pbn.removeView(gu);
				gu = null;
			}

		}
	};

	public Handler refreshLocation = new Handler() {
		// Location l;
		long cv = 1;

		double labb = 1;
		double lobb = 1;
		double ldbb = 1;
		long lebb = 1;

		// MapView xmm;
		// MapController xui;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999           Refresh Location " + msg.what);
			refreshLocation.removeMessages(msg.what);

			if (viewapp_map) {

			}

			if (smx > 0 && !viewapp_map) {
				Log.i("ok", "-slide find rest b");
				return;
			}
			// xmmbb.postInvalidate();

			if (cv < SystemClock.uptimeMillis()) {
				cv = SystemClock.uptimeMillis() + 4000;
				Log.i("ok", "+slide find " + appScanPass);
			} else {
				Log.i("ok", "-slide find rest");
				return;
			}

			Bundle hx = msg.getData();

			labb = (double) hx.getFloat("lat", 1f);
			lobb = (double) hx.getFloat("lon", 1f);
			ldbb = (double) hx.getFloat("adeep", 1f);
			lebb = hx.getLong("adeepset", 1);
			hx = null;
			// Center
			if (labb == 1f && lobb == 1f && ldbb == 1f && lebb == 1) {
				labb = (double) reg.getFloat("lat", 1f);
				lobb = (double) reg.getFloat("lon", 1f);
				ldbb = (double) reg.getFloat("adeep", 1f);
				lebb = reg.getLong("adeepset", 1);
			}

			if (labb == 1f && lobb == 1f && ldbb == 1f && lebb == 1) {
				Log.w("ok", "gps loc ffrrits a");
				return;
			}

			// xmmbb.postInvalidate();
			// getScanLocation.sendEmptyMessageDelayed(2, 20);

			{
				Bundle b8 = new Bundle();
				b8.putFloat("lat", (float) labb);
				b8.putFloat("lon", (float) lobb);
				b8.putFloat("adeep", (float) ldbb);
				b8.putLong("adeepset", lebb);
				Message m8 = new Message();
				m8.setData(b8);
				useLocationHistory.sendMessageDelayed(m8, 10);
				m8 = null;
				b8 = null;
			}

			{
				Bundle b8 = new Bundle();
				b8.putFloat("lat", (float) labb);
				b8.putFloat("lon", (float) lobb);
				// b8.putFloat("adeep", (float) ldbb);
				// b8.putLong("adeepset", lebb);
				Message m8 = new Message();
				m8.setData(b8);
				analyzeLocation.sendMessageDelayed(m8, 120);
				m8 = null;
				b8 = null;
			}

			{

				if (ldbb < 10f) {
					xzoom = 19;
				} else if (ldbb < 50f) {
					xzoom = 19;
				} else if (ldbb < 100f) {
					xzoom = 19;
				} else if (ldbb < 200f) {
					xzoom = 18;
				} else if (ldbb < 300f) {
					xzoom = 18;
				} else if (ldbb < 500f) {
					xzoom = 18;
				} else if (ldbb < 600f) {
					xzoom = 17;
				} else if (ldbb < 700f) {
					xzoom = 17;
				} else if (ldbb > 700f) {
					xzoom = 15;
				}

				int fla = (int) (labb * 1000000);
				int flo = (int) (lobb * 1000000);
				// int fla2 = (int) ((labb) * 1000000) - 2600;
				// int flo2 = (int) ((lobb) * 1000000) - 2600;
/*
				xga = new GeoPoint(fla, flo);
				// xgb = new GeoPoint(fla2, flo2);

				try {
					if (xui == null) {
						// xmm = (MapView) findViewById(R.id.cmapb);
						xui = xmm.getController();
					}

					xui.setZoom(xzoom);
					xui.setCenter(xga);
					xui.animateTo(xga, runxga);
				} catch (OutOfMemoryError eg) {

					{
						Bundle b8 = new Bundle();
						b8.putString("content", "Map API Memory Issue d");
						Message m8 = new Message();
						m8.setData(b8);
						ddpuk.sendMessageDelayed(m8, 10);
						m8 = null;
						b8 = null;
					}

				}
*/
			}
		}
	};

	private Handler useLocationHistory = new Handler() {
		double labb = 1;
		double lobb = 1;
		double ldbb = 1;
		long lebb = 1;

		public void handleMessage(Message msg) {
			Bundle hx = msg.getData();
			labb = (double) hx.getFloat("lat", 1f);
			lobb = (double) hx.getFloat("lon", 1f);
			ldbb = (double) hx.getFloat("adeep", 1f);
			lebb = hx.getLong("adeepset", 1);

			boolean refreshed = false;

			Log.i("ok",
					"99.9999999999999999           Refresh Location: History "
							+ msg.what + " (" + labb + "," + lobb + " " + ldbb
							+ " " + refreshed + ")");
			if (labb == 1f && lobb == 1f && ldbb == 1f) {
				Log.w("ok", "gps loc ffrrits b");

				return;
			}
			Cursor bi = SqliteWrapper
					.query(ctx,
							getContentResolver(),
							Uri.parse("content://com.docchomps.ok/moment"),
							new String[] { "_id", "amap", "lat", "lon", "adeep" },
							"lat > " + (labb - 0.002f) + " AND lat < "
									+ (labb + 0.002f) + " AND " + "lon > "
									+ (lobb - 0.002f) + " AND lon < "
									+ (lobb + 0.002f), null,
							"adeep asc, created desc limit 50");
			Bitmap xt = null;
			byte[] g3;

			// pause survey
			if (bi != null && bi.moveToFirst()) {

				for (int i = 0; i < bi.getCount(); i++) {
					bi.moveToPosition(i);

					if (ldbb <= bi.getInt(4)
							&& lebb > System.currentTimeMillis() - 30000) {
						Log.i("ok", "               slide car better in view");
						continue;
					}

					Log.i("ok",
							"                 slide car " + bi.getCount()
									+ ": " + bi.getFloat(2) + "(" + labb + ") "
									+ bi.getFloat(3) + "(" + lobb + ") "
									+ bi.getInt(4) + "(" + ldbb + ") ");

					try {
						g3 = bi.getBlob(1);
						if (g3 == null) {
							Log.w("ok", " slide car missing");
							continue;
						}

						xt = BitmapFactory.decodeByteArray(g3, 0, g3.length);

					} catch (OutOfMemoryError sf) {
						Log.w("ok", "wha xxx");
					}

					if (xt == null) {
						continue;
					}
					Log.i("ok",
							"99.9999                Location Historical Image");

					// boolean ngr = false;
					int bw = xt.getWidth() / 26;
					int bh = xt.getHeight() / 26;
					// finger up
					int ncc = 0;
					ContentValues chh = new ContentValues();
					for (int o = 1; o < 25; o++) {
						for (int y = 1; y < 26; y++) {
							if (xt.getPixel(bw * y, bh * o) != xt.getPixel(bw
									* y, bh * (o + 1))) {
								chh.put("" + xt.getPixel(bw * y, bh * o), true);
								chh.put("" + xt.getPixel(bw * y, bh * (o + 1)),
										true);
								ncc++;
							}
						}
					}

					Log.i("ok", "99.99999999999        image scan a " + ncc
							+ " / " + ((25 * 26) / 6) + " / " + (25 * 26)
							+ " distinct b " + chh.size());

					if (ncc < (25 * 26) / 8 || chh.size() < 8) {
						Log.i("ok",
								"Location Image Incomplete in storage at row "
										+ bi.getInt(0));
						appScanPass = false;
					} else if (chh.size() > 7) {

						try {
							appScanPass = true;
							if (b4update <= SystemClock.uptimeMillis()) {
								bxx4 = Bitmap.createBitmap(xt);
								locationProcess.sendEmptyMessageDelayed(2, 10);
								// displayLocation.sendEmptyMessageDelayed(3,
								// 10);
							}
						} catch (OutOfMemoryError sf) {
							Log.w("ok", "wha sdfm");
						}

						break;
					} else {
						Log.i("ok",
								"       alert alert image did not pass scan warning notice");
					}

					g3 = null;
					chh = null;

				}

			} else {

				Log.i("ok",
						"                image search empty                ");

				// xmmbb.postInvalidate();
				// getScanLocation.sendEmptyMessageDelayed(2, 10);
			}
			if (bi != null) {
				bi.close();
			}

			xt = null;
			bi = null;

		}
	};

	public Handler getScanLocation = new Handler() {
		// long cs = 1;

		public void handleMessage(Message msg) {
			getScanLocation.removeMessages(msg.what);

			// XXX
			Log.i("ok", "99.9999           Refresh Location: get & scan "
					+ msg.what);
			if (xmmbb.isDrawingCacheEnabled()) {
				xmmbb.postInvalidate();
			} else {
				xmmbb.setDrawingCacheEnabled(true);
			}
			getScanLocationb.sendEmptyMessageDelayed(msg.what, 10);

		}
	};

	private Handler getScanLocationb = new Handler() {
		long cs = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok",
					"99.9999           Refresh Location: get & scan b "
							+ msg.what + "(" + smx + " "
							+ (cs - SystemClock.uptimeMillis()) + ")");

			if (upause) {
				Log.i("ok", "-slide read rest c");
				return;
			}

			if (msg.what != 4 && (smx > 0 && !viewapp_map)) {
				Log.i("ok", "-slide read rest b");
				return;
			}

			// msg.what == 4 || ??getScanLocation.sendEmptyMessageDelayed(4
			if (msg.what == 4 || cs < SystemClock.uptimeMillis()) {
				cs = SystemClock.uptimeMillis() + 880;
				Log.i("ok", "99.9999        +slide read(" + msg.what + ") "
						+ appScanPass);
			} else {
				Log.i("ok", "-slide read rest");
				return;
			}
			// flat up
			getScanLocationPack.sendEmptyMessageDelayed(msg.what, 10);

		}
	};

	private Handler getScanLocationPack = new Handler() {
		public void handleMessage(Message msg) {
			getScanLocationPack.removeMessages(msg.what);

			try {
				// b5 = Bitmap.createBitmap(bxx4);
				st4map = null;
				st4map = new ByteArrayOutputStream();

				if (st4map != null && xmmbb != null) {
					// Bitmap h8 = Bitmap.createBitmap(bxx4);
					xmmbb.getDrawingCache(true).compress(CompressFormat.PNG, 0,
							st4map);

					if (st4map != null
							&& b4update <= SystemClock.uptimeMillis()) {
						bxx4 = BitmapFactory.decodeByteArray(
								st4map.toByteArray(), 0, st4map.size());
						getScanLocationScan.sendEmptyMessageDelayed(msg.what,
								10);
					}
					// "amap"
				}
			} catch (NullPointerException e8) {
				Log.w("ok",
						"probably null drawing cache probably ok "
								+ e8.getMessage());
				return;
			} catch (OutOfMemoryError em) {

				Log.e("ok", "wha image will remain clear " + em.getMessage());
				return;
			} finally {
				// bxx4.recycle();
			}
		}
	};

	private Handler getScanLocationScan = new Handler() {
		public void handleMessage(Message msg) {
			getScanLocationScan.removeMessages(msg.what);

			if (bxx4 == null) {
				Log.w("ok", "99.9999        swap empty b");
				return;
			}
			b4update = SystemClock.uptimeMillis() + 20;

			{
				int bw = bxx4.getWidth() / 26;
				int bh = bxx4.getHeight() / 26;

				// adeep
				int ncc = 0;
				ContentValues chh = new ContentValues();
				for (int o = 1; o < 25; o++) {
					for (int y = 1; y < 26; y++) {
						if (bxx4.getPixel(bw * y, bh * o) != bxx4.getPixel(bw
								* y, (bh * o) + 3)) {
							ncc++;
							chh.put("" + bxx4.getPixel(bw * y, bh * o), true);
							chh.put("" + bxx4.getPixel(bw * y, bh * (o + 1)),
									true);
						}
					}
				}

				Log.i("ok", "99.99999999999        image scan b " + ncc + " / "
						+ ((25 * 26) / 6) + " / " + (25 * 26) + " distinct a "
						+ chh.size());

				if (chh.size() < 8 && msg.what != 4) {

					Bundle b8 = new Bundle();
					b8.putString("content", "Location image incomplete");
					b8.putInt("duration", 1880);
					Message m8 = new Message();
					m8.setData(b8);
					ddpuk.sendMessageDelayed(m8, 10);
					m8 = null;
					b8 = null;
					b4update = SystemClock.uptimeMillis();
					appScanPass = false;
				} else {
					appScanPass = true;
					locationProcess.sendEmptyMessageDelayed(2, 10);
				}
				chh = null;
				// b5 = null;

			}

		}
	};

	public Handler locationProcess = new Handler() {

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                  LOCATION VIEW " + msg.what);

			if (bxx4 == null) {
				Log.w("ok", "99.9999        swap empty c");
				return;
			}

			locationTop.removeMessages(msg.what);
			locationTop.sendEmptyMessageDelayed(msg.what, (1880 / 5) * 1);

			// locationBack.removeMessages(msg.what);
			// locationBack.sendEmptyMessageDelayed(msg.what, (1880 / 5) * 2);

			locationGeo.removeMessages(msg.what);
			locationGeo.sendEmptyMessageDelayed(msg.what, (1880 / 5) * 3);

			locationPageButton.removeMessages(msg.what);
			locationPageButton
					.sendEmptyMessageDelayed(msg.what, (1880 / 5) * 4);

			// displayLocation.sendEmptyMessageDelayed(4, (1880 / 5) * 5);

		}
	};

	private Handler locationTop = new Handler() {

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                  LOCATION VIEW " + msg.what);

			if (bxx4 == null) {
				Log.w("ok", "99.9999        swap empty c");
				return;
			}

			locationTop.removeMessages(2);
			try {
				if (turntop == null) {
					turntop = Bitmap.createBitmap((int) (mwidth),
							(int) (mheight), Bitmap.Config.ARGB_8888);
					vt = new Canvas(turntop);

					Path hbpath = null;
					if (mwidth > mheight) {
						hbpath = new Path();
						hbpath.addCircle((int) ((bxx4.getWidth()) / 2),
								(int) ((bxx4.getHeight()) / 2),
								(int) ((bxx4.getHeight()) / 3),
								Path.Direction.CCW);

					} else {
						hbpath = new Path();
						hbpath.addCircle((int) ((bxx4.getWidth()) / 2),
								(int) ((bxx4.getHeight()) / 2),
								(int) ((bxx4.getWidth()) / 3),
								Path.Direction.CCW);
					}
					if (hbpath != null) {
						vt.clipPath(hbpath);
					}
					xmmi.setVisibility(View.VISIBLE);
					xmmi.setImageBitmap(turntop);

				}

				vt.drawBitmap(bxx4, 0, 0, new Paint());
				xmmi.postInvalidate();
				b4update = SystemClock.uptimeMillis();
				xmmi.setVisibility(View.VISIBLE);

				Animation a5 = AnimationUtils.loadAnimation(ctx, R.anim.laybop);
				xmmi.startAnimation(a5);

				// vt.drawColor(Color.argb(200, 0, 0, 10), PorterDuff.Mode.DST);

				// vt.rotate(atrot, (vt.getWidth() / 2) - 1, (vt.getHeight() /
				// 2) -
				// 2);
				// vt.scale(mwidth * 1.3f, mheight * 1.3f);
			} catch (OutOfMemoryError hm) {
				Log.w("ok", "wha lu " + hm.getMessage());
			}
			// ballson++
		}
	};

	private Handler locationGeo = new Handler() {
		Paint p5, p8;

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                  LOCATION VIEW " + msg.what);

			if (bxx4 == null) {
				Log.w("ok", "99.9999        swap empty c");
				return;
			}

			locationGeo.removeMessages(2);

			try {
				if (turndetail == null) {

					p5 = new android.graphics.Paint();
					p5.setColor(Color.argb(130, 110, 130, 20));
					p5.setStrokeWidth(3f);
					p5.setStyle(Style.FILL_AND_STROKE);

					p8 = new android.graphics.Paint();
					p8.setColor(Color.argb(230, 7, 30, 110));
					p8.setStrokeWidth(1f);
					p8.setStyle(Style.FILL);
					p8.setTextSize(31f);

					turndetail = Bitmap.createBitmap((int) (mwidth),
							(int) (mheight), Bitmap.Config.ARGB_8888);

					vd = new Canvas(turndetail);
					xmmd.setImageBitmap(turndetail);

				}

				vd.drawColor(Color.argb(100, 0, 0, 20), PorterDuff.Mode.CLEAR);

				String gs = pbbxg.getText().toString();
				String[] gls = null;
				if (gs != null && gs.length() > 0) {
					gls = gs.split("\n");
				} else {
					/*
					GeoPoint rc = xmm.getMapCenter();

					if (mwidth > mheight) {
						vd.drawCircle((int) ((mwidth) / 2),
								(int) ((mheight) / 2), 3f, p5);
					} else {
						vd.drawCircle((int) ((mwidth) / 2),
								(int) ((mheight) / 2), 3f, p5);
					}
					gls = new String("" + (rc.getLatitudeE6() / 1000000f)
							+ ", " + (rc.getLongitudeE6() / 1000000f) + "\n"
							+ xmm.getZoomLevel()).split("\n");
					// } else if (reg.contains("geostory")) {
					// gls = reg.getString("geostory").split("\n");
					*/
				}

				if (gls != null) {
					for (int km = 0; km < gls.length; km++) {
						vd.drawTextOnPath(gls[km], hbpathL, (int) (250 * 2.2),
								20 - km * (p8.getTextSize() + 4), p8);
					}
				}

			} catch (OutOfMemoryError sf) {
				Log.w("ok", "wha xxx c");
				b4update = SystemClock.uptimeMillis();
			}

		}
	};

	public Handler locationBack = new Handler() {
		android.graphics.Paint p5, p8, p6;

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999                  LOCATION VIEW b " + msg.what);

			locationBack.removeMessages(2);

			try {

				if (flatbkge == null) {

					p5 = new android.graphics.Paint();
					p5.setColor(Color.argb(130, 110, 130, 20));
					p5.setStrokeWidth(3f);
					p5.setStyle(Style.FILL_AND_STROKE);

					p8 = new android.graphics.Paint();
					p8.setColor(Color.argb(230, 7, 30, 110));
					p8.setStrokeWidth(1f);
					p8.setStyle(Style.FILL);
					p8.setTextSize(31f);

					p6 = new android.graphics.Paint();
					p6.setAlpha(10);

					flatbkge = Bitmap.createBitmap((int) (mwidth),
							(int) (mheight), Bitmap.Config.ARGB_8888);

					vr = new Canvas(flatbkge);

					xmme.setImageBitmap(flatbkge);

				}

				// if (bxx4 != null) {
				// vr.drawColor(Color.argb(200, 0, 0, 20),
				// PorterDuff.Mode.CLEAR);
				// vr.drawBitmap(bxx4, -4, -4, p6);
				// vr.drawBitmap(bxx4, 4, -4, p6);
				// vr.drawBitmap(bxx4, 4, 4, p6);
				// vr.drawBitmap(bxx4, -4, 4, p6);
				// vr.drawBitmap(bxx4, -2, 1, p6);
				// }
				// b4update = SystemClock.uptimeMillis();

			} catch (OutOfMemoryError sf) {
				Log.w("ok", "wha xxx c");
				b4update = SystemClock.uptimeMillis();
			}
		}
	};

	public Handler displayLocation = new Handler() {
		Animation oa = null;
		Animation ob = null;
		Animation ox = null;
		long cs = 1;

		// laycu
		public void handleMessage(Message msg) {
			displayLocation.removeMessages(msg.what);

			Log.i("ok",
					"99.9999              Refresh Location: show it & dim it "
							+ msg.what + " ("
							+ (cs - SystemClock.uptimeMillis()) + ")");
			if (upause) {
				Log.i("ok", "-slide visible rest c");
				return;
			}

			if (msg.what != 4) {
				if (smx > 0 || !viewapp_map) {
					Log.i("ok", "-slide visible rest b");
					return;
				}
				if (!appScanPass && msg.what == 2) {
					return;
				}

				if (cs < SystemClock.uptimeMillis()) {
					cs = SystemClock.uptimeMillis() + oa.getDuration() + 1880;
					// displayLocation.removeMessages(2);
					Log.i("ok", "+slide visible " + msg.what + " "
							+ appScanPass);
				} else {
					Log.i("ok", "-slide visible " + msg.what + " rest");
					return;
				}
			}

			if (oa == null) {
				oa = AnimationUtils.loadAnimation(ctx, R.anim.laybop);
				ob = AnimationUtils.loadAnimation(ctx, R.anim.laybop);
				ox = AnimationUtils.loadAnimation(ctx, R.anim.laybop);
				oa.setStartOffset(250);
				ob.setStartOffset(50);
			}

			// xmmi.clearAnimation();

			if (xmmi.getVisibility() == View.INVISIBLE) {
				// xmmi.setVisibility(View.VISIBLE);
				// xmmi.startAnimation(oa);
			}

			if (xmme.getVisibility() == View.INVISIBLE) {
				xmmd.startAnimation(ox);
				xmme.startAnimation(ob);
				xmme.setVisibility(View.VISIBLE);
				xmmd.setVisibility(View.VISIBLE);
				pbbx.setVisibility(View.VISIBLE);
			}
			viewapp_map = true;

			locationDim.removeMessages(2);
			locationDim.sendEmptyMessageDelayed(2, 19980 + oa.getDuration());

		}
	};

	private Handler locationDim = new Handler() {
		Animation oa = null;
		Animation ob = null;
		Animation ox = null;

		public void handleMessage(Message msg) {

			if (xmme.getVisibility() == View.VISIBLE) {

				if (oa == null) {
					oa = AnimationUtils.loadAnimation(ctx, R.anim.laybopb);
					ob = AnimationUtils.loadAnimation(ctx, R.anim.laybopb);
					ox = AnimationUtils.loadAnimation(ctx, R.anim.laybopb);
					oa.setDuration(1770 + 550);
					ox.setStartOffset(550);
					ob.setStartOffset(550);
				}

				if (xmmi.getVisibility() == View.VISIBLE) {
					xmmi.startAnimation(oa);
				}

				if (xmme.getVisibility() == View.VISIBLE) {
					xmmd.startAnimation(ox);
					xmme.startAnimation(ob);
				}

				locationDimb.sendEmptyMessageDelayed(2, 1770 + 550);
			}

		}
	};
	public Handler xmmihide = new Handler() {
		public void handleMessage(Message msg) {
			xmmi.setVisibility(View.INVISIBLE);
		}
	};
	private Handler locationDimb = new Handler() {
		public void handleMessage(Message msg) {
			viewapp_map = false;
			pbbx.setVisibility(View.INVISIBLE);
			xmmi.setVisibility(View.INVISIBLE);
			xmme.setVisibility(View.INVISIBLE);
			xmmd.setVisibility(View.INVISIBLE);

		}
	};

	Handler gwOn = new Handler() {
		ImageView op;
		RelativeLayout.LayoutParams hb;

		public void handleMessage(Message msg) {
			op = (ImageView) findViewById(msg.what);
			hb = (RelativeLayout.LayoutParams) op.getLayoutParams();
			pbn.bringChildToFront(xmmi);

			xmmi.setLayoutParams(hb);
			// UI Move
			xmmi.setScaleType(ScaleType.FIT_XY);
			xmmi.setVisibility(View.VISIBLE);
			Animation ao5 = AnimationUtils.loadAnimation(ctx, R.anim.expand);
			xmmi.startAnimation(ao5);
			xmmihide.sendEmptyMessageDelayed(xmmi.getId(), ao5.getDuration());

		}
	};

	OnTouchListener gwUI = new OnTouchListener() {
		int ac = 1;

		public boolean onTouch(View av, MotionEvent ge) {
			ac = ge.getAction();

			if (ac == MotionEvent.ACTION_DOWN) {
				gwOn.sendEmptyMessageDelayed(av.getId(), 10);
				return true;
			} else if (ac == MotionEvent.ACTION_CANCEL) {

				return true;
			} else if (ac == MotionEvent.ACTION_UP) {
				if (viewapp_map) {
					viewapp_map = false;
				} else {
					viewapp_map = true;
					viewLocation.sendEmptyMessageDelayed(2, 10);
				}
				return true;
			}
			return false;
		}
	};

	private Handler locationPageButton = new Handler() {
		public void handleMessage(Message msg) {
			locationPageButton.removeMessages(msg.what);
			if (bxx4 == null) {
				Log.w("ok", "-page button wha");
				return;
			}

			try {
				// Bitmap b8 = Bitmap.createBitmap(bxx6);
				// Bitmap b8 = Bitmap.createBitmap(bxx4, (int) (mwidth / 3),
				// (int) (mheight / 3), (int) (mwidth / 3),
				// (int) (mwidth / 3), null, false);
				// b8 = Bitmap.createScaledBitmap(xt, atwidth,
				// atheight, true);

				// Bitmap gh = Bitmap.createBitmap((int) (mwidth / 3),
				// (int) (mwidth / 3), Bitmap.Config.ARGB_8888);
				// gxf = new Canvas(gh);

				int su = (dcelw / 3) < balls[ballson].getWidth() ? balls[ballson]
						.getWidth() : (dcelw / 2);
				// ballson++
				Bitmap h8 = Bitmap.createScaledBitmap(bxx4, su, su, true);

				if (h8 != null) {

					Bitmap h9 = Bitmap.createBitmap(su, su,
							Bitmap.Config.ARGB_8888);
					Canvas g9 = new Canvas(h9);
					{
						Path hp5 = new Path();
						hp5.addCircle((int) (su / 2), (int) (su / 2),
								(int) ((su / 2) - 3), Path.Direction.CCW);
						g9.clipPath(hp5);
						g9.drawBitmap(h8, 0, 0, new Paint());

						Bitmap e8 = BitmapFactory.decodeResource(
								getResources(), R.drawable.overtay60);
						g9.drawBitmap(e8, 0, 0, new Paint());
						// Insanity requires consitant attention to attend
						// expected with historical report of fail trials. Look
						// out scientific community and faith communities alike
						// you both present signs of early intelligence.
						ImageView gw = new ImageView(ctx);
						while (findViewById(++hid) != null) {
						}
						gw.setId(hid);
						RelativeLayout.LayoutParams j9 = new RelativeLayout.LayoutParams(
								su, su);
						j9.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
						// j9.setMargins(30 + 70, 30 + 60, 0, 0);
						j9.setMargins(dcelw - 30, 15, 15, 15);
						gw.setLayoutParams(j9);
						gw.setAdjustViewBounds(true);
						gw.setImageBitmap(h9);
						gw.setScaleType(ScaleType.FIT_XY);
						// boomBoard.addView(gw);
						// gw.setOnTouchListener(gwUI);
					}

					// balls[ballson].drawColor(Color.argb(2, 2, 2, 2),
					// PorterDuff.Mode.CLEAR);

					{
						Path hp5 = new Path();
						hp5.addCircle((int) (balls[ballson].getWidth() / 2),
								(int) (balls[ballson].getHeight() / 2),
								(int) ((balls[ballson].getWidth() / 2) - 3),
								Path.Direction.CCW);
						g9.clipPath(hp5);
						g9.drawBitmap(h8, 0, 0, new Paint());

						balls[ballson].drawBitmap(h9, (int) ((balls[ballson]
								.getWidth() - h9.getWidth()) / 2),
								(int) ((balls[ballson].getHeight() - h9
										.getHeight()) / 2), new Paint());

						smartSparkService.removeMessages(5);

						smartSpark.removeMessages(2);
						smartSpark.sendEmptyMessageDelayed(2, 10);
						// xmmi.set

						ImageView hj = (ImageView) findViewById(halls[ballson]);
						if (hj != null) {
							hj.postInvalidate();
						}
						// hj.setOnTouchListener(gwUI);

						ballson++;
						if (ballson >= falls.length) {
							ballson = 0;
						}
						ballsdeep.sendEmptyMessageDelayed(2, 10);
						ballsService.sendEmptyMessageDelayed(2, 100);
					}

					// pageb.setImageBitmap(h9);
					// pageb.setScaleType(ScaleType.FIT_CENTER);
					// pageb.setPadding(9, 9, 9, 9);

					// b8 = null;
					// v = null;
					// gh = null;
					// hbpath = null;
					// p6 = null;
					h9 = null;
					// g = null;
					// e8 = null;
				}

			} catch (OutOfMemoryError sf) {
				Log.w("ok", "wha xxx");
			}
		}
	};

	private Handler analyzeLocation = new Handler() {
		Geocoder gpsd;
		long cs = 1;

		double labb = 1;
		double lobb = 1;
		double ldbb = 1;

		@SuppressWarnings("unused")
		public void handleMessage(Message msg) {
			Bundle hx = msg.getData();
			labb = (double) hx.getFloat("lat", 1f);
			lobb = (double) hx.getFloat("lon", 1f);
			ldbb = (double) hx.getFloat("adeep", 1f);

			Log.i("ok",
					"99.9999           Refresh Location: geocoder " + msg.what
							+ " (" + smx + " "
							+ (cs - SystemClock.uptimeMillis()) + ")");

			if (msg.what != 4 && (smx > 0 || !viewapp_map)) {
				Log.i("ok", "-slide geocoder rest b");
				return;
			}

			if (cs < SystemClock.uptimeMillis()) {
				cs = SystemClock.uptimeMillis() + 1880;
				analyzeLocation.removeMessages(2);
				Log.i("ok", "+slide geocoder " + appScanPass);
			} else {
				Log.i("ok", "-slide geocoder rest");
				return;
			}

			gpsd = new Geocoder(ctx);
			List<Address> gx = null;
			try {
				gx = gpsd.getFromLocation(labb, lobb, 1);
			} catch (IOException e) {
				pbbx.setVisibility(View.INVISIBLE);
				Log.w("ok", "wha geocoder failure: " + e.getLocalizedMessage());
				return;
				// e.printStackTrace();
			}

			if (gx == null) {
				Log.w("ok", "what is geox");
				return;
			}

			if (gpsla == labb && gpslo == lobb) {
				Log.w("ok", "no gps geocoder needed " + gpsla + " " + gpslo);
				return;
			}

			gpsla = labb;
			gpslo = lobb;
			gpsld = ldbb;

			if (gx != null) {
				for (int i7 = 0; i7 < gx.size(); i7++) {
					geox = gx.get(i7);
					if (geox == null) {
						continue;
					}

					String addr = "";
					for (int b = 0; b < geox.getMaxAddressLineIndex(); b++) {
						if (geox.getAddressLine(b).length() > 0) {
							addr += geox.getAddressLine(b) + "\n";
						}
					}

					String phone = geox.getPhone() != null ? ""
							+ geox.getPhone() + " " : "";

					pbbxg.setTextSize(16);
					pbbxg.setTextColor(Color.argb(250, 30, 30, 5));

					String acontent = "";
					if (phone.length() > 4) {
						acontent += phone + "\n";
					}
					if (addr.length() > 3) {
						acontent += addr;
					}

					if (geox.getUrl() != null) {
						acontent += geox.getUrl() + "\n";
					}

					if (ldbb > 1f) {
						acontent += (int) (ldbb) + "m accuracy\n";
					}
					acontent += "" + labb + ", " + lobb + "\n";

					if (xuri != null && labb == reg.getFloat("lat", 1f)
							&& lobb == reg.getFloat("lon", 1f)) {
						Log.i("ok",
								"99.9999               updating geo content active recording");

						ContentValues gi = new ContentValues();
						// boxerhug.setText(acontent);
						gi.put("acontent", acontent);
						SqliteWrapper.update(ctx, ctx.getContentResolver(),
								Uri.parse("content://com.docchomps.ok/moment"),
								gi, "_id=" + xuri.getLastPathSegment(), null);
						gi = null;
						edt.putString("geostory", acontent);
					}

					pbbxg.setText(acontent);
					// pbbx.setVisibility(View.VISIBLE);

					{
						Bundle b8 = new Bundle();
						b8.putString("content", acontent);
						Message m8 = new Message();
						m8.setData(b8);
						// ddpuk.sendMessageDelayed(m8, 10);
						m8 = null;
						b8 = null;
					}

					edt.commit();

					acontent = null;
					geox = null;

					displayLocation.sendEmptyMessageDelayed(4, 10);

					locationBack.removeMessages(msg.what);
					locationBack.sendEmptyMessageDelayed(msg.what, 75);

					break;
				}

			} else {
				pbbx.setVisibility(View.INVISIBLE);
			}

			gx = null;
			gpsd = null;

		}
	};

	private Handler gpslink = new Handler() {
		double labb = 1;
		double lobb = 1;

		// double ldbb = 1;

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999              global positioning service "
					+ msg.what);

			try {

				labb = (double) reg.getFloat("lat", 1f);
				lobb = (double) reg.getFloat("lon", 1f);
				// ldbb = (double) reg.getFloat("adeep", 1f);

				mLocator = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				if (mLocator != null) {
					Criteria criteria = new Criteria();
					criteria.setAccuracy(Criteria.ACCURACY_COARSE);
					mLocator.requestLocationUpdates(
							mLocator.getBestProvider(criteria, true), 5 * 1000,
							1, mLocationListener, getMainLooper());
					criteria = null;
				}

				if (mLocator != null) {
					Criteria criteria = new Criteria();
					criteria.setAccuracy(Criteria.ACCURACY_FINE);
					mLocator.requestLocationUpdates(
							mLocator.getBestProvider(criteria, true), 5 * 1000,
							1, mFineLocation, getMainLooper());
					criteria = null;
				}

				if (labb == 1f && lobb == 1f && labb == 1f) {
					// LocationManager mkk = (LocationManager)
					// getSystemService(Context.LOCATION_SERVICE);
					Location l = mLocator
							.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					if (l == null) {
						l = mLocator
								.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
					}
					if (l != null) {
						edt.putFloat("lat", (float) l.getLatitude());
						edt.putFloat("lon", (float) l.getLongitude());
						edt.putFloat("adeep", (float) l.getAccuracy());
						edt.putLong("adeepset", System.currentTimeMillis());
						try {
							edt.commit();
						} catch (OutOfMemoryError sf) {
							Log.w("ok", "wha xxx " + sf.getLocalizedMessage());
						}

					}
					l = null;
					// labb = (double) reg.getFloat("lat", 1f);
					// lobb = (double) reg.getFloat("lon", 1f);
					// ldbb = (double) reg.getFloat("adeep", 1f);
					// refreshed = true;
				}//
			} catch (IllegalArgumentException nj) {
				Log.w("ok", "wah " + nj.getLocalizedMessage());
			}
		}
	};

	private LocationListener mFineLocation = new LocationListener() {
		public void onLocationChanged(Location location) {
			if (location != null) {
				SharedPreferences reg = ctx.getSharedPreferences("Preferences",
						Context.MODE_WORLD_WRITEABLE);
				Editor edt = reg.edit();
				double labb = (double) reg.getFloat("lat", 1f);
				double lobb = (double) reg.getFloat("lon", 1f);
				double ldbb = (double) reg.getFloat("adeep", 1f);

				if ((labb != location.getLatitude() && lobb != location
						.getLongitude()) || ldbb < location.getAccuracy()) {
					edt.putFloat("lat", (float) location.getLatitude());
					edt.putFloat("lon", (float) location.getLongitude());
					edt.putFloat("adeep", (float) location.getAccuracy());
					edt.putLong("adeepset", System.currentTimeMillis());
					edt.commit();
				}
				reg = null;
				edt = null;
			}
		}

		public void onProviderDisabled(String provider) {
			Log.w("ok", "GPS FPROVIDER GONE " + provider);
		}

		public void onProviderEnabled(String provider) {
			Log.w("ok", "GPS FPROVIDER HERE " + provider);
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);

			mLocator.requestLocationUpdates(
					mLocator.getBestProvider(criteria, true), 5 * 1000, 1,
					mLocationListener, getMainLooper());
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.w("ok", "GPS PROVIDER STATUS " + provider + " " + status);

		}
	};

	private LocationListener mLocationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			if (location != null) {
				Log.w("ok",
						"GPS Listener " + location.getAltitude() + ","
								+ location.getLatitude() + ","
								+ location.getLongitude() + ","
								+ location.getTime() + ","
								+ location.getAccuracy() + ","
								+ location.getSpeed() + ","
								+ location.getProvider() + "");
				// if (reg == null) {
				SharedPreferences reg = ctx.getSharedPreferences("Preferences",
						Context.MODE_WORLD_WRITEABLE);
				Editor edt = reg.edit();
				// }

				double labb = (double) reg.getFloat("lat", 1f);
				double lobb = (double) reg.getFloat("lon", 1f);
				double ldbb = (double) reg.getFloat("adeep", 1f);

				if ((labb != location.getLatitude() && lobb != location
						.getLongitude()) || ldbb < location.getAccuracy()) {
					edt.putFloat("lat", (float) location.getLatitude());
					edt.putFloat("lon", (float) location.getLongitude());
					edt.putFloat("adeep", (float) location.getAccuracy());
					edt.putLong("adeepset", System.currentTimeMillis());

					try {
						edt.commit();
					} catch (OutOfMemoryError hm) {
						Log.w("ok", "mem bh " + hm.getMessage());
					}
				}
				edt = null;
				reg = null;
				// refreshLocation.sendEmptyMessageDelayed(2, 20);
			}
		}

		public void onProviderDisabled(String provider) {
			Log.w("ok", "GPS PROVIDER GONE " + provider);
		}

		public void onProviderEnabled(String provider) {
			Log.w("ok", "GPS PROVIDER HERE " + provider);
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_COARSE); // Faster,
															// no
															// GPS
															// fix.
			// criteria.setAccuracy(Criteria.ACCURACY_FINE); // More
			// accurate, GPS fix.
			// You can specify the time and distance between
			// location updates.
			// Both are useful for reducing power requirements.
			mLocator.requestLocationUpdates(
					mLocator.getBestProvider(criteria, true), 5 * 1000, 1,
					mLocationListener, getMainLooper());
			criteria = null;
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.w("ok", "GPS PROVIDER STATUS " + provider + " " + status);

		}
	};

	private Handler sensorSurvey = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999                       sensor survey ");

			try {
				som = (SensorManager) ctx.getSystemService(SENSOR_SERVICE);
			} finally {
			}

			List<Sensor> hs = som.getSensorList(Sensor.TYPE_ALL);
			for (int h = 0; h < hs.size(); h++) {
				Sensor uk = hs.get(h);
				som.registerListener(sor, uk, SensorManager.SENSOR_DELAY_GAME);
				Log.i("ok", "survey " + uk.getName() + " " + uk.getType());
				uk = null;
			}
			hs = null;

			// som = null;
			// final Bundle bdl = msg.getData();
			// Log.i("ok", "sensorService good xxxx");

			// if (running) {
			// return;
			// }

			// running = true;
			// Thread tx = new Thread() {
			// boolean mStable = true;
			// int position = 0;
			// float[] lastvalues;
			// long smooth = 34;// long smoothtext = 32;//String cn = "";

			// public void run() {

			// som.registerListener(sor,
			// som.getDefaultSensor(SensorManager.SENSOR_TEMPERATURE),
			// SensorManager.SENSOR_DELAY_GAME);

			// som.registerListener(sor,
			// som.getDefaultSensor(SensorManager.SENSOR_ORIENTATION),
			// SensorManager.SENSOR_DELAY_GAME);

			// }
			// };
			// tx.start();

		}
	};

	private SensorEventListener sor = new SensorEventListener() {

		public void onAccuracyChanged(Sensor arg0, int arg1) {

		}

		public void onSensorChanged(SensorEvent event) {

			{
				Bundle bx = new Bundle();
				bx.putString("provider", event.sensor.getName());
				bx.putInt("accuracy", event.accuracy);
				bx.putFloatArray("values", event.values);
				bx.putInt("hw", event.sensor.getType());
				Message ml = new Message();
				ml.setData(bx);
				sori.sendMessageDelayed(ml, 2);
				bx = null;
				ml = null;
			}

		}

	};

	public Handler sori = new Handler() {
		// float[] ju = { 1f, 1f, 1f };
		float[][] jx = new float[50][];
		long[] jxc = new long[50];
		int[] jxr = new int[50];
		long cu = 1;
		long holdcu = 1;
		// ImageView jh;
		long laycu = 1;
		// int rans = 1;
		int ori = 3;
		int oris = 1;
		float ntrot = 0;
		long bigcs = 1;
		long vtwrote = 1;
		android.graphics.Paint paint6, paint5, paint7, paint8;
		float vtmin = 1f;

		// Animation oh90
		// MapView xmm;

		// MapController xui;

		public void handleMessage(Message msg) {
			// if (xmm == null) {
			// xmm = (MapView) findViewById(R.id.cmapb);
			// xui = xmm.getController();
			// }
			Bundle hx = msg.getData();

			String provider = hx.getString("provider");
			int accuracy = hx.getInt("accuracy");
			float[] bu = hx.getFloatArray("values");
			int hardwaretype = hx.getInt("hw");

			hx = null;

			if (bu != null && bu.length != 3 && bu.length > 0) {
				bu = new float[] { bu[0], 0f, 0f };
			}

			if (upause) {
				Sensor h = som.getDefaultSensor(hardwaretype);
				if (h != null) {
					som.unregisterListener(sor, h);
				}
				h = null;
				Log.i("ok", provider + " pause");
				return;
			}

			if (bu != null && bu.length == 3) {

			} else {
				Log.w("ok", provider + "(" + accuracy + "," + hardwaretype
						+ ")" + " " + (bu != null ? bu.length : 0));
				return;
			}

			if (jx[hardwaretype] == null || jx[hardwaretype].length == 0) {
				jx[hardwaretype] = new float[] { 0f, 0f, 0f };
			}

			float d2x = jx[hardwaretype][2] - bu[2];
			float d1x = jx[hardwaretype][1] - bu[1];
			float d0x = jx[hardwaretype][0] - bu[0];

			float r2 = bu[2] < 0 ? bu[2] * -1 : bu[2];
			float r1 = bu[1] < 0 ? bu[1] * -1 : bu[1];
			float r0 = bu[0] < 0 ? bu[0] * -1 : bu[0];

			float d2 = jx[hardwaretype][2] > bu[2] ? jx[hardwaretype][2]
					- bu[2] : bu[2] - jx[hardwaretype][2];
			float d1 = jx[hardwaretype][1] > bu[1] ? jx[hardwaretype][1]
					- bu[1] : bu[1] - jx[hardwaretype][1];
			float d0 = jx[hardwaretype][0] > bu[0] ? jx[hardwaretype][0]
					- bu[0] : bu[0] - jx[hardwaretype][0];

			jx[hardwaretype] = bu;
			jxr[hardwaretype]++;

			if (jxc[hardwaretype] > SystemClock.uptimeMillis() + 21320) {

				relist.sendEmptyMessageDelayed(hardwaretype, 3000);
				Sensor h = som.getDefaultSensor(hardwaretype);
				if (h != null) {
					som.unregisterListener(sor, h);
				}
				h = null;
				return;
			}

			if (jxc[hardwaretype] > SystemClock.uptimeMillis()) {
				return;
			}

			if (jxc[hardwaretype] < SystemClock.uptimeMillis() - 30000
					&& jxc[hardwaretype] > 0) {

				relist.sendEmptyMessageDelayed(hardwaretype, 3000);
				Sensor h = som.getDefaultSensor(hardwaretype);
				if (h != null) {
					Log.w("ok", provider + "(    " + hardwaretype + "    "
							+ ori + "," + oris + ") " + (h.getPower())
							+ "             " + bu[0] + "(" + d0x + ") "
							+ bu[1] + "(" + d1x + ") " + bu[2] + "(" + d2x
							+ ")");
					som.unregisterListener(sor, h);
				}
				h = null;
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 30000;
				return;
				// relist.sendEmptyMessageDelayed(hardwaretype,
				// jxc[hardwaretype]
				// - SystemClock.uptimeMillis());

			}

			// if (smx > 0 || !viewapp_map || actwin >
			// SystemClock.uptimeMillis()) {
			// Log.i("ok", " super off");
			// jxc[hardwaretype] = SystemClock.uptimeMillis()
			// + ((actwin - SystemClock.uptimeMillis()) / 2);
			// Log.i("ok", provider + " rest for action " + smx);
			//
			// relist.sendEmptyMessageDelayed(hardwaretype, 1880);
			// Sensor h = som.getDefaultSensor(hardwaretype);
			// if (h != null) {
			// som.unregisterListener(sor, h);
			// }
			// h = null;
			//
			// return;
			// }
			//
			//
			//
			//
			//
			//
			//
			//

			if (rota
					&& hardwaretype == android.hardware.Sensor.TYPE_ACCELEROMETER) {
				//
				//
				// sets ori 2, oris 1
				//
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 1000 / 64;
				// vr =

				// vr.restore();
				// vt =

				// nalls

				if (mwidth > mheight) {
					// status: rarely
					ntrot = ((bu[1]) * 10f);
				} else {
					if (r0 > r2) {
						if (bu[0] > 0) {
							ntrot = ((bu[0] + bu[1] * -1 + bu[2]) * -10f);
						} else {
							ntrot = ((bu[0] + bu[1] + bu[2] * -1) * -10f);
						}
					} else {
						ntrot = ((bu[0]) * -10f);
					}
				}

				if (vtwrote < SystemClock.uptimeMillis()) {
					vtwrote = SystemClock.uptimeMillis() + 3000;
					Log.i("ok", "rotate alls and smart sparks " + (d0x * 10f)
							+ ", " + (bu[0] * 10f) + " " + bu[0] + "(" + d0x
							+ ") " + bu[1] + "(" + d1x + ") " + bu[2] + "("
							+ d2x + ") " + atrot + "->" + ntrot + ":" + vtmin);
				}

				//
				if (r0 > 1 && (int) atrot != (int) ntrot) {

					if (atrot - ntrot > vtmin || atrot - ntrot < -1 * vtmin) {

						// for (int x = 0; x < nalls.length; x++) {
						// if (nalls[x] == null) {
						// continue;
						// }

						// balls[x].drawColor(Color.argb(100, 0, 0, 20),
						// PorterDuff.Mode.CLEAR);

						// balls[x].rotate(atrot - ntrot,
						// (int) (balls[x].getWidth() / 2) - 1,
						// (int) (balls[x].getHeight() / 2) - 3);
						// balls[x].drawBitmap(nalls[x], 0, 0, ph8);
						// balls[x].save();
						// jh = (ImageView) findViewById(halls[x]);
						// jh.postInvalidate();
						// }
						// atrot = ntrot;
						// ew
						jxc[hardwaretype] = SystemClock.uptimeMillis() + 1000 / 16;
						if (d0 > 15f) {
							vtmin = 0.001f;
						} else if (d0 < 15) {
							vtmin += 0.05f;
						}

					} else {
						jxc[hardwaretype] = SystemClock.uptimeMillis() + 1000 / 8;
					}
				}

				if (xmme.getVisibility() == View.VISIBLE && vr != null) {
					b4update = SystemClock.uptimeMillis() + 20;

					{
						if (paint6 == null) {
							paint5 = new android.graphics.Paint();
							paint8 = new android.graphics.Paint();
							paint7 = new android.graphics.Paint();
							paint6 = new android.graphics.Paint();

							paint7.setColor(Color.argb(60, 7, 30, 110));
							paint7.setStrokeWidth(3f);
							paint7.setStyle(Style.STROKE);

							paint8.setColor(Color.argb(250, 7, 30, 110));
							paint8.setStrokeWidth(1f);
							paint8.setStyle(Style.FILL_AND_STROKE);
							// Typeface ho =
							// Typeface.createFromAsset(getAssets(),
							// "lucon.ttf");
							// paint8.setTypeface(ho);
							paint8.setTextSize(31f);
							// ttf
							// paint6 = new android.graphics.Paint();
							paint6.setColor(Color.argb(20, 7, 30, 210));
							paint6.setStrokeWidth(2f);
							paint6.setStyle(Style.STROKE);

						}
						// distinct
						if (mwidth > mheight) {
							// status: rarely
							ntrot = ((bu[1]) * 10f);
						} else {
							if (r0 > r2) {
								if (bu[0] > 0) {
									ntrot = ((bu[0] + bu[1] * -1 + bu[2]) * -10f);
								} else {
									ntrot = ((bu[0] + bu[1] + bu[2] * -1) * -10f);
								}
							} else {
								ntrot = ((bu[0]) * -10f);
							}
						}

						if (vtwrote < SystemClock.uptimeMillis()) {
							vtwrote = SystemClock.uptimeMillis() + 3000;
							Log.i("ok", "rotate " + (d0x * 10f) + ", "
									+ (bu[0] * 10f) + " " + vr.getSaveCount()
									+ " " + bu[0] + "(" + d0x + ") " + bu[1]
									+ "(" + d1x + ") " + bu[2] + "(" + d2x
									+ ") " + atrot + "->" + ntrot + ":" + vtmin);
						}

						// turntop = null;
						// turntop = Bitmap.createBitmap(turntopC);
						// turntop = Bitmap.createBitmap(mwidth, mheight,
						// Bitmap.Config.ARGB_8888);
						// vt = new Canvas(turntop);
						// vt.restoreToCount(vtstart);
						// vt.restore();
						// vt.clipPath(hbpath);

						// vt =

						if (r0 > 1 && (int) atrot != (int) ntrot) {

							if (atrot - ntrot > vtmin
									|| atrot - ntrot < -1 * vtmin) {

								if (vr == null || bxx4 == null) {
									return;
								}

								vr.rotate(atrot - ntrot,
										(int) (vr.getWidth() / 2) - 1,
										(int) (vr.getHeight() / 2) - 3);

								atrot = ntrot;
								// null here and 3478
								vr.drawColor(Color.argb(100, 0, 0, 20),
										PorterDuff.Mode.CLEAR);
								vr.drawBitmap(bxx4, 0, 0, paint5); // atrot
								// = 0;
								/*
								 * if (mwidth > mheight) { hbpathL = new Path();
								 * hbpathL.addCircle((int) ((mwidth) / 2), (int)
								 * ((mheight) / 2), (int) ((mheight) / 3) - 20,
								 * Path.Direction.CCW); } else { hbpathL = new
								 * Path(); hbpathL.addCircle((int) ((mwidth) /
								 * 2), (int) ((mheight) / 2), (int) ((mwidth) /
								 * 3) - 20, Path.Direction.CCW); } //
								 */
								// vr.drawPath(hbpathL, paint6);
								// vr.drawPath(hbpathL, paint7);
								b4update = SystemClock.uptimeMillis();
								// vt.save();
								// xmmi.setImageBitmap(turntop);
								jxc[hardwaretype] = SystemClock.uptimeMillis() + 1000 / 64;
								if (d0 > 15f) {
									vtmin = 0.001f;
								} else if (d0 < 15) {
									vtmin += 0.05f;
								}

								xmme.postInvalidate();
							} else {
								jxc[hardwaretype] = SystemClock.uptimeMillis() + 1000 / 32;
							}
							// vr.save();

						} else if (atrot != 9923 && r0 < -992392) {
							turntop = null;
							// turntop = Bitmap.createBitmap(turntopC);
							try {
								turntop = Bitmap.createBitmap(mwidth, mheight,
										Bitmap.Config.ARGB_8888);

								vtmin = 15f;
								vt = new Canvas(turntop);
								vt.clipPath(hbpath);
								atrot = 0f;
								vt.drawBitmap(bxx4, 0, 0, paint5);
								vt.drawPath(hbpathL, paint6);
								vt.drawPath(hbpathL, paint7);
								jxc[hardwaretype] = SystemClock.uptimeMillis() + 1000 / 16;
								xmmi.setImageBitmap(turntop);

								Log.i("ok",
										"rotate clear " + (d0x * 10f) + ", "
												+ (bu[0] * 10f) + " "
												+ vt.getSaveCount() + " "
												+ bu[0] + "(" + d0x + ") "
												+ bu[1] + "(" + d1x + ") "
												+ bu[2] + "(" + d2x + ")");
							} catch (OutOfMemoryError sf) {
								Log.w("ok", "wha xxx d");
							}
						}

					}

					return;
					// } else if (xmmi.getVisibility() == View.VISIBLE) {

					// getScanLocation.sendEmptyMessageDelayed(2, 10);
				}

				if (vt == null) {
					b4update = SystemClock.uptimeMillis();
					return;
				}
				// vt =
				// turntop = Bitmap.createBitmap(mwidth,
				// mheight,
				// Bitmap.Config.ARGB_8888);
				// vt.restoreToCount(vtstart);
				// vt.rotate(0, vt.getWidth() / 2,
				// vt.getHeight() / 2);

				// vt.drawPath(hbpathL, paint6);
				// xmmd.setImageBitmap(turndetail);
				// xmmi.postInvalidate();

				// vr
				// xmme.setImage

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_PROXIMITY) {

				if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f) {
					Log.w("ok", provider + " " + bu[0] + "(" + d0x + ") "
							+ bu[1] + "(" + d1x + ") " + bu[2] + "(" + d2x
							+ ")");
					// xmmishow.sendEmptyMessageDelayed(2, 10);//
					// xmmi.setVisibility(View.VISIBLE);
					// refreshLocation.sendEmptyMessageDelayed(2, 20);

					// sparkMachine.sendEmptyMessageDelayed(2, 10);
					jxc[hardwaretype] = SystemClock.uptimeMillis() + 30000;
					// History
				}

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_GYROSCOPE) {
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 3000;

				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < SystemClock.uptimeMillis()) {

				Log.w("ok", provider + " " + bu[0] + "(" + d0x + ") " + bu[1]
						+ "(" + d1x + ") " + bu[2] + "(" + d2x + ")");
				// xmmishow.sendEmptyMessageDelayed(2, 10);//
				// xmmi.setVisibility(View.VISIBLE);
				// }

				// sparkMachine
			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_ORIENTATION) {
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 3000;

				// if (d2 > 40f || d1 > 40f || d0 > 40f) {
				// xmmishow.sendEmptyMessageDelayed(2, 10);//
				// xmmi.setVisibility(View.VISIBLE);
				// jxc[hardwaretype] = SystemClock.uptimeMillis() + 1000;
				// }

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_LIGHT) {

				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < SystemClock.uptimeMillis()) {
				// }
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 30000;

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_PRESSURE) {

				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < SystemClock.uptimeMillis()) {

				// }
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 30000;

			} else if (bu != null && bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_TEMPERATURE) {
				// if (d2 > 0.2f || d1 > 0.2f || d0 > 0.2f
				// || jxc[hardwaretype] < SystemClock.uptimeMillis()) {

				// }
				// Sensor h = som.getDefaultSensor(hardwaretype);
				// if (h != null) {
				// som.unregisterListener(sor, h);
				// }
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 30000;

			} else if (bu != null
					&& bu.length == 3
					&& hardwaretype == android.hardware.Sensor.TYPE_MAGNETIC_FIELD) {
				jxc[hardwaretype] = SystemClock.uptimeMillis() + 30000;

				// if (d2 > 70f || d1 > 70f || d0 > 70f) {
				// }

				// Sensor h = som.getDefaultSensor(hardwaretype);
				// if (h != null) {
				// som.unregisterListener(sor, h);
				// }
			} else {
				// Sensor h = som.getDefaultSensor(hardwaretype);
				// if (h != null) {
				// som.unregisterListener(sor, h);
				// }

				if (jxc[hardwaretype] < SystemClock.uptimeMillis()) {
					jxc[hardwaretype] = SystemClock.uptimeMillis() + 30000;
					Log.w("ok", provider + "            (" + accuracy + ","
							+ hardwaretype + ")" + " "
							+ (bu != null ? bu.length : 0) + ": " + bu[0]
							+ "(" + d0x + ") " + bu[1] + "(" + d1x + ") "
							+ bu[2] + "(" + d2x + ")");
				}
			}

		}
	};

	@Override
	public boolean onKeyLongPress(int c, KeyEvent b) {
		Log.i("ok", "long key " + c + " " + Character.getType(c) + ".");
		// monkey("received " + c + " ");

		return super.onKeyLongPress(c, b);
	}

	@Override
	public boolean onKeyMultiple(int c, int repeatCount, KeyEvent b) {

		Log.i("ok",
				"key multiple "
						+ new String(Character.toChars(b.getUnicodeChar())));
		// Log.i("ok",
		// "received " + b.getAction() + " " + c + " "
		// + Character.getType(c) + " X " + repeatCount + ".");
		// monkey("received " + c + " X " + repeatCount);

		return super.onKeyMultiple(c, repeatCount, b);
	}

	@Override
	public boolean onKeyUp(int c, KeyEvent b) {

		// Log.i("ok",
		// "key up " + new String(Character.toChars(b.getUnicodeChar())));
		return super.onKeyUp(c, b);

	}

	public void monkey(String content) {
		if (content == null) {
			content = "";
		}
		Bundle b8 = new Bundle();
		b8.putString("content", content);
		Message m8 = new Message();
		m8.setData(b8);
		monkey.sendMessageDelayed(m8, 10);
		m8 = null;
		b8 = null;
		content = null;
	}

	@Override
	public boolean onKeyDown(int c, KeyEvent b) {
		Log.i("ok",
				"key on " + new String(Character.toChars(b.getUnicodeChar()))
						+ " " + b.getUnicodeChar() + " " + c + " "
						+ b.isShiftPressed() + " ");

		chard = b.getUnicodeChar();
		if (chard > 0) {
		} else {
			// KeyCharacterMap.KeyData hr = new KeyCharacterMap.KeyData();
			// b.getKeyData(hr);
			// KeyCharacterMap hk = KeyCharacterMap.load(KeyCharacterMap.ALPHA);
			if (c == KeyEvent.KEYCODE_DEL) {
				chard = 8;// 127
			}
		}

		mkuni[mkct] = chard;
		twochars = Character.toChars(chard);
		mk[mkct][0] = twochars[0];
		if (twochars.length == 2) {
			mk[mkct][1] = twochars[1];
		} else {
			mk[mkct][1] = '\0';
		}

		mkct++;
		if (mkct == 1 || mkat < mkct - 5) {
			monkeyService.removeMessages(2);
			monkeyService.sendEmptyMessageDelayed(2, 2);

		}

		// Log.i("ok",
		// "received " + b.getAction() + " " + c + " ("
		// + Character.getType(c) + ")" + " " + " s"
		// + b.isShiftPressed() + " p" + b.isPrintingKey() + " a"
		// + b.isAltPressed() + " x" + b.isTracking() + " #"
		// + b.getNumber() + " " + hr.displayLabel + "() "
		// + hk.get(c, b.getMetaState()));
		/*
		 * if (b.getAction() == KeyEvent.ACTION_DOWN) { // chard =
		 * b.getUnicodeChar(b.getMetaState());
		 * 
		 * // KeyCharacterMap hh = KeyCharacterMap; if (b.isPrintingKey()) { //
		 * mk[mkct] = (mk[mkct] != null ? mk[mkct] + "" : "") + "" // + new
		 * String(Character.toChars(chard)); // monkey(mk[mkct]); monkey(new
		 * String(Character.toChars(chard))); } else { if
		 * (Character.toTitleCase(chard) == ' ') { mk[mkct] = (mk[mkct] != null
		 * ? mk[mkct] + "" : "") + " "; monkey(mk[mkct]); } else if
		 * (Character.toTitleCase(chard) == '\n') { Log.i("ok", "new line " +
		 * chard); monkey(new String(Character.toChars(chard))); mkct++; //
		 * monkey(mk[mkct]);
		 * 
		 * } else { Log.i("ok", "nonprintable char " + chard); return
		 * super.onKeyDown(c, b); }
		 * 
		 * } return true; }//
		 */
		return super.onKeyDown(c, b);

	}

	private Handler monkey = new Handler() {

		public void handleMessage(Message msg) {
			Bundle bdl = msg.getData();
			String content = bdl.getString("content");
			bdl = null;
			if (content == null) {
				content = ">";
			}

			if (gnhb == null || gnhi.getScrollY() > (mheight * 2)) {
				try {
					gnhb = null;
					gnhb = Bitmap.createBitmap(mwidth, mheight * 3,
							Bitmap.Config.ARGB_8888);
				} catch (OutOfMemoryError sf) {
					Log.w("ok", "wha xxx");
				}

				if (gnhb != null) {
					gnh = new Canvas(gnhb);
					gnhp = new android.graphics.Paint();

					gnhp.setAntiAlias(true);
					gnhp.setShadowLayer(2.5f, 1f, 1f, Color.argb(160, 0, 0, 60));
					gnhp.setTextSize(31f);// gnhp.setTypeface(Typeface.)
					// gnhp.setStyle(android.graphics.Paint.Style.STROKE);

					gnhp.setColor(Color.argb(250, 7, 30, 210));

					if (gnhi == null) {

						gnhi = new ImageView(ctx);
						while (findViewById(++hid) != null) {
						}
						gnhi.setId(hid);
						RelativeLayout.LayoutParams j9 = new RelativeLayout.LayoutParams(
								-1, -1);

						gnhi.setLayoutParams(j9);
						j9 = null;
						gnhi.setScaleType(ScaleType.MATRIX);
						pbn.addView(gnhi);
					}
					gnhi.scrollTo(0, 0);
					gnhi.setImageBitmap(gnhb);

				}
			}
			/*
			 * if (gnhb != null) { // br++; if (br == 1) { Typeface ho =
			 * Typeface.createFromAsset(getAssets(), "lucon.ttf");
			 * gnhp.setTypeface(ho); ho = null; } else if (br == 2) { Typeface
			 * ho = Typeface.createFromAsset(getAssets(), "arial.ttf");
			 * gnhp.setTypeface(ho); ho = null; } else if (br == 3) { Typeface
			 * ho = Typeface.createFromAsset(getAssets(), "times.ttf");
			 * gnhp.setTypeface(ho); // br = 0; ho = null; }
			 * 
			 * } //
			 */
			// try {
			// gnhb = null;
			// gnhb = Bitmap.createBitmap(mwidth, mheight,
			// Bitmap.Config.ARGB_8888);
			// } catch (OutOfMemoryError sf) {
			// Log.w("ok", "Monkey Error ");
			// return;
			// }

			if (gnhb != null && gnh != null) {
				// gnh.setBitmap(gnhb);
				// gnh = new Canvas(gnhb);
				gnhi.scrollBy(0, (int) (gnhp.getTextSize() + 2));
				gnh.translate(0, (int) (gnhp.getTextSize() + 2));
				gnh.drawText(content, mwidth / 100, (mheight / 5) * 1, gnhp);
				// gnhi.setImageBitmap(gnhb);
				Log.i("ok", "monkey " + gnhi.getScrollY());

				gnhi.postInvalidate();
			} else {
				Log.w("ok", "trouble in monkeydice");
			}

		}
	};

	public Handler monkeyService = new Handler() {
		int rp = 1;
		int cc = 1;
		int lw = 1;
		Path ni9;

		public void handleMessage(Message msg) {
			Log.i("ok", "99.9999               monkeyService");

			if (gnhb == null || gnhi.getScrollY() > (mheight * 2)) {
				try {
					gnhb = null;
					gnhb = Bitmap.createBitmap(mwidth, mheight * 3,
							Bitmap.Config.ARGB_8888);
				} catch (OutOfMemoryError sf) {
					Log.w("ok", "wha xxx");
				}

				if (gnhb != null) {
					gnh = new Canvas(gnhb);
				}
			}

			if (gnhi == null) {

				gnhi = new ImageView(ctx);
				while (findViewById(++hid) != null) {
				}
				gnhi.setId(hid);
				RelativeLayout.LayoutParams j9 = new RelativeLayout.LayoutParams(
						-1, -1);

				gnhi.setLayoutParams(j9);
				j9 = null;
				gnhi.setScaleType(ScaleType.MATRIX);
				pbn.addView(gnhi);
				gnhi.scrollTo(0, 0);
				gnhi.setImageBitmap(gnhb);

			}

			if (gnhi == null || gnhb == null) {
				Log.w("ok", "super     extreme   huuu");
				return;
			}
			if (gnhp == null) {
				gnhp = new android.graphics.Paint();

				gnhp.setAntiAlias(true);
				gnhp.setShadowLayer(2.5f, 1f, 1f, Color.argb(160, 220, 220, 20));
				gnhp.setTextSize(31f);// gnhp.setTypeface(Typeface.)
				// gnhp.setStyle(android.graphics.Paint.Style.STROKE);

				// gnhp.setColor(Color.argb(250, 7, 30, 210));
				gnhp.setColor(Color.argb(255, 227, 230, 250));

				// Typeface ho = Typeface
				// .createFromAsset(getAssets(), "lucon.ttf");// "lucon.ttf");
				// gnhp.setTypeface(ho);
				gnhp.setTextSize(38f);
				// ho = null;
			}

			if (mkat < mkct) {
				// gnhp = null
				if (ni9 == null) {
					ni9 = new Path();
					RectF oval = new RectF();
					oval.set(0, (int) ((mheight / 3) * 2), mwidth * 2,
							(int) (mheight) - gnhp.getTextSize() - 22);// CCW
					ni9.addArc(oval, -185f, -186f);

					Paint g7 = new Paint();
					g7.setStyle(Style.STROKE);
					g7.setColor(Color.argb(200, 150, 150, 50));
					g7.setStrokeWidth(1f);
					// gnh.drawArc(oval, 175, 75, false, g7);
					// gnh.drawPath(ni9, g7);
				}

				for (; mkat < mkct; mkat++) {
					if (mkuni[mkat] > 31 && mkuni[mkat] < 127) {
						// Log.i("ok", "writting " + mk[mkat][0]);

						gnh.drawTextOnPath(mk[mkat], 0, mk[mkat][1] != '\0' ? 2
								: 1, ni9, (mwidth * 0) + lw, 0, gnhp);
						lw += gnhp.measureText(mk[mkat], 0, 1);

					}
					// geostory
					if (mkuni[mkat] == 8) {
						Log.i("ok", "attempting single backspace test");
						gnh.restore();// key on
						for (int ku = 0; ku < mkat - 1; ku++) {
							gnh.drawTextOnPath(mk[ku], 0, mk[ku][1] != '\0' ? 2
									: 1, ni9, (mwidth * 0) + lw, 0, gnhp);
							lw += gnhp.measureText(mk[ku], 0, 1);
						}

					}

					// mheight - gnhp.getTextSize() - 22
					if (mkuni[mkat] == 10 || lw > (mwidth)) {
						Log.i("ok", "99.9999            spacing " + mk[mkat][0]
								+ " printed " + lw);
						if (lw > (mwidth)) {
							lw = 20;
							gnhi.scrollBy(0, (int) (gnhp.getTextSize() + 1));
							gnh.translate(0, (int) (gnhp.getTextSize() + 1));
						} else {
							lw = 0;
							gnhi.scrollBy(0, (int) (gnhp.getTextSize() + 2));
							gnh.translate(0, (int) (gnhp.getTextSize() + 2));
						}
						// .rotate
						Paint g7 = new Paint();
						g7.setStyle(Style.STROKE);
						g7.setColor(Color.argb(200, 150, 150, 50));
						g7.setStrokeWidth(1f);
						// gnh.drawArc(oval, 175, 75, false, g7);
						// gnh.drawPath(ni9, g7);
						gnh.save();
						// Bitmap.getPixels and setPixels
						// scrollBy
					}

				}
				gnhi.postInvalidate();

				if (mkct > (mkuni.length - mkuni.length / 5)) {
					mkct = 1;
					mkat = 1;
				}
				rp = 1;
			} else {
				rp++;
			}
			cc++;
			if (cc > 64 * 5) {
				monkeyService.removeMessages(2);
				cc = 1;
			}

			if (rp < 64) {
				// monkeyService.sendEmptyMessageDelayed(2, 1000 / 64);
			} else {
				Log.i("ok", "99.9999           monkey service off");
				mkct = 0;
				mkat = 0;
			}

		}
	};
	Handler boxerhide = new Handler() {
		public void handleMessage(Message msg) {
			hugis.setVisibility(View.INVISIBLE);
			boxerhug.setVisibility(View.INVISIBLE);
			boxerhugaware = false;

		}
	};

	@Override
	protected void onPause() {

		super.onPause();
		Log.i("ok",
				"99.9999      -------------------pause---------------------");
		upause = true;
		// hidetips.sendEmptyMessageDelayed(2, 75);

		// if (ipb != null) {
		// ipb.setImageResource(R.drawable.pbo);
		// }

		refreshLocation.removeMessages(2);
		recordService.removeMessages(2);
		recordService.removeMessages(3);
		operationsPunctuation.removeMessages(2);
		boxerhugoff.sendEmptyMessageDelayed(2, 75);
		if (som != null) {
			List<Sensor> hs = som.getSensorList(Sensor.TYPE_ALL);
			for (int h = 0; h < hs.size(); h++) {
				Sensor uk = hs.get(h);
				som.unregisterListener(sor, uk);
				uk = null;
			}
			hs = null;
		}

		boxerhug.setVisibility(View.INVISIBLE);
		boxerhugaware = false;
		reg.unregisterOnSharedPreferenceChangeListener(underDingo);
		if (u8 != null) {
			try {
				u8.stop();
			} catch (IllegalStateException e1) {
				Log.i("ok", "wha e1 " + e1.getLocalizedMessage());
				// e1.printStackTrace();
			}
			u8.reset();
			u8.release();

			// u8.release();
			u8 = null;
		}

		if (pm != null && m5 != null) {
			pm.userActivity(SystemClock.uptimeMillis(), false);
			try {
				m5.release();
			} catch (RuntimeException er) {
			}

		}

		// Log.i("ok", "xxx");

	}

	@Override
	protected boolean isRouteDisplayed() {
		// Log.i("ok", "route displayed");
		return true;
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.i("ok", "----------------restore----------------");

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i("ok", "----------------save----------------");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Log.i(G, "oncreataeoptionsmenu good");
		MenuItem o1 = menu.add(1, 1, 0, "History");
		o1.setTitle("");
		o1.setIcon(R.drawable.bpl);
		// MenuItem o2 = menu.add(1, 2, 2, "Bridges");
		MenuItem o3 = menu.add(1, 3, 3, "Settings");
		o3.setTitle("");
		o3.setIcon(R.drawable.bps);

		File filea = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath(), "data/com.docchomps.ok");
		filea.mkdirs();

		if (filea.exists()) {

			// MenuItem o4 = menu.add(1, 4, 3, "Set");
			MenuItem o5 = menu.add(1, 5, 3, "Email");
			o5.setTitle("");
			o5.setIcon(R.drawable.bpe);

			// MenuItem o6 = menu.add(1, 6, 3, "Total Recall");
			// o6.setTitle("");
			// o6.setIcon(R.drawable.bpn);
		}
		// MenuItem o8 = menu.add(1, 8, 3, "Total Recall");
		// o8.setTitle("");
		// o8.setIcon(R.drawable.bpn);

		// up.sendEmptyMessageDelayed(2, 100);
		//
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// Log.i(G, "onmenuitemselected good xxx");

		switch (item.getItemId()) {
		// case 8:
		// dingoSparkToggle.sendEmptyMessageDelayed(0, 10);
		// break;
		case 7:
			productiondash.setVisibility(View.INVISIBLE);
			break;

		case 5:// Cursor insert update

			sendone.sendEmptyMessageDelayed(
					2,
					actwin > SystemClock.uptimeMillis() ? (actwin - SystemClock
							.uptimeMillis()) + ADURATION : 10);

			break;

		case 6:// Cursor insert update

			sendrecall.sendEmptyMessageDelayed(
					2,
					actwin > SystemClock.uptimeMillis() ? (actwin - SystemClock
							.uptimeMillis()) + ADURATION : 10);

			break;
		case 4:
			mAlM = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
			Intent rr = new Intent();
			rr.setAction("com.docchomps.ok.SERVICE");
			// resetservice.setAction("");
			service4 = PendingIntent.getBroadcast(ctx, 80, rr,
					Intent.FLAG_ACTIVITY_NEW_TASK
							| PendingIntent.FLAG_CANCEL_CURRENT);

			if (mAlM != null && service4 != null) {
				mAlM.set(AlarmManager.RTC_WAKEUP,
						System.currentTimeMillis() + 10000, service4);
				Log.i("ok", "alarm set");

			}
			break;

		case 1:
			Intent r4 = new Intent(ctx, com.docchomps.ok.OKPeople.class);
			r4.putExtra("cu", "content://com.docchomps.ok/moment");
			r4.putExtra("c2",
					"content://com.docchomps.ok/moment\namap\nfieldid\n_id\nimageb");
			// r4.putExtra("c4",
			// "content://com.docchomps.ok/moment\n_id\nfieldid\n_id\nstring");
			r4.putExtra("c1",
					"content://com.docchomps.ok/moment\naback\nfieldid\n_id\naudio");
			r4.putExtra("c3",
					"content://com.docchomps.ok/moment\naslide\nfieldid\n_id\nimagea");
			r4.putExtra("cl", "acontent,atitle,atitle,lat,lon");
			startActivity(r4);

			break;
		case 2:
			// int sdkVersion = Integer.parseInt(Build.VERSION.SDK);

			// startActivityForResult(new Intent)
			// Log.i("x", "v" + sdkVersion);
			// Toast.makeText(ctx, "v" + sdkVersion, 2300).show();
			// if (sdkVersion < 5) {
			// startActivityForResult(new Intent(Intent.ACTION_PICK,
			// Contacts.CONTENT_URI), 0);

			// } else {
			// startActivityForResult(
			// new Intent(Intent.ACTION_PICK,
			// Uri.parse("content://com.android.contacts/")),
			// 0);

			// }

			Intent r43 = new Intent(ctx, com.docchomps.ok.OKPeople.class);
			r43.putExtra("cu", ContactsContract.Data.CONTENT_URI.toString());
			r43.putExtra("c1",
					"content://com.docchomps.ok/contact\nrotation\nfieldc\nemail\nstring");
			startActivity(r43);

			break;
		case 3:
			Cursor ge5 = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://com.docchomps.ok/checkin"),
					new String[] { "_id" }, null, null, null);

			if (ge5 != null && ge5.moveToFirst()) {
				ge5.close();
			} else {

				if (ge5 != null) {
					ge5.close();
				}

				ContentValues cx = new ContentValues();
				// cx.put("anext", "");
				cx.put("rotation", 5 * 60);
				cx.put("atitle", "Check In");
				SqliteWrapper.insert(ctx, ctx.getContentResolver(),
						Uri.parse("content://com.docchomps.ok/checkin"), cx);
				cx = null;
				ContentValues cx4 = new ContentValues();
				cx4.put("atill", datetime(System.currentTimeMillis()
						+ (30 * 60 * 1000)));
				cx4.put("atillset", 1);
				cx4.put("rotation", 5);

				cx4.put("atitle", "Check In");
				SqliteWrapper.insert(ctx, ctx.getContentResolver(),
						Uri.parse("content://com.docchomps.ok/checkin"), cx4);
				cx4 = null;
			}

			Intent r42 = new Intent(ctx, com.docchomps.ok.OKPeople.class);
			r42.putExtra("title", "Settings");
			r42.putExtra("cu", "content://com.docchomps.ok/checkin");
			r42.putExtra("c1",
					"content://com.docchomps.ok/checkin\nrotation\nfieldid\n_id\nnumeric");

			startActivity(r42);
			break;
		default:
			// Toast.makeText(mCtx, "us", 540).show();
		}

		return super.onMenuItemSelected(featureId, item);
	}

	private Handler pukdate = new Handler() {
		String[] day = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };

		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.999999         PUK DATE " + msg.what);
			if (cspuk > SystemClock.uptimeMillis()) {
				cspuk = SystemClock.uptimeMillis() + 1370 * 2;
				Log.i("ok", "date rest");
				return;
			}
			// Animation ruu = AnimationUtils.loadAnimation(ctx, R.anim.boomp4);
			cspuk = SystemClock.uptimeMillis() + 1370;

			Date vb = new Date();

			{
				Bundle b9 = new Bundle();
				b9.putStringArray("contentlist",
						new String[] { day[vb.getDay()] });
				Message m9 = new Message();
				m9.setData(b9);
				ddpuk.sendMessageDelayed(m9, 10);
			}

		}
	};

	private Handler hiscave = new Handler() {
		public void handleMessage(Message msg) {
			// XXX
			Log.i("ok", "99.9999            REMOVE CAVE " + msg.what);
			ImageView hu = (ImageView) findViewById(msg.what);
			if (hu != null) {
				sparkEasel.removeView(hu);
				hu = null;
			}
		}
	};

	public Handler belayGetScanLocation = new Handler() {
		public void handleMessage(Message msg) {

			// XXX
			Log.i("ok", "99.9999           Refresh Location: belay get & scan "
					+ msg.what);

			getScanLocation.sendEmptyMessageDelayed(msg.what, 10);

		}
	};

	public Handler ruuoff = new Handler() {
		public void handleMessage(Message msg) {
			// if (cspuk > SystemClock.uptimeMillis()) {
			Log.i("ok", "99.9999                  ruu off");
			// return;
			// }

			LinearLayout ru = null;
			ru = (LinearLayout) findViewById(msg.what);

			if (ru != null) {
				Animation ruu = AnimationUtils.loadAnimation(ctx, R.anim.boom4);
				ru.startAnimation(ruu);
				ruuoffb.sendEmptyMessageDelayed(msg.what, ruu.getDuration());
				cspuk = SystemClock.uptimeMillis() + (1370) + ruu.getDuration();
				ruu = null;
				ru = null;
				// pbn.bringChildToFront(pba);

			}

		}
	};

	private Handler ruuoffb = new Handler() {
		public void handleMessage(Message msg) {
			LinearLayout ru = null;
			ru = (LinearLayout) findViewById(msg.what);
			if (ru != null) {
				ru.setVisibility(View.GONE);
				ru = null;
				// pbn.removeView(ru);
			}
		}
	};

	private Handler bvis = new Handler() {
		public void handleMessage(Message msg) {
			Log.i("ok", "Button active " + msg.what);
			Button ru = null;
			ru = (Button) findViewById(msg.what);
			if (ru != null) {
				Animation ruu = AnimationUtils
						.loadAnimation(ctx, R.anim.boomp4);
				ru.setVisibility(View.VISIBLE);
				ru.startAnimation(ruu);
				ru = null;
				ruu = null;
			}

		}
	};
	private Handler bclick = new Handler() {
		public void handleMessage(Message msg) {

			Bundle hx = msg.getData();
			String message = hx.getString("message");
			if (message == null) {
				message = "U";
			}
			Date v = new Date();
			int hours = hx.getInt("hours", v.getHours());
			int mins = hx.getInt("mins", v.getMinutes());

			Intent sx = new Intent();
			sx.setAction("android.intent.action.SET_ALARM");
			sx.putExtra("android.intent.extra.alarm.MESSAGE", message);
			sx.putExtra("android.intent.extra.alarm.HOUR", hours);
			sx.putExtra("android.intent.extra.alarm.MINUTES", mins);
			startActivity(sx);

		}
	};

	private Handler relist = new Handler() {
		public void handleMessage(Message msg) {
			// Log.i("ok", "99.9999                         relist " +
			// msg.what);
			relist.removeMessages(msg.what);
			if (smx != 0 && !upause) {

				relist.sendEmptyMessageDelayed(msg.what, 3500);
				return;
			}

			Sensor uk = som.getDefaultSensor(msg.what);
			som.registerListener(sor, uk, SensorManager.SENSOR_DELAY_GAME);
		}
	};

	private Runnable runxga = new Runnable() {

		public void run() {
			Log.i("ok",
					"99.99999999999999                   Refresh Location: cloud update available "
							+ appScanPass);
			// refreshLoca

			// if (!viewapp_map) {

			// xmmbb.postInvalidate();
			getScanLocation.sendEmptyMessageDelayed(3, appScanPass ? 20 : 120);
			// locationPageButton.removeMessages(2);
			// locationPageButton.sendEmptyMessageDelayed(2, 200);

			// }

			// getScanLocation.sendEmptyMessageDelayed(3,
			// appScanPass ?
			// 420
			// : 1820);
		}
	};

	public Handler sendrecall = new Handler() {
		public void handleMessage(Message msg) {

			File filea = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath(), "data/com.docchomps.ok");
			filea.mkdirs();

			if (filea.exists()) {

				ArrayList<Uri> uris = new ArrayList<Uri>();

				for (int vi = 5; vi >= 0; vi--) {

					File aaud = new File(filea.getAbsolutePath(), "vh" + vi
							+ ".3gp");
					if (aaud.exists()) {
						int dgg = (int) (System.currentTimeMillis() - aaud
								.lastModified());
						if (dgg < 30 * 60 * 1000) {
							File dr = new File(filea.getAbsolutePath(),
									Uri.encode(datetime(aaud.lastModified()),
											" ") + ".3gp");
							aaud.renameTo(dr);
							Uri u = Uri.fromFile(dr);
							uris.add(u);

						}
						// sparkMachine.send
					}
				}
				// [hardwaretype]
				if (uris.size() > 0) {

					Intent hj = new Intent();
					// hj.setAction("com.docchomps.ok.EMAIL");
					// hj.setClass(ctx, Anumeric.class);
					hj.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
					hj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
							| Intent.FLAG_ACTIVITY_NO_HISTORY);
					// CONN GPS
					hj.setType("text/plain");
					hj.putExtra(Intent.EXTRA_TEXT, "Total Recall");

					{
						// hj.putExtra(android.content.Intent.EXTRA_EMAIL,
						// new String[] { "havenskys@gmail.com" });
						hj.putExtra(android.content.Intent.EXTRA_CC,
								new String[] { "havenskys@gmail.com" });
						// has to be an ArrayList
						// convert from paths to Android friendly
						// Parcelable
						// Uri's

						hj.putParcelableArrayListExtra(Intent.EXTRA_STREAM,
								uris);// new
										// Intent(Intent.ACTION_SEND);

						hj.putExtra(Intent.EXTRA_SUBJECT, "Total Recall");// +
						// ge.getString(7));
						// en

						// startActivity(Intent.createChooser(hj,
						// "Email"));
					}
					startActivity(hj);

				}
			}

		}
	};

	public Handler sendone = new Handler() {
		public void handleMessage(Message msg) {
			Cursor ge = SqliteWrapper.query(ctx, getContentResolver(),
					Uri.parse("content://com.docchomps.ok/moment"),
					new String[] { "_id", "amap", "aslide", "aback", "created",
							"acontent", "atitle", "date(created)", "lat",
							"lon", "afront", "adeep", "aslope" }, null, null,
					"_id desc limit 1");

			if (ge != null && ge.moveToFirst()) {
				String cct = ge.getString(5);
				float lat = ge.getFloat(8);
				float lon = ge.getFloat(9);
				float adeep = ge.getInt(11);
				String cca = ge.getString(6);
				// String ccas = Uri.encode(cca, " ,");
				String cad = ge.getString(7);
				String ccf = cca + " " + cad;
				File filea = new File(Environment.getExternalStorageDirectory()
						.getAbsolutePath(), "data/com.docchomps.ok");
				filea.mkdirs();

				String sendfile = "";// seperate by \n

				if (filea.exists()) {
					boolean redund = true;

					String mss = "";
					// if (cca != null && cca.length() > 2) {
					// mss += "\n== " + cca + " ==\n";
					// }
					if (cct != null && cct.length() > 2) {
						mss += cct + "\n";
						// } else if (ge.getFloat(8) > 0f ||
						// ge.getFloat(8) <
						// 0f) {
						// mss += "" + ge.getFloat(8) + "," +
						// ge.getFloat(9)
						// + "\n";
					}

					// if (gpsla != 1 || gpsla != 1 || gpsld != 1) {

					if (reg.getString("geostory", "").length() > 0) {
						mss += "\n" + reg.getString("geostory", "");
					} else {
						mss += "\n" + lat + "," + lon + " " + adeep + "\n";
					}

					// }
					mss += "\n\n\n";// Electric White Presenting";

					File aaud = new File(filea.getAbsolutePath(), ccf + ".3gp");

					if (ge.getBlob(3) != null) {

						FileOutputStream o9;
						try {
							o9 = new FileOutputStream(aaud);
							o9.write(ge.getBlob(3));
							o9.close();
							if (redund) {
								sendfile += aaud.getAbsolutePath() + "\n";
							}
							// hj.putExtra(Intent.EXTRA_STREAM,
							// Uri.parse("file://" +
							// apng.getAbsolutePath()));
							// hj.setType("message/rfc822");
						} catch (FileNotFoundException e) {
							Log.i("ok", "wha io e 11");// e.printStackTrace();
						} catch (IOException e) {
							Log.i("ok", "wha io e 12");// e.printStackTrace();
						}
					}

					File aaud4 = new File(filea.getAbsolutePath(), ccf
							+ "-2.3gp");

					if (ge.getBlob(10) != null) {

						FileOutputStream o9;
						try {
							o9 = new FileOutputStream(aaud4);
							o9.write(ge.getBlob(10));
							o9.close();
							// IN ACTIVE ATM study single attachment auto load:
							// xfail
							sendfile += aaud4.getAbsolutePath() + "\n";

							// hj.putExtra(Intent.EXTRA_STREAM,
							// Uri.parse("file://" +
							// apng.getAbsolutePath()));
							// hj.setType("message/rfc822");
						} catch (FileNotFoundException e) {
							Log.i("ok", "wha io e 12");// e.printStackTrace();
						} catch (IOException e) {
							Log.i("ok", "wha io e 13");// e.printStackTrace();
						}
					}

					File amap = new File(filea.getAbsolutePath(), ccf + ".png");

					// ge.getString(7) + " " + lat + "," + lon + ".png");
					// 12 too
					if (ge.getBlob(1) != null) {
						// (6)
						FileOutputStream o9;
						try {
							o9 = new FileOutputStream(amap);
							o9.write(ge.getBlob(1));
							o9.close();
							if (redund) {
								sendfile += amap.getAbsolutePath() + "\n";
							}
							// hj.putExtra(Intent.EXTRA_STREAM,
							// Uri.parse("file://" +
							// apng.getAbsolutePath()));
							// hj.setType("message/rfc822");
						} catch (FileNotFoundException e) {
							Log.i("ok", "wha io e 9");// e.printStackTrace();
						} catch (IOException e) {
							Log.i("ok", "wha io e 10");// e.printStackTrace();
						}
					}

					File apng = new File(filea.getAbsolutePath(), ccf + ".png");
					if (ge.getBlob(2) != null) {

						FileOutputStream o9;
						try {
							o9 = new FileOutputStream(apng);
							o9.write(ge.getBlob(2));
							o9.close();

							if (redund) {
								sendfile += apng.getAbsolutePath() + "\n";
							}
							// hj.putExtra(Intent.EXTRA_STREAM,
							// Uri.parse("file://" +
							// apng.getAbsolutePath()));
							// hj.setType("message/rfc822");
						} catch (FileNotFoundException e) {
							Log.i("ok", "wha io e 14");// e.printStackTrace();
						} catch (IOException e) {
							Log.i("ok", "wha io e 15");// e.printStackTrace();
						}
					}
					// http://maps.google.com/?ll=47.620766,-122.325425&spn=0.00392,0.006512

					File ohm = new File(filea.getAbsolutePath(), ccf + ".pdf");
					try {
/*
						PdfPTable hw = new PdfPTable(4);
						hw.setWidthPercentage(99f);
						Document dh = new Document();
						PdfWriter.getInstance(dh, new FileOutputStream(ohm));
						dh.open();
						dh.addTitle("" + ccf);
						dh.addSubject("" + ccf);
						dh.addKeywords("" + ccf);
						dh.addAuthor("Haven Skys <havenskys@gmail.com>");
						dh.addCreator("Electric White");

						// Typeface ho = Typeface.createFromAsset(getAssets(),
						// "SanvitoPro-Regular.otf");// "lucon.ttf");

						Font cn = new Font(Font.FontFamily.HELVETICA, 18,
								Font.NORMAL);
						Font cb = new Font(Font.FontFamily.HELVETICA, 21,
								Font.BOLD);

						{
							PdfPCell h = new PdfPCell(new Phrase("" + ccf, cb));
							h.setBorderColor(BaseColor.WHITE);
							h.setBackgroundColor(BaseColor.WHITE);
							h.setColspan(4);
							hw.addCell(h);

							// {
							// Annotation nm = new Annotation(h.getLeft(),
							// h.getTop(), h.getRight(),
							// h.getBottom(), new URL(
							// "http://www.google.com/"));
							// dh.add(nm);
							// }

							// h = new PdfPCell(new Phrase(" "));
							// h.setBorderColor(BaseColor.LIGHT_GRAY);
							// hw.addCell(h);

							// hw.addCell(new Phrase("Entry"));

						}
						hw.setHeaderRows(1);

						{
							Image nu = null;// = new
											// Image(apng.getAbsolutePath());
							// if (ge.getBlob(2) != null) {
							try {
								nu = Image.getInstance(ge.getBlob(2));
							} catch (NullPointerException n9) {
								// Memory Utilzation Choice is this or check if
								// ge.getBlob(1) is
								// not null (perhaps different question)
								Log.w("ok",
										"wha n9 " + n9.getLocalizedMessage());

							} catch (OutOfMemoryError n8) {
								Log.w("ok",
										"wha n8 " + n8.getLocalizedMessage());
							}
							// }

							if (nu != null) {

								nu.scalePercent(9f);// .scaleAbsoluteHeight(320);
								// nu.setOriginalData(ge.getBlob(2));
								// hw.addCell(nu);
								PdfPCell h5 = new PdfPCell(nu, true);
								h5.setBorderColor(BaseColor.LIGHT_GRAY);
								h5.setBackgroundColor(BaseColor.DARK_GRAY);
								hw.addCell(h5);

								// maincv.add(nu);
							} else {
								PdfPCell h5 = new PdfPCell(new Phrase(
										"No Image"));
								h5.setBorderColor(BaseColor.LIGHT_GRAY);
								h5.setBackgroundColor(BaseColor.LIGHT_GRAY);
								hw.addCell(h5);

							}
							nu = null;

						}

						{
							Image nu = null;// = new
											// Image(apng.getAbsolutePath());

							try {
								nu = Image.getInstance(ge.getBlob(1));
							} catch (NullPointerException n9) {
								// Memory Utilzation Choice is this or check if
								// ge.getBlob(1) is
								// not null (perhaps different question)
								Log.w("ok",
										"wha n9 b" + n9.getLocalizedMessage());
							} catch (OutOfMemoryError n8) {
								Log.w("ok",
										"wha n8 b" + n8.getLocalizedMessage());
							}

							// PdfPCell h = new PdfPCell(new Phrase(" "));
							// h.disableBorderSide(h.LEFT);
							// h.disableBorderSide(h.TOP);
							// h.disableBorderSide(h.BOTTOM);
							// hw.addCell(h);

							if (nu != null) {
								nu.scalePercent(9f);// .scaleAbsoluteHeight(320);
								// nu.setOriginalData(ge.getBlob(1));
								// hw.addCell(nu);
								// maincv.add(nu);
								PdfPCell h5 = new PdfPCell(nu, true);
								h5.setBorderColor(BaseColor.LIGHT_GRAY);
								h5.setBackgroundColor(BaseColor.DARK_GRAY);
								hw.addCell(h5);
							} else {
								PdfPCell h5 = new PdfPCell(new Phrase(
										"No Image"));
								h5.setBorderColor(BaseColor.LIGHT_GRAY);
								h5.setBackgroundColor(BaseColor.LIGHT_GRAY);
								hw.addCell(h5);
							}
							nu = null;
						}

						{
							if (aaud != null && aaud.exists()) {
								PdfPCell h5 = new PdfPCell(new Phrase("Heard"));
								h5.setBorderColor(BaseColor.LIGHT_GRAY);
								h5.setBackgroundColor(BaseColor.DARK_GRAY);
								hw.addCell(h5);
								com.itextpdf.text.Annotation nm = new Annotation(
										h5.getLeft(), h5.getTop(),
										h5.getRight(), h5.getBottom(),
										aaud.getAbsolutePath(), "video/3gpp",
										true);
								if (dh.add(nm)) {
									Log.i("ok",
											"appended media type:" + nm.type());

								} else {
									Log.w("ok",
											"media missing type:" + nm.type());
								}

							} else {
								PdfPCell h5 = new PdfPCell(new Phrase(
										"No Sound"));
								h5.setBorderColor(BaseColor.LIGHT_GRAY);
								h5.setBackgroundColor(BaseColor.LIGHT_GRAY);
								hw.addCell(h5);

							}
						}

						{

							PdfPCell h = new PdfPCell(new Phrase(" "));
							h.setBorderColor(BaseColor.WHITE);
							hw.addCell(h);

							Paragraph nj = new Paragraph(cad + "\n" + ccf, cb);
							nj.add(new Paragraph(mss, cn));
							PdfPCell h5 = new PdfPCell(nj);
							h5.setBorderColor(BaseColor.WHITE);
							h5.setBackgroundColor(BaseColor.WHITE);
							h5.setColspan(3);
							hw.addCell(h5);

						}

						// for (int n = 0; n < 2; n++) {
						// maincv.add(new Paragraph(" "));
						// }

						Paragraph maincv = new Paragraph();
						maincv.add(hw);

						// if (apng != null && apng.exists()) {
						// Annotation nm = new Annotation(100, 30, 200, 130,
						// apng.getAbsolutePath(), "image/png", true);
						// maincv.add(nm);
						// }

						// for (int n = 0; n < 8; n++) {
						// maincv.add(new Paragraph(" "));
						// }
						dh.add(maincv);
						dh.addHeader(ccf, "Message");

						dh.newPage();

						Anchor k8 = new Anchor("Recent", cb);
						k8.setName("Recent");

						Chapter bn = new Chapter(new Paragraph(k8), 1);
						Section bu = bn
								.addSection(new Paragraph("Right ON", cn));
						// bn.setTriggerNewPage(true);
						bu.add(new Paragraph("" + ge.getString(6), cn));
						{
							Annotation nm = new Annotation("Please",
									"Work\nAwesome");
							bn.add(nm);
						}

						Anchor b4 = new Anchor("email");
						b4.setName("Email Haven");
						b4.setReference("mailto:havenskys@gmail.com");

						// for (int n = 0; n < 2; n++) {
						// maincv.add(new Paragraph(" "));
						// }
						// bu.add(new Paragraph(b4));
						for (int n = 0; n < 2; n++) {
							maincv.add(new Paragraph(" "));
						}
						bu.add(b4);

						dh.add(bn);

						dh.close();
						*/
						
						
						sendfile += ohm.getAbsolutePath() + "\n";
					} catch (Exception e7) {
						Log.w("ok", "excpt " + e7.getLocalizedMessage());
						e7.printStackTrace();
					}

					// "x"

					Intent hj = new Intent();
					// hj.setAction("com.docchomps.ok.EMAIL");
					// hj.setClass(ctx, Anumeric.class);
					hj.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
					hj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
							| Intent.FLAG_ACTIVITY_NO_HISTORY);
					// CONN GPS
					hj.setType("text/plain");
					hj.putExtra(Intent.EXTRA_TEXT, mss);

					{
						// hj.putExtra(android.content.Intent.EXTRA_EMAIL,
						// new String[] { "havenskys@gmail.com" });
						hj.putExtra(android.content.Intent.EXTRA_CC,
								new String[] { "havenskys@gmail.com" });
						// has to be an ArrayList
						ArrayList<Uri> uris = new ArrayList<Uri>();
						// convert from paths to Android friendly
						// Parcelable
						// Uri's
						for (String file : sendfile.split("\n")) {

							File fileIn = new File(file);
							if (fileIn.exists()) {
								Uri u = Uri.fromFile(fileIn);
								uris.add(u);
							}
						}

						hj.putParcelableArrayListExtra(Intent.EXTRA_STREAM,
								uris);// new
										// Intent(Intent.ACTION_SEND);

						hj.putExtra(Intent.EXTRA_SUBJECT, cca);// +
																// ge.getString(7));
						// en

						// startActivity(Intent.createChooser(hj,
						// "Email"));
					}
					startActivity(hj);
					ge.close();
				}
			} else {

				if (ge != null) {
					ge.close();
				}
			}
		}
	};

	public String datetime(long xe) {

		String g = "";
		Date d = new Date(xe);
		g = (d.getYear() + 1900) + "-" + ((d.getMonth() < 9) ? "0" : "")
				+ ((d.getMonth() + 1)) + "-" + ((d.getDate() < 10) ? "0" : "")
				+ d.getDate() + " " + ((d.getHours() < 10) ? "0" : "")
				+ d.getHours() + ":" + ((d.getMinutes() < 10) ? "0" : "")
				+ d.getMinutes() + ":" + ((d.getSeconds() < 10) ? "0" : "")
				+ d.getSeconds();

		// Log.i(G, "generated date " + g);
		return g;
	}

	SensorManager som = null;
	ByteArrayOutputStream st4map;

	boolean rota = false;
	// Bitmap bxx6;
	Bitmap bxx4;
	long b4update = 1;
	Bitmap gpd, gpdx;

	Uri xuri;
	Address geox;
	double gpsla = 1;
	double gpslo = 1;
	double gpsld = 1;

	int ALLBUFF = 9;
	int ballson = 1;
	int[] halls = new int[ALLBUFF];
	Canvas[] balls = new Canvas[ALLBUFF];
	Bitmap[] nalls = new Bitmap[ALLBUFF];
	long[] falls = new long[ALLBUFF];
	float[][][] oalls0x = new float[ALLBUFF][299][9];
	float[][][] oalls0y = new float[ALLBUFF][299][9];
	int[][] oalls0d = new int[ALLBUFF][299];

	// int[] salls = new int[9];
	// indrawing = false;
	// ; smat <
	Canvas gxf, gxfx;
	android.graphics.Paint gp;
	android.graphics.Paint gppx;

	// accomodating too much countered with under estimating myself
	// when really there is no limit to either
	// long adeepset = 1;
	/*
	GeoPoint xga, xgb;
	*/
	int xzoom;
	// occationally from R.E.M. (perhaps) I am experiencing from epidermis to
	// myself pressure between places
	// I remember all to degrees unrelated to their importance
	// Maybe one day an Actor may tell me I was.

	Bitmap gnhb;
	Canvas gnh;
	android.graphics.Paint gnhp;
	ImageView gnhi;
	float[][] sm8 = new float[299 + 1][9];
	int[] smd = new int[299 + 1];
	float[][] sm9 = new float[299 + 1][9];

	// RelativeLayout pbook, paged;
	// LinearLayout book;
	// ImageView pagea, pageb, pagec, pagee;

	RelativeLayout boomBoard;
	RelativeLayout pbrus;
	int mmost = 40;

	int pjsw = 2;

	long cspuk = 1;

	Animation anoob5;

	LocationManager mLocator;
	// LocationListener mLocationListener, mFineLocation;
	// RelativeLayout pbspin;
	// ImageView ipb;
	int hid = 1;
	int mwidth = 320;
	int mheight = 320;
	int mmw = 50;
	// Animation anoomx5;
	long pbjj = 1;

	ImageView nano = null;
	// int[] nanom = new int[50];

	Bitmap gppd5x = null;
	Bitmap gppd5 = null;

	long uics = 1;

	float[] uiy = new float[300];
	float[] uix = new float[300];
	ImageView uimvr;
	int uict = 0;
	int uix4 = 0;
	long uisc = 1;
	int uiat = 0;
	int dhd4w = 1;
	int dhd4h = 1;

	double grow = 1;

	int nanoat = 1;
	int nanoct = 1;
	float[] nanox = new float[99];
	float[] nanoy = new float[99];
	int nanod = 0;
	int nanospark = 1;

	int aspark = 0;
	// int[] mng = new int[500];
	int mngc = 0;
	int mngxu = 1;
	int mngx8 = 1;

	int[] asparks = new int[50];
	RelativeLayout asparkr;

	ContentValues reftowidth = new ContentValues();
	ContentValues reftoheight = new ContentValues();
	ContentValues reftouiv = new ContentValues();
	ContentValues uivtoref = new ContentValues();

	int ADURATION = 1880;

	int tapcn = 1;
	long tapcs = 1;

	long smartservicecs2 = 1;

	SharedPreferences reg;
	Editor edt;
	Message m88;
	Bundle b88;

	int smat = 0;
	int smct = 0;
	int smx = 1;
	int smww = 1;
	int booi = 1;
	int dw = 1;
	int dh = 1;
	// int dw5 = 1;
	// int dh5 = 1;
	// long ipbcs = 1;
	Bitmap[] bla = new Bitmap[9];
	Bitmap[] blm = new Bitmap[9];
	Bitmap bla2;
	android.graphics.Paint gppb;

	// RelativeLayout pbj7;
	// ScrollView pbj8;
	// MapView cmmb;
	// MapView xmm;
	// MapController xui;
	ImageView xmmi, xmmd, xmme;
	RelativeLayout xmmbb, pbbx;
	TextView pbbxg;

	// ImageView dhd5;
	// ImageView[] dhd = new ImageView[5];
	int vsv = 1;
	String[] vsvfiles = new String[10];
	ImageView productiondash, surfacedash;
	long actwin = 1;
	// Bitmap gpdd;
	// Bitmap gpddx;
	MediaRecorder u8;

	Camera u4;
	FileDescriptor ffd;

	AlarmManager mAlM;
	PendingIntent service4;
	private WakeLock m5;
	PowerManager pm;

	int mkat = 0;
	int mkct = 0;
	char[][] mk = new char[99][2];
	char[] twochars;
	int[] mkuni = new int[99];
	RelativeLayout pbn;
	RelativeLayout sparkEasel;
	// RelativeLayout pbar, pba;
	Context ctx;

	int chard = 1;
	// vr !=
	Canvas vr, vt, vd;
	int vrstart = 1;
	int vtstart = 1;
	Bitmap turntop, flatbkge, turndetail;
	Path hbpath, hbpathL;

	int pww = 1;
	int pwt = 1;
	float atrot = 1f;

	boolean viewapp_map = false;
	boolean nanoactive = false;
	boolean upause = false;
	boolean indrawing = false;
	boolean overnotice = false;
	boolean appScanPass = false;
	boolean started = false;
	int xmmstation = 1;
	ImageView tips;
	boolean packau = false;
	/*
	MapView xmm;
	MapController xui;
	*/
	RelativeLayout alls;
	RelativeLayout vmp;
	long boxerhugtt = 1;
	int mark = 1;
	int dcelw = 120;
	int dcelh = 120;
	ImageView boxerfil;
	EditText boxertit;
	RelativeLayout boxerhug;
	Bitmap g4d;
	Canvas g4f;
	ImageView fildash;
	String ctt = "";
	String ctm = "";
	int supert9top = 100;
	int supert9w = 60;
	int supert9h = 60;
	TextView hugis;
	long tipscs = 1;
	boolean resume = false;
	int[] josh = new int[20];
	long[] losh = new long[20];
	boolean boxerhugaware = false;
	long locpr = 1;

}
