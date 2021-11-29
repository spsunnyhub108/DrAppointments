package com.sunil.drappointments.feature_appointments.presentation.appointments

import com.sunil.drappointments.feature_appointments.domain.model.Appointment
import com.sunil.drappointments.feature_appointments.domain.util.AppointmentsAscDes

/**
 * Class represent current appointment states:
 *
 * @param appointmentsList current appointment list for display
 * @param appointmentsAscDes selected list order ascending/descending
 */
data class AppointmentState(
    val appointmentsList: List<Appointment> = emptyList(),
    val appointmentsAscDes: AppointmentsAscDes = AppointmentsAscDes.Descending,
)
