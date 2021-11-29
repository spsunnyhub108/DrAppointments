package com.sunil.drappointments.feature_appointments.presentation.appointments

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunil.drappointments.feature_appointments.domain.use_cases.AppointmentUseCases
import com.sunil.drappointments.feature_appointments.domain.util.AppointmentsAscDes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * viewModel class - State holder for Main Appointment Screen
 * and to communicate with use cases to fetch appointment list.
 *
 * @param appointmentUseCases list of use cases needed by this viewModel to fetch appointment list
 */
@HiltViewModel
class AppointmentViewModel @Inject constructor(
    private val appointmentUseCases: AppointmentUseCases
) : ViewModel() {

    private val _state = mutableStateOf(AppointmentState())
    val state: State<AppointmentState> = _state
    private var job: Job? = null

    init {
        getAppointments(ascDes = AppointmentsAscDes.Descending)
    }

    /**
     * On FloatingActionButton onClick - set ascending/descending order.
     * Make a call getAppointments() to get the new ordered list.
     */
    fun onFloatBtnAscDes() {
        _state.value =
            state.value.copy(
                appointmentsAscDes = if (state.value.appointmentsAscDes == AppointmentsAscDes.Ascending) {
                    AppointmentsAscDes.Descending
                } else {
                    AppointmentsAscDes.Ascending
                }
            )
        getAppointments(state.value.appointmentsAscDes)
    }

    /**
     * Uses appointmentUseCases api to fetch the appointment list.
     *
     * @param ascDes appointment list order preference ascending or descending
     */
    fun getAppointments(ascDes: AppointmentsAscDes = state.value.appointmentsAscDes) {
        job?.cancel()
        job = appointmentUseCases.getAppointmentsByDateTimeUseCase.getData(appointmentsAscDes = ascDes)
            .onEach { listOfAppointments ->
                _state.value =
                    state.value.copy(
                        appointmentsList = listOfAppointments,
                        appointmentsAscDes = ascDes
                    )
            }
            .launchIn(viewModelScope)
    }
}