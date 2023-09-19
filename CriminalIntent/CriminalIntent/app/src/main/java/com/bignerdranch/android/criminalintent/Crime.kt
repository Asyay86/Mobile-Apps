package com.bignerdranch.android.criminalintent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Crime (
    @PrimaryKey val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)