package cc.hydrion.tushusaoma.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hydrion on 2018/3/1.
 */

public final class SQLHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static SQLHelper INSTANCE;
    private final CallBack mCallBack;

    public SQLHelper(Context context,CallBack callBack){
        super(context,callBack.getDatabaseName(),null,callBack.getVersion());
        this.mCallBack = callBack;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        List<String> tablesSQL = mCallBack.createTablesSQL();
        for (String sql : tablesSQL){
            sqLiteDatabase.execSQL(sql);
            System.out.println(sql + " !OK");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //TODO
    }

    public static void init(@NonNull Context context, @NonNull CallBack callBack) {
        INSTANCE = new SQLHelper(context, callBack);
    }

    public static <T> void insert(String tableName, T entity) {
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            INSTANCE.mCallBack.assignValuesByEntity(tableName, entity, values);
            db.insert(tableName, null, values);
            values.clear();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public static <T> void update(String tableName, T entity, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            INSTANCE.mCallBack.assignValuesByEntity(tableName, entity, values);
            db.update(tableName, values, whereClause, whereArgs);
            values.clear();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public static void delete(String tableName,String whereClause,String[] whereArgs){
        SQLiteDatabase db = INSTANCE.getWritableDatabase();
        db.beginTransaction();
        try{
            db.delete(tableName,whereClause,whereArgs);
            db.setTransactionSuccessful();
        }
        finally {
            db.endTransaction();
            db.close();
        }
    }

    public static <T> List<T> query(String tableName, @NonNull String queryStr, @Nullable String[] whereArgs) {
        SQLiteDatabase db = INSTANCE.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryStr, whereArgs);
        try {
            List<T> lists = new ArrayList<>(cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    T entity = (T) INSTANCE.mCallBack.newEntityByCursor(tableName, cursor);
                    if (entity != null) {
                        lists.add(entity);
                    }
                } while (cursor.moveToNext());
            }
            return lists;
        } finally {
            cursor.close();
            db.close();
        }

    }


    public interface CallBack {
        String getDatabaseName();

        int getVersion();

        void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

        List<String> createTablesSQL();

        <T> void assignValuesByEntity(String tableName, T entity, ContentValues values);

        <T> Object newEntityByCursor(String tableName, Cursor cursor);
    }
}
