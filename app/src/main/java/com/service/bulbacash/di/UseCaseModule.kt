package com.service.bulbacash.di

import com.service.bulbacash.domain.repositories.*
import com.service.bulbacash.domain.usecases.*
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

    @Provides
    fun provideGetAllBucketsUseCase(repository: GetBucketsRepository): GetAllBucketsUseCase {
        return GetAllBucketsUseCase(repository = repository)
    }

    @Provides
    fun provideUpdateAllBucketsUseCase(repository: GetBucketsRepository): UpdateAllBucketsUseCase {
        return UpdateAllBucketsUseCase(repository = repository)
    }

    @Provides
    fun provideAddBucketUseCase(repository: CurrentBucketsRepository): AddBucketUseCase {
        return AddBucketUseCase(repository = repository)
    }

    @Provides
    fun provideGetBucketsUseCase(repository: CurrentBucketsRepository): GetBucketsUseCase {
        return GetBucketsUseCase(repository = repository)
    }

    @Provides
    fun provideDeleteBucketUseCase(repository: CurrentBucketsRepository): DeleteBucketUseCase {
        return DeleteBucketUseCase(repository = repository)
    }

    @Provides
    fun provideGetBucketUseCase(repository: CurrentBucketsRepository):  GetBucketUseCase {
        return GetBucketUseCase(repository = repository)
    }

    @Provides
    fun provideSaveStencilUseCase(repository: StencilRepository): SaveStencilUseCase {
        return SaveStencilUseCase(repository=repository)
    }

    @Provides
    fun provideDeleteStencilUseCase(repository: StencilRepository): DeleteStencilUseCase {
        return DeleteStencilUseCase(repository=repository)
    }

}