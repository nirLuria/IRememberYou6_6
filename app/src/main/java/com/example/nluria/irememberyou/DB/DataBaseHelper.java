package com.example.nluria.irememberyou.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nluria on 6/6/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME= "Singles.db";

    //ID - of the group, in all tables.

    //table of singles.
    public static final String Table= "Table_Of_singles";
    public static final String first_name= "FIRST_NAME";
    public static final String last_name= "LAST_NAME";
    public static final String age="AGE";
    public static final String gender="GENDER";




    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create new tables.
        db.execSQL("Create table "+ Table +" (FIRST_NAME TEXT PRIMARY KEY, LAST_NAME TEXT, AGE TEXT, GENDER TEXT) ");
        System.out.println("created clean database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table);

        onCreate(db);
    }


    public boolean insertNewPerson(String firstName, String lastName, String theAge, String theGender)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        //add the new person.
        contentValues.put(first_name, firstName);
        contentValues.put(last_name, lastName);
        contentValues.put(age, theAge);
        if (theGender.equals("בת"))
        {
            contentValues.put(gender, "female");
        }
        else
        {
            contentValues.put(gender, "male");
        }


        long result = db.insert(Table , null,contentValues );

        if (result== -1)
            return false;
        else
            return true;
    }

}
