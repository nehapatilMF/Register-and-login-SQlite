package com.example.userregistration.DB


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "UserData", null, 1) {

    override fun onCreate(DB: SQLiteDatabase) {
        DB.execSQL("create Table UserDetails(userID TEXT primary key,name TEXT,password PASSWORD,number NUMBER)")
    }

    override fun onUpgrade(DB: SQLiteDatabase, i: Int, i1: Int) {
        DB.execSQL("drop Table if exists UserDetails")
    }

    fun insertUserData(name: String, number: String, email: String, password: String): Boolean {
        val DB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("userID", email)
        contentValues.put("name", name)
        contentValues.put("password", password)
        contentValues.put("number", number)
        val result = DB.insert("UserDetails", null, contentValues)
        return result != -1L
    }

    fun getData(): Cursor {
        val DB = this.writableDatabase
        return DB.rawQuery("Select * from UserDetails", null)
    }
}
