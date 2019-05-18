package farid.com.sqlcipherfadil;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;

import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/*import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;*/

@SuppressLint({"Recycle", "SdCardPath", "NewApi", "SimpleDateFormat", "DefaultLocale"})
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DB.DATABASE_PATH, null, DB.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB.CREATE_TABLE_PARTICIPANTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB.TABLE_PARTICIPANTS);
        onCreate(db);
    }

    public boolean addParticipant(String name, String nim, String alamat) {
        SQLiteDatabase db = this.getWritableDatabase(DB.ISKEY);
        ContentValues values = new ContentValues();
        values.put(DB.NAMA, name);
        values.put(DB.NIM, nim);
        values.put(DB.ALAMAT, alamat);
        return db.insert(DB.TABLE_PARTICIPANTS, null, values) > 0;
    }

    public String getParticipant() {
        SQLiteDatabase db = this.getReadableDatabase(DB.ISKEY);
        String result = "";
        String qr = "SELECT * FROM " + DB.TABLE_PARTICIPANTS;
        Cursor cursor = db.rawQuery(qr, null);
        if (cursor.moveToFirst()) {
            do {
                result = result + " " + (cursor).getString((cursor).getColumnIndex(DB.NAMA));
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return result;
    }
}

