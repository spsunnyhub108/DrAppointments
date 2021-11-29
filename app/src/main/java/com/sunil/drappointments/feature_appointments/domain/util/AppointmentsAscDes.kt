package com.sunil.drappointments.feature_appointments.domain.util

/**
 * appointment list order states
 */
sealed class AppointmentsAscDes {
    object Ascending : AppointmentsAscDes()
    object Descending : AppointmentsAscDes()
}
