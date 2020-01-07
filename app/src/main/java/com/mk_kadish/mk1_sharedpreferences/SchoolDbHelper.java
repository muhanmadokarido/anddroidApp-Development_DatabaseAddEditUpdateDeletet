package com.mk_kadish.mk1_sharedpreferences;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.projection.MediaProjection;
import android.util.Log;

public class SchoolDbHelper extends SQLiteOpenHelper
{
    public static final String database_name="school_db";
    public static final int database_version=1;
    public static final String table_create_statement=
            "CREATE TABLE " + SchoolContract.SchoolEntry.table_name + "("+ SchoolContract.SchoolEntry.school_id + " number PRIMARY KEY," + SchoolContract.SchoolEntry.school_name +
            " TEXT" + ")";
    public static final  String drop_table="DROP TABLE IF EXISTS "+ SchoolContract.SchoolEntry.table_name;

    public SchoolDbHelper(Context context)
    {
        super(context,database_name,null,database_version);
        Log.d("Database_Operation","DataBase Is Created....");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(table_create_statement);
        Log.d("Database_Operation","SchoolTable Is Created....");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_table);
        onCreate(db);
    }

    public void addSchool(int s_id , String s_name,SQLiteDatabase mydatabase)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(SchoolContract.SchoolEntry.school_id,s_id);
        contentValues.put(SchoolContract.SchoolEntry.school_name,s_name);
        mydatabase.insert(SchoolContract.SchoolEntry.table_name,null,contentValues);
        Log.d("Database_Operation","School Inserted To  Database....");
    }

    public Cursor readSchool(SQLiteDatabase database)
    {
        String[] projections={SchoolContract.SchoolEntry.school_id,SchoolContract.SchoolEntry.school_name};
        Cursor cursor=database.query(SchoolContract.SchoolEntry.table_name, projections,null,null,null,null,null);
        return cursor;
    }
    public void updateSchool(int id,String name,SQLiteDatabase mydatabase)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(SchoolContract.SchoolEntry.school_name,name);

        String selection=SchoolContract.SchoolEntry.school_id+" = "+ id;

        mydatabase.update(SchoolContract.SchoolEntry.table_name,contentValues,selection,null);
        
    }

    public void deleteSchool(int id,SQLiteDatabase mydatabase)
    {
        String selection=SchoolContract.SchoolEntry.school_id+" = "+ id;
        mydatabase.delete(SchoolContract.SchoolEntry.table_name,selection,null);

    }
}
