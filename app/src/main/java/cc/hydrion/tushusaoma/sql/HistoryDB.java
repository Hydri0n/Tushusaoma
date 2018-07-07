package cc.hydrion.tushusaoma.sql;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cc.hydrion.tushusaoma.Bean.HistoryBook;
import cc.hydrion.tushusaoma.Entry.HistoryBookEntry;
import cc.hydrion.tushusaoma.Utils.SQLHelper.CallBack;

public class HistoryDB implements CallBack{

    private static final String DB_NAME = "test2.db";
    public static final String TABLE_NAME_1 = "history2";
    private static final int VERSION = 1;

    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE " + TABLE_NAME_1 + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " title TEXT," + "author TEXT," +
                    " isbn TEXT UNIQUE," + " time INTEGER)";

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
        //TODO
    }

    @Override
    public List<String> createTablesSQL() {
        return Arrays.asList(CREATE_TABLE_SQL);
    }

    @Override
    public <T> void assignValuesByEntity(String tableName, T entity, ContentValues values) {
        switch (tableName){
            case TABLE_NAME_1 :
                if (entity instanceof HistoryBook) {
                    HistoryBook historyBook = (HistoryBook) entity;
                    values.put(HistoryBookEntry.COLEUM_NAME_TITLE, historyBook.getTitle());
                    values.put(HistoryBookEntry.COLEUM_NAME_AUTHOR, historyBook.getAuthor());
                    values.put(HistoryBookEntry.COLEUM_NAME_ISBN, historyBook.getISBN());
                    values.put(HistoryBookEntry.COLEUM_NAME_TIME,historyBook.getTime());
                }
                break;
        }
    }

    @Override
    public Object newEntityByCursor(String tableName, Cursor cursor) {
        switch (tableName){
            case TABLE_NAME_1:
                return new HistoryBook(
                        cursor.getString(cursor.getColumnIndex(HistoryBookEntry.COLEUM_NAME_TITLE)),
                        cursor.getString(cursor.getColumnIndex(HistoryBookEntry.COLEUM_NAME_AUTHOR)),
                        cursor.getString(cursor.getColumnIndex(HistoryBookEntry.COLEUM_NAME_ISBN)));

        }
        return null;
    }
}
