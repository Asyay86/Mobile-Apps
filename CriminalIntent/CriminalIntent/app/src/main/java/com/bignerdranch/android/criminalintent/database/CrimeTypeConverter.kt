package com.bignerdranch.android.criminalintent.database

import androidx.room.TypeConverter
import java.util.Date

class CrimeTypeConverter {
    @TypeConverter
    fun fromData(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toData(millisSinceEpoch: Long): Date {
        return Date(millisSinceEpoch)
    }
}