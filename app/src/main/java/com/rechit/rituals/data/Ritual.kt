package com.rechit.rituals.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//TODO 1 : Define a local database table using the schema in app/schema/course.json

@Parcelize
@Entity(tableName = "rituals")
data class Ritual(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "minuteFocus")
    val minuteFocus: String,
    @ColumnInfo(name = "startTime")
    val startTime: String,
    @ColumnInfo(name = "priorityLevel")
    val priorityLevel: String
): Parcelable