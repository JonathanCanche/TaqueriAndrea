package com.canchemoguel.taqueriandrea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 11;
    private static final String DB_NAME = "usersdb";
    private static final String TABLE_Users = "userdetails";
    private static final String TABLE_Ucorte = "cortedetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";
    private static final String KEY_PRODUCT = "productos";
    private static final String KEY_DATECORTE = "datecorte";
    private static final String KEY_TOTAL = "corte";
    private static final String KEY_ID_CORTE = "idcorte";

    private static final String DATABASE_ALTER_TEAM_TO_V2 = "ALTER TABLE "
            + TABLE_Users + " ADD COLUMN " + KEY_PRODUCT + " TEXT;";

    private static final String DATABASE_ALTER_CORTE = "ALTER TABLE "
            + TABLE_Ucorte + " ADD COLUMN " + KEY_DATECORTE + " TEXT;";


    public DbHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"+ KEY_DATE + " TEXT" + ")";

        String CREATE_TABLE2 = "CREATE TABLE " + TABLE_Ucorte + "("
                + KEY_ID_CORTE + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TOTAL + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL(DATABASE_ALTER_CORTE);
        }
    }

    // Adding new User Details
    void insertCorteDetails(String corte){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_TOTAL, corte);
        cValues.put(KEY_DATECORTE,dateFormat.format(date));
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Ucorte,null, cValues);
        db.close();
    }

    // Get User Details
    public ArrayList<HashMap<String, String>> GetCorte(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> corteList = new ArrayList<>();
        String query = "SELECT datecorte,corte FROM "+ TABLE_Ucorte;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> cort = new HashMap<>();
            cort.put("corte",cursor.getString(cursor.getColumnIndex(KEY_TOTAL)));
            cort.put("datecorte",cursor.getString(cursor.getColumnIndex(KEY_DATECORTE)));
            corteList.add(cort);
        }
        return  corteList;
    }
    void insertUserDetails(String name, String productos){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_DATE,dateFormat.format(date));
        cValues.put(KEY_PRODUCT, productos);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users,null, cValues);

        db.close();
    }
    // Get User Details
    public ArrayList<HashMap<String, String>> GetUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name,date,productos FROM "+ TABLE_Users;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("date",cursor.getString(cursor.getColumnIndex(KEY_DATE)));
            user.put("productos",cursor.getString(cursor.getColumnIndex(KEY_PRODUCT)));
            userList.add(user);
        }
        return  userList;
    }
    // Get User Details based on userid
    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name FROM "+ TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_NAME}, KEY_ID+ "=?",new String[]{String.valueOf(userid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            userList.add(user);
        }
        return  userList;
    }
    // Delete User Details
    public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_ID+" = ?",new String[]{String.valueOf(userid)});
        db.close();
    }
    // Update User Details
    public int UpdateUserDetails(String location, String designation, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        int count = db.update(TABLE_Users, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }

    public Cursor Distance() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor Distance = db.rawQuery("SELECT Sum(" + KEY_NAME + ") AS myTotal FROM " + TABLE_Users, null);
        return Distance;
    }
    public void DeleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, null, null);
        db.close();
    }
}
