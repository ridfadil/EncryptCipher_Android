package farid.com.sqlcipherfadil;

import android.os.Environment;

import java.io.File;

public class DB {

    public static final String DATABASE_NAME = "db_chiper";
    public static String BASE_PATH = Environment.getExternalStorageDirectory() + File.separator + "/COPPP/";
    public static String DATABASE_PATH = BASE_PATH + DATABASE_NAME;
    public static final int DATABASE_VERSION = 1;

    static final String TABLE_PARTICIPANTS = "participants";
    static final String ID = "participants";
    static final String NAMA = "nama";
    static final String NIM = "nim";
    static final String ALAMAT = "alamat";
    static final String ISKEY = "fadilah";

    static final String CREATE_TABLE_PARTICIPANTS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_PARTICIPANTS + "(" + ID + " INTEGER PRIMARY KEY, " +
                    NAMA + " TEXT, " + NIM + " TEXT, " + ALAMAT + " TEXT)";
}
