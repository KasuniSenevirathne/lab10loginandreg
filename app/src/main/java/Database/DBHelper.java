package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final  String DataBase = "DBClass.db";
    public DBHelper( Context context) {
        super(context, DataBase,null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE " +  Usermaster.UseEntery.TABLE_NAME  +" (" + Usermaster.UseEntery._ID + " INTEGER PRIMARY KEY ,"
                + Usermaster.UseEntery.COL_NAME1 + " TEXT," +
                  Usermaster.UseEntery.COL_NAME2 + " Text," +
                " Text," + Usermaster.UseEntery.COL_NAME3  + " TEXT);";
        db.execSQL(SQL);

        String SQL1 =  "CREATE TABLE " + Usermaster.MessageEntry.TABLE_NAME1 +" (" + Usermaster.MessageEntry._ID + " INTEGER PRIMARY KEY ,"
                + Usermaster.MessageEntry.COL_NAME4 + " Text," + Usermaster.MessageEntry.COL_NAME5 + " Text," +
                Usermaster.MessageEntry.COL_NAME6+ " text);" ;
        db.execSQL(SQL1);
    }
    public boolean AddData(String name, String password, String type){
        SQLiteDatabase db1 = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Usermaster.UseEntery.COL_NAME1, name);
        contentValues.put(Usermaster.UseEntery.COL_NAME2,password);
        contentValues.put(Usermaster.UseEntery.COL_NAME3,type);
     long addData =  db1.insert(Usermaster.UseEntery.TABLE_NAME,null,contentValues);
        if(addData > 0)
            return  true;
        else  return  false;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
