package com.sunil.drappointments.feature_appointments.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sunil.drappointments.feature_appointments.presentation.appointments.AppointmentScreen
import com.sunil.drappointments.ui.theme.DrAppointmentsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrAppointmentsTheme {
                DisplayAppointments()
            }
        }
    }
}

@Composable
fun DisplayAppointments() {
    AppointmentScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DrAppointmentsTheme {
        DisplayAppointments()
    }
}