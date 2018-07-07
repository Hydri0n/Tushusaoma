package cc.hydrion.tushusaoma.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Arrays;
import java.util.List;

import cc.hydrion.tushusaoma.Bean.BookLocation;
import cc.hydrion.tushusaoma.Entry.BookLocationEntry;
import cc.hydrion.tushusaoma.Utils.SQLHelper;

public class BookLocationDB implements SQLHelper.CallBack{

    private static final String DB_NAME = "test1.db";
    public static final String TABLE_NAME = "location1";
    private static final int VERSION = 1;

    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " location TEXT UNIQUE," + "title TEXT," +
                    " time INTEGER)";

    @Override
    public String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    public int getVersion() {
        return VERSION;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public List<String> createTablesSQL() {
        return Arrays.asList(CREATE_TABLE_SQL);
    }

    @Override
    public <T> void assignValuesByEntity(String tableName, T entity, ContentValues values) {
        switch (tableName){
            case TABLE_NAME :
                if (entity instanceof BookLocation) {
                    BookLocation historyBook = (BookLocation) entity;
                    values.put(BookLocationEntry.COLEUM_NAME_TITLE, historyBook.getTitle());
                    values.put(BookLocationEntry.COLEUM_NAME_LOCATION, historyBook.getLocation());
                    values.put(BookLocationEntry.COLEUM_NAME_TIME,historyBook.getTime());
                }
                break;
        }
    }

    @Override
    public Object newEntityByCursor(String tableName, Cursor cursor) {
        switch (tableName){
            case TABLE_NAME:
                return new BookLocation(
                        cursor.getString(cursor.getColumnIndex(BookLocationEntry.COLEUM_NAME_LOCATION)),
                        cursor.getString(cursor.getColumnIndex(BookLocationEntry.COLEUM_NAME_TITLE)));

        }
        return null;
    }
}
