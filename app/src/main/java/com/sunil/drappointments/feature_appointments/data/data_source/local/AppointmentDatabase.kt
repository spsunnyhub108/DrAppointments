package com.sunil.drappointments.feature_appointments.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sunil.drappointments.feature_appointments.domain.model.Appointment

/**
 * AppointmentDatabase defines the room database configuration and holds the database.
 */
@Database(
    entities = [Appointment::class],
    version = 1,
    exportSchema = true
)
abstract class AppointmentDatabase : RoomDatabase() {

    abstract val appointmentDao: AppointmentDao

    companion object {
        const val DATABASE_NAME = "appointments.db"
    }
}