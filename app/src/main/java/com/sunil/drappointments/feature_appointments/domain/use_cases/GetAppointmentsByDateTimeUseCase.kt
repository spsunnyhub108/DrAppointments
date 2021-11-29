package com.sunil.drappointments.feature_appointments.domain.use_cases

import com.sunil.drappointments.feature_appointments.domain.model.Appointment
import com.sunil.drappointments.feature_appointments.domain.repository.AppointmentRepository
import com.sunil.drappointments.feature_appointments.domain.util.AppointmentsAscDes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Use case to fetch appointment list from a repository.
 * Return in ascending/descending order.
 *
 * @param repository injected repository to fetch the list of appointments
 */
class GetAppointmentsByDateTimeUseCase(private val repository: AppointmentRepository) {

    /**
     * Calls repository api to fetch the list of appointments
     *
     * @param appointmentsAscDes order a list in ascending or descending order
     */
    fun getData(appointmentsAscDes: AppointmentsAscDes = AppointmentsAscDes.Descending): Flow<List<Appointment>> {
        return repository.getAppointmentsByDataTime().map { appointments ->
            when (appointmentsAscDes) {
                is AppointmentsAscDes.Ascending ->
                    appointments.sortedBy { it.timeStampMs }
                is AppointmentsAscDes.Descending ->
                    appointments.sortedByDescending { it.timeStampMs }
            }
        }
    }
}