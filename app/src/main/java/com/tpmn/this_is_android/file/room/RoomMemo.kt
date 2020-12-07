package com.tpmn.this_is_android.file.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orm_memo")
class RoomMemo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var no: Long? = null

    @ColumnInfo
    var content: String = ""

    @ColumnInfo
    var dateTime: Long = 0

    constructor(content: String, dateTime: Long) {
        this.content = content
        this.dateTime = dateTime
    }
}