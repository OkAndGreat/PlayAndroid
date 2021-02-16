package com.example.playandroid.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context mContext;

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public static final String CREATE_BOOK = "create table item ("
            + "id integer primary key autoincrement,"
            + "link text, "
            + "fresh text, "
            + "author text, "
            + "ShareUser text, "
            + "title text, "
            + "des text, "
            + "nicedata text, "
            + "superchaptername text, "
            + "chaptername text)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
