package com.sunil.drappointments.feature_appointments.data.data_source.local

import androidx.room.Dao
import androidx.room.Query
import com.sunil.drappointments.feature_appointments.domain.model.Appointment
import kotlinx.coroutines.flow.Flow

/**
 * Interface defines Data Access Object (DAO).
 * API's for the app to communicate with room database.
 */
@Dao
interface AppointmentDao {
    @Query("SELECT * FROM appointment")
    fun getAppointmentsByDateTime(): Flow<List<Appointment>>

    //e.g. future use:
    /*
    @Query("SELECT * FROM appointment WHERE title = :title")
    fun getAppointmentsByTitle(title: String): Flow<List<Appointment>>

    @Query("SELECT * FROM appointment WHERE name = :name")
    fun getAppointmentsByName(name: String): Flow<List<Appointment>>
    */
}