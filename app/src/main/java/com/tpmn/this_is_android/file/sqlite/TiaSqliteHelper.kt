package com.tpmn.this_is_android.file.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.tpmn.this_is_android.file.model.Memo

class TiaSqliteHelper(context: Context, name: String, version: Int) : SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table memo (" +
                " no integer primary key," +
                " content text," +
                " dateTime integer" +
                ")"
        db?.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // If changed table, do this function
    }

    fun insertMemo(memo: Memo) {
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("dateTime", memo.dateTime)

        val wd = writableDatabase
        wd.insert("memo", null, values)
        wd.close()
    }

    fun selectMemo(): MutableList<Memo> {
        val list = mutableListOf<Memo>()

        val select = "select * from memo"
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)
        while (cursor.moveToNext()) {
            val no = cursor.getLong(cursor.getColumnIndex("no"))
            val content = cursor.getString(cursor.getColumnIndex("content"))
            val dateTime = cursor.getString(cursor.getColumnIndex("dateTime"))

            list.add(Memo(no, content, dateTime))
        }
        rd.close()

        return list
    }

    fun updateMemo(memo: Memo) {
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("dateTime", memo.dateTime)

        val wd = writableDatabase
        wd.update("memo", values, "no = ${memo.no}", null)
        wd.close()
    }

    fun deleteMemo(memo: Memo) {
        val delete = "delete from memo where no = ${memo.no}"
        val db = writableDatabase
        db.execSQL(delete)
        db.close()
    }

}