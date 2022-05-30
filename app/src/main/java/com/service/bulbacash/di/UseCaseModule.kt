package com.service.bulbacash.di

import com.service.bulbacash.domain.repositories.CourseDayRepository
import com.service.bulbacash.domain.repositories.CourseGraphRepository
import com.service.bulbacash.domain.usecases.CourseDateUseCase
import com.service.bulbacash.domain.usecases.CoursePeriodUseCase
import com.service.bulbacash.domain.usecases.CourseTodayUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCourseTodayUseCase(repository: CourseDayRepository): CourseTodayUseCase {
        return CourseTodayUseCase(repository = repository)
    }

    @Provides
    fun provideCourseDateUseCase(repository: CourseDayRepository): CourseDateUseCase {
        return CourseDateUseCase(repository = repository)
    }

    @Provides
    fun provideCoursePeriodUseCase(repository: CourseGraphRepository): CoursePeriodUseCase {
        return CoursePeriodUseCase(repository = repository)
    }
}