package com.docchomps.ok;

import java.util.Date;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class DataProvider extends ContentProvider {
	// private static String mainuri = August.dataprovider;
	private static final int DB_VERSION = 22;

	private static String TAG = "DataProvider";

	private SQLiteDatabase mDb;
	private DatabaseHelper mDbHelper;

	private static String DATABASE_NAME = "moment.db";

	private static final int ALL_MESSAGES = 1;
	private static final int SPECIFIC_MESSAGE = 2;

	private static final int ALL_MESSAGESFILTER = 3;
	private static final int SPECIFIC_MESSAGEFILTER = 4;

	private static final int ALL_MESSAGESPERSPECTIVE = 5;
	private static final int SPECIFIC_MESSAGEPERSPECTIVE = 6;

	private static final int ALL_MESSAGESRETROSPECT = 7;
	private static final int SPECIFIC_MESSAGERETROSPECT = 8;

	private static final int ALL_MESSAGESXSAW = 9;
	private static final int SPECIFIC_MESSAGEXSAW = 10;

	// private static String cp = getContext().getString(R.string.cp);
	private static final UriMatcher URI_MATCHER;
	static {

		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		URI_MATCHER.addURI("*", "*", ALL_MESSAGES);
		URI_MATCHER.addURI("*", "*/#", SPECIFIC_MESSAGE);

		// URI_MATCHER.addURI(cp, "moment", ALL_MESSAGES);
		// URI_MATCHER.addURI(getContext().getString(R.string.cp), "moment/#",
		// SPECIFIC_MESSAGE);
		// URI_MATCHER.addURI(getContext().getString(R.string.cp),
		// "perspective", ALL_MESSAGESPERSPECTIVE);
		// URI_MATCHER.addURI(getContext().getString(R.string.cp),
		// "perspective/#", SPECIFIC_MESSAGEPERSPECTIVE);
		// URI_MATCHER.addURI(getContext().getString(R.string.cp), "retrospect",
		// ALL_MESSAGESPERSPECTIVE);
		// URI_MATCHER.addURI(getContext().getString(R.string.cp),
		// "retrospect/#", SPECIFIC_MESSAGEPERSPECTIVE);
		// URI_MATCHER.addURI(getContext().getString(R.string.cp), "filter",
		// ALL_MESSAGESFILTER);
		// URI_MATCHER.addURI(getContext().getString(R.string.cp), "filter/#",
		// SPECIFIC_MESSAGEFILTER);
		// "+getString(R.string.cp)+"
	}

	public static final Uri CONTENT_URI = Uri
			.parse("content://com.docchomps.ok");

	// url text unique not null, urltext text, farkpicurl text, farkpictext
	// text, commenturl text, commenttext text, description text

	// Database creation/version management helper.
	// Create it statically because we don't need to have customized instances.
	private static class DatabaseHelper extends SQLiteOpenHelper {

		private static String TAG = "DataProviderDB";

		private Context mContext;

		// public DatabaseHelper(Context context, String name, CursorFactory
		// factory, int version) {
		// super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		// }
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DB_VERSION);
			mContext = context;
			// mLog = new Custom(mContext, TAG + " DatabaseHelper() 52");
			Log.i(TAG, "DatabaseHelper() 53");

		}

		SQLiteDatabase db = null;

		@Override
		public void onCreate(SQLiteDatabase db2) {
			db = db2;
			Log.i(TAG, "DatabaseHelper onCreate() ++++++++++++++++++++++++");
			try {
				// SQL += mContext.getString(R.string.contactStore_columns);

				{
					String SQL = "";
					SQL += "create table IF NOT EXISTS moment (";
					SQL += "_id integer primary key autoincrement ";
					// SQL += ", url text, rurl text";
					// SQL +=
					// ", title text, summary text, published DATE, content text, author text";
					SQL += ", atitle text, acontent text, afront blob, aback blob, aslide blob, aslope blob";
					SQL += ", amap blob, amapo blob, lat double, lon double, adeep int, aloclist text, aheardlist text";

					SQL += ", created DATE";
					SQL += ", updated DATE";
					SQL += ", status INTEGER default 1"; // < 0 deleted(value *
															// -1),
															// 1
															// active(created),
															// ++
															// per update
					SQL += ");\n";
					db.execSQL(SQL);

					db.execSQL("create index IF NOT EXISTS moment_lat on moment(lat);");
					db.execSQL("create index IF NOT EXISTS moment_lon on moment(lon);");
					db.execSQL("create index IF NOT EXISTS moment_atitle on moment(atitle);");
					// db.execSQL("create index IF NOT EXISTS moment_url on moment(url);");
					// db.execSQL("create index IF NOT EXISTS moment_published_title_url on moment(published,title,url);");
					// db.execSQL("create index IF NOT EXISTS moment_published on moment(published);");
					db.execSQL("create index IF NOT EXISTS moment_updated on moment(updated);");
					db.execSQL("create index IF NOT EXISTS moment_created on moment(created);");
					db.execSQL("create index IF NOT EXISTS moment_status on moment(status);");
				}

				{
					String SQL = "";
					SQL += "create table IF NOT EXISTS refplay (";
					SQL += "_id integer primary key autoincrement ";
					// SQL += ", url text, rurl text";
					// SQL +=
					// ", title text, summary text, published DATE, content text, author text";
					SQL += ", aspark int default 0";
					SQL += ", atref int default 0";
					SQL += ", attable text";
					SQL += ", atcolumn text";
					SQL += ", atwidth int default 0";
					SQL += ", atheight int default 0";
					SQL += ", atx int default 0";
					SQL += ", aty int default 0";
					SQL += ", created DATE";
					SQL += ", updated DATE";
					SQL += ", status INTEGER default 1"; // < 0 deleted(value *
															// -1),
															// 1
															// active(created),
															// ++
															// per update
					SQL += ");\n";
					db.execSQL(SQL);

					db.execSQL("create index IF NOT EXISTS refplay_aspark on refplay(aspark);");
					db.execSQL("create index IF NOT EXISTS refplay_atref on refplay(atref);");
					// db.execSQL("create index IF NOT EXISTS refplay_atrefaspark on refplay(atref,aspark);");
					// db.execSQL("create index IF NOT EXISTS moment_published_title_url on moment(published,title,url);");
					// db.execSQL("create index IF NOT EXISTS moment_published on moment(published);");
					db.execSQL("create index IF NOT EXISTS refplay_updated on refplay(updated);");
					db.execSQL("create index IF NOT EXISTS refplay_created on refplay(created);");
					db.execSQL("create index IF NOT EXISTS refplay_status on refplay(status);");
				}

				{
					String SQL = "";
					SQL += "create table IF NOT EXISTS contact (";
					SQL += "_id integer primary key autoincrement ";
					// SQL += ", url text, rurl text";
					// SQL +=
					// ", title text, summary text, published DATE, content text, author text";
					SQL += ", mms text";
					SQL += ", email text";
					SQL += ", display text";
					SQL += ", rotation int default 180";
					SQL += ", created DATE";
					SQL += ", updated DATE";
					SQL += ", status INTEGER default 1"; // < 0 deleted(value *
															// -1),
															// 1
															// active(created),
															// ++
															// per update
					SQL += ");\n";
					db.execSQL(SQL);

					db.execSQL("create index IF NOT EXISTS contact_mms on contact(mms);");
					db.execSQL("create index IF NOT EXISTS contact_email on contact(email);");
					db.execSQL("create index IF NOT EXISTS contact_display on contact(display);");
					// db.execSQL("create index IF NOT EXISTS moment_published_title_url on moment(published,title,url);");
					// db.execSQL("create index IF NOT EXISTS moment_published on moment(published);");
					db.execSQL("create index IF NOT EXISTS contact_updated on contact(updated);");
					db.execSQL("create index IF NOT EXISTS contact_created on contact(created);");
					db.execSQL("create index IF NOT EXISTS contact_status on contact(status);");
				}
				{
					String SQL = "";
					SQL += "create table IF NOT EXISTS checkin (";
					SQL += "_id integer primary key autoincrement ";
					// SQL += ", url text, rurl text";
					// SQL +=
					// ", title text, summary text, published DATE, content text, author text";
					// SQL += ", mms text";
					// SQL += ", email text";
					SQL += ", atitle text";
					SQL += ", anext DATE";
					SQL += ", atill DATE, atillset int default 0";
					SQL += ", rotation int default 180";
					SQL += ", created DATE";
					SQL += ", updated DATE";
					SQL += ", status INTEGER default 1"; // < 0 deleted(value *
															// -1),
															// 1
															// active(created),
															// ++
															// per update
					SQL += ");\n";
					db.execSQL(SQL);

					db.execSQL("create index IF NOT EXISTS checkin_atitle on checkin(atitle);");
					db.execSQL("create index IF NOT EXISTS checkin_anext on checkin(anext);");
					db.execSQL("create index IF NOT EXISTS checkin_atill on checkin(atill);");
					// db.execSQL("create index IF NOT EXISTS moment_published_title_url on moment(published,title,url);");
					// db.execSQL("create index IF NOT EXISTS moment_published on moment(published);");
					db.execSQL("create index IF NOT EXISTS checkin_updated on checkin(updated);");
					db.execSQL("create index IF NOT EXISTS checkin_created on checkin(created);");
					db.execSQL("create index IF NOT EXISTS checkin_status on checkin(status);");
				}

				/*
				 * db.execSQL(
				 * "create table IF NOT EXISTS retrospect (_id integer primary key autoincrement, filterid integer, filtered date, title text, url text, rurl text, hostname text, docpath text, ipaddress text, port integer, responsems integer, cookies text, body text, header text, charset text, contenttype text, contentlength int, protostatus text, updated date, created date, status integer default 1 ) "
				 * ); db.execSQL(
				 * "create index IF NOT EXISTS retrospect_filtered on retrospect(filtered)"
				 * ); db.execSQL(
				 * "create index IF NOT EXISTS retrospect_updated on retrospect(updated)"
				 * ); db.execSQL(
				 * "create index IF NOT EXISTS retrospect_hostname on retrospect(hostname)"
				 * ); db.execSQL(
				 * "create index IF NOT EXISTS retrospect_docpath on retrospect(docpath)"
				 * );
				 * 
				 * db.execSQL(
				 * "create table IF NOT EXISTS xsaw (_id integer primary key autoincrement, mid integer, content text , updated date, created date, status integer default 1 )"
				 * );
				 * db.execSQL("create index IF NOT EXISTS xsaw_mim on xsaw(mid)"
				 * ); db.execSQL(
				 * "create index IF NOT EXISTS xsaw_updated on xsaw(created)");
				 * db.execSQL(
				 * "create index IF NOT EXISTS xsaw_updated on xsaw(updated)");
				 * //
				 */

				// db.execSQL("insert into moment (_id,title,content,published,author) values (NULL, 'Request', 'New installation of data set.','"+datetime()+"','Haven');");

				// db.execSQL("create index moment_created on moment(created);");

				// db.execSQL("insert into moment (_id,title) values (null,\"Created Database\"");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public String datetime() {
			String g = "";
			Date d = new Date();
			g = (d.getYear() + 1900) + "-" + ((d.getMonth() < 9) ? "0" : "")
					+ ((d.getMonth() + 1)) + "-"
					+ ((d.getDate() < 10) ? "0" : "") + d.getDate() + " "
					+ ((d.getHours() < 10) ? "0" : "") + d.getHours() + ":"
					+ ((d.getMinutes() < 10) ? "0" : "") + d.getMinutes()
					+ ":00";
			// Log.i(TAG,"generated date "+g);
			return g;
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.i(TAG, "DatabaseHelper onUpgrade() ++++++++++++++++++++++++");
			db.execSQL("DROP TABLE IF EXISTS " + "moment");
			onCreate(db);
		}

	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// mLog.w(TAG,"delete() uri("+uri+") lastsegment("+uri.getLastPathSegment()+")");
		int rowCount = mDb.delete(uri.getLastPathSegment(), selection,
				selectionArgs);

		// Notify any listeners and return the deleted row count.
		getContext().getContentResolver().notifyChange(uri, null);
		return rowCount;

	}

	@Override
	public String getType(Uri uri) {

		switch (URI_MATCHER.match(uri)) {
		case ALL_MESSAGES:
			// Log.w(TAG,"gettype() uri("+uri+") ALL MESSAGES");
			return "vnd.android.cursor.dir/moment"; // List of items.
		case SPECIFIC_MESSAGE:
			// Log.w(TAG,"gettype() uri("+uri+") Specific Message");
			return "vnd.android.cursor.item/moment"; // Specific item.
		case ALL_MESSAGESPERSPECTIVE:
			// Log.w(TAG,"gettype() uri("+uri+") ALL MESSAGES");
			return "vnd.android.cursor.dir/perspective"; // List of items.
		case SPECIFIC_MESSAGEPERSPECTIVE:
			// Log.w(TAG,"gettype() uri("+uri+") Specific Message");
			return "vnd.android.cursor.item/perspective"; // Specific item.
		case ALL_MESSAGESXSAW:
			// Log.w(TAG,"gettype() uri("+uri+") ALL MESSAGES");
			return "vnd.android.cursor.dir/xsaw"; // List of items.
		case SPECIFIC_MESSAGEXSAW:
			// Log.w(TAG,"gettype() uri("+uri+") Specific Message");
			return "vnd.android.cursor.item/xsaw"; // Specific item.
		case ALL_MESSAGESRETROSPECT:
			// Log.w(TAG,"gettype() uri("+uri+") ALL MESSAGES");
			return "vnd.android.cursor.dir/retrospect"; // List of items.
		case SPECIFIC_MESSAGERETROSPECT:
			// Log.w(TAG,"gettype() uri("+uri+") Specific Message");
			return "vnd.android.cursor.item/retrospect"; // Specific item.
		case ALL_MESSAGESFILTER:
			// Log.w(TAG,"gettype() uri("+uri+") ALL MESSAGES");
			return "vnd.android.cursor.dir/filter"; // List of items.
		case SPECIFIC_MESSAGEFILTER:
			// Log.w(TAG,"gettype() uri("+uri+") Specific Message");
			return "vnd.android.cursor.item/filter"; // Specific item.
		case -1:
			Log.e(TAG, "getType(-1) uri(" + uri + ")");
			return "vnd.android.cursor.item/moment";
		default:
			Log.e(TAG, "getType() uri(" + uri + ")");
			return "vnd.android.cursor.item/moment";
		}
	}

	public String datetime() {
		String g = "";
		Date d = new Date();

		g = (d.getYear() + 1900) + "-" + ((d.getMonth() < 9) ? "0" : "")
				+ ((d.getMonth() + 1)) + "-" + ((d.getDate() < 10) ? "0" : "")
				+ d.getDate() + " " + ((d.getHours() < 10) ? "0" : "")
				+ d.getHours() + ":" + ((d.getMinutes() < 10) ? "0" : "")
				+ d.getMinutes() + ":" + ((d.getSeconds() < 10) ? "0" : "")
				+ d.getSeconds();
		// Log.i(TAG,"generated date "+g);
		return g;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		if (mDb == null) {
			return null;
		}
		long rowId = -1;
		// Log.w(TAG,"insert() uri("+uri+") lastsegment("+uri.getLastPathSegment()+")");
		String tablename = uri.getLastPathSegment();
		values.put("created", datetime());
		values.put("updated", datetime());
		rowId = mDb.insertOrThrow(tablename, "rawcontent", values);
		Uri newUri = Uri.withAppendedPath(CONTENT_URI, tablename + "/" + rowId);
		// mLog.w(TAG,"insert()  newUri(" + newUri.toString() + ")");

		// Notify any listeners and return the URI of the new row.
		getContext().getContentResolver().notifyChange(CONTENT_URI, null);

		/*
		 * / if( rowId > 100 ){ int del = (int) (rowId - 100);
		 * mDb.execSQL("update " + DATABASE_TABLE_NAME + " set "+ CONTENT
		 * +" = \"\" where _id < "+del+" "); } //
		 */

		return newUri;

	}

	@Override
	public boolean onCreate() {

		// mLog = new Custom(this.getContext(), TAG + " onCreate() 130");
		mDbHelper = new DatabaseHelper(getContext());

		// final Context con = getContext();
		try {
			mDb = mDbHelper.getWritableDatabase();

			if (mDb != null) {
				Log.w(TAG, "db updates");

				/*
				 * mDb.execSQL(
				 * "create index IF NOT EXISTS moment_title on moment(title);");
				 * mDb
				 * .execSQL("create index IF NOT EXISTS moment_url on moment(url);"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS moment_published_title_url on moment(published,title,url);"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS moment_published on moment(published);"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS moment_updated on moment(updated);"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS moment_created on moment(created);"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS moment_status on moment(status);"
				 * );
				 * 
				 * Cursor d = mDb.query("moment", new String[] { "*" }, "",
				 * null, null, null, "_id LIMIT 1"); if (d == null) { Log.e(TAG,
				 * "Get one row failed"); } else {
				 * 
				 * String[] c = d.getColumnNames(); Log.i(TAG,
				 * "Data Store Upgrade");
				 * 
				 * // if (d.getColumnIndex("itype") == -1) { //
				 * mDb.execSQL("alter table moment add column itype text default ''"
				 * ); // mDb.execSQL(
				 * "create index IF NOT EXISTS moment_itype on moment(itype);");
				 * // }
				 * 
				 * if (d.getColumnIndex("cox") == -1) {
				 * mDb.execSQL("alter table moment add column cox integer");
				 * mDb.
				 * execSQL("create index IF NOT EXISTS moment_cox on moment(cox);"
				 * ); }
				 * 
				 * if (d.getColumnIndex("coxy") == -1) {
				 * mDb.execSQL("alter table moment add column coxy integer");
				 * mDb.execSQL(
				 * "create index IF NOT EXISTS moment_coxy on moment(coxy);"); }
				 * if (d.getColumnIndex("coxyz") == -1) {
				 * mDb.execSQL("alter table moment add column coxyz integer");
				 * mDb.execSQL(
				 * "create index IF NOT EXISTS moment_coxyz on moment(coxyz);");
				 * } if (d.getColumnIndex("sample") == -1) {
				 * mDb.execSQL("alter table moment add column sample blob"); }
				 * if (d.getColumnIndex("visited") == -1) {
				 * mDb.execSQL("alter table moment add column visited date");
				 * mDb.execSQL(
				 * "create index IF NOT EXISTS moment_visited on moment(visited);"
				 * ); }
				 * 
				 * if (d.getColumnIndex("itext") == -1) {
				 * mDb.execSQL("alter table moment add column itext text");
				 * mDb.execSQL
				 * ("create index IF NOT EXISTS moment_itext on moment(itext);"
				 * ); } if (d.getColumnIndex("contenttype") == -1) {
				 * mDb.execSQL(
				 * "alter table moment add column contenttype text"); } if
				 * (d.getColumnIndex("language") == -1) {
				 * mDb.execSQL("alter table moment add column language text"); }
				 * if (d.getColumnIndex("mid") == -1) {
				 * mDb.execSQL("alter table moment add column mid integer");
				 * mDb.
				 * execSQL("create index IF NOT EXISTS moment_mid on moment(mid);"
				 * ); } if (d.getColumnIndex("updatemin") == -1) { mDb.execSQL(
				 * "alter table moment add column updatemin integer default 0");
				 * mDb.execSQL(
				 * "create index IF NOT EXISTS moment_updatemin on moment(updatemin);"
				 * ); }
				 * 
				 * if (d.getColumnIndex("filtered") == -1) {
				 * mDb.execSQL("alter table moment add column filtered TEXT"); }
				 * if (d.getColumnIndex("foundtitle") == -1) {
				 * mDb.execSQL("alter table moment add column foundtitle TEXT");
				 * } if (d.getColumnIndex("images") == -1) {
				 * mDb.execSQL("alter table moment add column images TEXT"); }
				 * if (d.getColumnIndex("prefilter") == -1) {
				 * mDb.execSQL("alter table moment add column prefilter TEXT");
				 * } if (d.getColumnIndex("source") == -1) {
				 * mDb.execSQL("alter table moment add column source TEXT"); }
				 * if (d.getColumnIndex("textcontent") == -1) {
				 * mDb.execSQL("alter table moment add column textcontent TEXT"
				 * ); } if (d.getColumnIndex("urls") == -1) {
				 * mDb.execSQL("alter table moment add column urls TEXT"); } if
				 * (d.getColumnIndex("js") == -1) {
				 * mDb.execSQL("alter table moment add column js TEXT"); }
				 * 
				 * if (d.getColumnIndex("filterid") == -1) {
				 * mDb.execSQL("alter table moment add column filterid integer"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS moment_filterid on moment(filterid);"
				 * ); }
				 * 
				 * if (d.getColumnIndex("retrospectid") == -1) {
				 * mDb.execSQL("alter table moment add column retrospectid integer"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS moment_retrospectid on moment(retrospectid);"
				 * ); }
				 * 
				 * if (d.getColumnIndex("part") == -1) {
				 * mDb.execSQL("alter table moment add column part int"); }
				 * 
				 * }
				 * 
				 * mDb.execSQL(
				 * "create table IF NOT EXISTS filter (_id integer primary key autoincrement,title text,filtercode text, filtered date,location text,hostname text,prefilter text,sr date, srview text, srdate date, ipaddress text, port integer, responsems integer, cookies text, trailsource text, split text, parse_item text, parse_link text, parse_title text, parse_author text, parse_content text, parse_published date, parse_build date, updated date, created date, status integer default 1 ) "
				 * );
				 * mDb.execSQL("create index IF NOT EXISTS filter_sr on filter(sr)"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS filter_updated on filter(updated)"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS filter_status on filter(status)"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS filter_location on filter(location)"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS filter_hostname on filter(hostname)"
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS filter_loccre on filter(location,created)"
				 * );
				 * 
				 * mDb.execSQL(
				 * "create table IF NOT EXISTS perspective (_id integer primary key autoincrement,title text, location text, detail text, cux float, cuy float, cuz float, aux float, auy float, auz float, updated date, created date, status integer default 1 ) "
				 * ); mDb.execSQL(
				 * "create index IF NOT EXISTS perspective_updated on perspective(updated)"
				 * ); //
				 */
			}

			// mDb = mDbHelper.openDatabase(getContext(), DATABASE_NAME, null,
			// DB_VERSION);
			// mLogger.info("RssContentProvider.onCreate(): Opened a database");
		} catch (Exception ex) {
			Log.e(TAG, "Failed to connected to Database, exception");
			ex.printStackTrace();
			return false;
		}
		if (mDb == null) {
			Log.e(TAG, "Failed to connected to Database, mDb null");
			return false;
		} else {

			return true;
		}

	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {

		if (mDb == null) {
			return null;
		}
		// Log.i(TAG,"query() uri("+uri+") type("+getType(uri)+") lastsegment("+uri.getLastPathSegment()+") fragment("+uri.getFragment()+") selection("+selection+")");

		SQLiteQueryBuilder qBuilder = new SQLiteQueryBuilder();

		String tablename = uri.getLastPathSegment();
		String recordid = "";
		if (getType(uri).contentEquals("vnd.android.cursor.item/moment")) {
			recordid = uri.getLastPathSegment();
			tablename = "moment";
		} else if (getType(uri).contentEquals("vnd.android.cursor.item/filter")) {
			recordid = uri.getLastPathSegment();
			tablename = "filter";
		} else if (getType(uri).contentEquals(
				"vnd.android.cursor.item/perspective")) {
			recordid = uri.getLastPathSegment();
			tablename = "perspective";
		}

		// Set the table we're querying.
		qBuilder.setTables(tablename);

		// If the query ends in a specific record number, we're
		// being asked for a specific record, so set the
		// WHERE clause in our query.
		if (recordid.length() > 0) {
			qBuilder.appendWhere("_id=" + recordid);
		} else if (uri.getFragment() != null
				&& !uri.getFragment().contains("-1")) {// (URI_MATCHER.match(uri))
														// == SPECIFIC_MESSAGE){
			qBuilder.appendWhere("_id=" + uri.getFragment()); // +
																// uri.getPathLeafId());
		}
		// Set sort order. If none specified, use default.
		if (TextUtils.isEmpty(sortOrder)) {
			// sortOrder = Custom.DEFAULT_SORT_ORDER;
		}

		String groupby = null;
		String having = null;
		if (selection.toUpperCase().contains("GROUP BY")) {
			String us = selection.toUpperCase();

			groupby = selection.substring(
					us.indexOf("GROUP BY") + 8,
					us.indexOf("HAVING") > -1 ? us.indexOf("HAVING") - 1 : us
							.length());
			if (us.contains("HAVING")) {
				having = selection.substring(us.indexOf("HAVING") + 6);
			}

			selection = selection.substring(0, us.indexOf("GROUP BY") - 1);
		}
		// Make the query.
		Cursor c = qBuilder.query(mDb, projection, selection,// .replaceAll("\\\"",
																// "\\\\\""),
				selectionArgs, groupby, having, sortOrder);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;

	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {

		Log.i(TAG,
				"update() uri(" + uri + ") lastsegment("
						+ uri.getLastPathSegment() + ") selection(" + selection
						+ ")");

		String tablename = uri.getLastPathSegment();

		if (!values.containsKey("updated")) {
			values.put("updated", datetime());
		}
		// NOTE Argument checking code omitted. Check your parameters!
		int updateCount = mDb.update(tablename, values, selection,
				selectionArgs);

		// Notify any listeners and return the updated row count.
		// getContext().getContentResolver().notifyUpdate(uri, null);
		getContext().getContentResolver().notifyChange(uri, null);
		// Log.i(TAG,
		// "update() uri(" + uri + ") lastsegment("
		// + uri.getLastPathSegment() + ") selection(" + selection
		// + ") count("+updateCount+")");

		return updateCount;
	}

}
