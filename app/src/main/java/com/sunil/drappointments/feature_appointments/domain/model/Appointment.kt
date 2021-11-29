package com.sunil.drappointments.feature_appointments.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room database table.
 * Each field represents a column in appointment table.
 */

@Entity
data class Appointment(
    val name: String,
    val title: String,
    val timeStampMs: Long, //represents data/time in ms
    @PrimaryKey val id: Int
)

