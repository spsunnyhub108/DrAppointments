package com.sunil.drappointments.feature_appointments.data.repository

import com.sunil.drappointments.feature_appointments.data.data_source.local.AppointmentDao
import com.sunil.drappointments.feature_appointments.domain.model.Appointment
import com.sunil.drappointments.feature_appointments.domain.repository.AppointmentRepository
import kotlinx.coroutines.flow.Flow

/**
 * Repository implementation to communicate with data source.
 * Note: currently using Room Database containing appointment information.
 *
 * @param dao room database data access object. Contains api to communicate with room database.
 *
 */
class AppointmentRepositoryImpl(private val dao: AppointmentDao) : AppointmentRepository {
    override fun getAppointmentsByDataTime(): Flow<List<Appointment>> {
        return dao.getAppointmentsByDateTime()
    }

    //e.g. future use
    /*
    override fun getAppointmentsByName(name: String): Flow<List<Appointment>> {
        return dao.getAppointmentsByName(name)
    }

    override fun getAppointmentsByTitle(title: String): Flow<List<Appointment>> {
        return dao.getAppointmentsByTitle(title)
    }
    */
}