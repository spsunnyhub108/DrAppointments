package com.sunil.drappointments.feature_appointments.domain.use_cases

/**
 * Data class represents available use cases
 * Note: additional use cases can be added here
 *
 * @param getAppointmentsByDateTimeUseCase use case to fetch a list of appointments by data/time order
 */
data class AppointmentUseCases(
    val getAppointmentsByDateTimeUseCase: GetAppointmentsByDateTimeUseCase
)
