package com.sunil.drappointments.feature_appointments.domain.repository

import com.sunil.drappointments.feature_appointments.domain.model.Appointment
import kotlinx.coroutines.flow.Flow


/**
 * Repository interface in domain for abstraction.
 * This is implemented in repository. Contains api
 * which communicates with database (or backend in future).
 */
interface AppointmentRepository {
    fun getAppointmentsByDataTime(): Flow<List<Appointment>>

    //e.g. future use:
    /*
    fun getAppointmentsByName(name: String): Flow<List<Appointment>>
    fun getAppointmentsByTitle(title: String): Flow<List<Appointment>>
    */
}
