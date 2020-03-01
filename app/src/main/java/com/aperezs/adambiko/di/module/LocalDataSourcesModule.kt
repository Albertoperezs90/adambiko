package com.aperezs.adambiko.di.module

import android.app.Application
import com.aperezs.adambiko.storage.dao.EntryDAO
import com.aperezs.adambiko.storage.database.AppDatabase
import com.aperezs.adambiko.storage.datasource.LocalDataSource
import dagger.Module
import dagger.Provides

@Module
class LocalDataSourcesModule {

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return AppDatabase.getDatabase(application.applicationContext)
    }

    @Provides
    fun provideEntryDAO(appDatabase: AppDatabase): EntryDAO {
        return appDatabase.entryDAO()
    }

    @Provides
    fun provideLocalDataSource(entryDAO: EntryDAO): LocalDataSource {
        return LocalDataSource(entryDAO)
    }

}