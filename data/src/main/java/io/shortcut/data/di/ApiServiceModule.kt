package io.shortcut.data.di

import dagger.Module
import dagger.Provides
import io.shortcut.data.api.XKCDApiService
import retrofit2.Retrofit

@Module
class ApiServiceModule {

    @Provides
    fun providesXKCDRetrofitInstance(retrofit: Retrofit): XKCDApiService =
        retrofit.create(XKCDApiService::class.java)
}