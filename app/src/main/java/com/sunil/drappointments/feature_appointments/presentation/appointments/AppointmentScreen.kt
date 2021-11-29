package com.sunil.drappointments.feature_appointments.presentation.appointments

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sunil.drappointments.R
import com.sunil.drappointments.feature_appointments.domain.util.AppointmentsAscDes
import com.sunil.drappointments.ui.theme.DrAppointmentsTheme
import java.text.SimpleDateFormat
import java.util.*

/**
 * Main Composable for Appointment Screen to show the list of appointments.
 *
 * @param viewModel hilt injected viewModel for communication with viewModel
 *
 */
@Composable
fun AppointmentScreen(
    viewModel: AppointmentViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    //e.g. 4/22/2021 at 10:30 PM
    val simpleDateFormatDate = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    val simpleDateFormatTime = SimpleDateFormat("HH:mm aaa", Locale.US)

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF0069c0),
                title = {
                    Text(
                        "Appointments",
                        color = Color(0xFFFFFFFF)
                    )
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onFloatBtnAscDes()
                },
                backgroundColor = MaterialTheme.colors.primaryVariant
            ) {
                when (state.appointmentsAscDes) {
                    is AppointmentsAscDes.Descending -> {
                        Text("ASC")
                    }
                    is AppointmentsAscDes.Ascending -> {
                        Text("DES")
                    }
                }
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 8.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.appointmentsList) { appointment ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        elevation = 2.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .clickable { }
                    ) {
                        Row(modifier = Modifier.animateContentSize()) {
                            Image(
                                painterResource(id = R.drawable.ic_baseline_medical_services_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(88.dp)
                                    .padding(8.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = appointment.name,
                                    maxLines = 1
                                )
                                Text(
                                    text = appointment.title,
                                    maxLines = 1
                                )
                                val dateTxt = simpleDateFormatDate.format(appointment.timeStampMs).toString()
                                val TimeTxt = simpleDateFormatTime.format(appointment.timeStampMs).toString()
                                Text(
                                    text = dateTxt.plus(" at ").plus(TimeTxt),
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DrAppointmentsTheme {
    }
}