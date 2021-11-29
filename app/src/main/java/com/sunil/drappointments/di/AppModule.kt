package com.sunil.drappointments.di

import android.app.Application
import androidx.room.Room
import com.sunil.drappointments.feature_appointments.data.data_source.local.AppointmentDatabase
import com.sunil.drappointments.feature_appointments.data.repository.AppointmentRepositoryImpl
import com.sunil.drappointments.feature_appointments.domain.repository.AppointmentRepository
import com.sunil.drappointments.feature_appointments.domain.use_cases.AppointmentUseCases
import com.sunil.drappointments.feature_appointments.domain.use_cases.GetAppointmentsByDateTimeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Provides below dependencies at application level.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Note: Creates room database from a predefined database
     * under the assets folder.
     */
    @Provides
    @Singleton
    fun provideAppointmentDatabase(app: Application): AppointmentDatabase {
        return Room.databaseBuilder(
            app,
            AppointmentDatabase::class.java,
            AppointmentDatabase.DATABASE_NAME
        ).createFromAsset("database/appointment.db").build()
    }

    //provides repository
    @Provides
    @Singleton
    fun providesAppointmentRepository(db: AppointmentDatabase): AppointmentRepository {
        return AppointmentRepositoryImpl(db.appointmentDao)
    }

    //provides uses cases
    @Provides
    @Singleton
    fun providesAppointmentUseCases(repository: AppointmentRepository): AppointmentUseCases {
        return AppointmentUseCases(
            getAppointmentsByDateTimeUseCase = GetAppointmentsByDateTimeUseCase(repository = repository)
        )
    }
}