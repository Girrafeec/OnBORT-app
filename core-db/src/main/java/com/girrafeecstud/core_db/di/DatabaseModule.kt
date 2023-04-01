/* Created by Girrafeec */

package com.girrafeecstud.core_db.di

import android.content.Context
import androidx.room.Room
import com.girrafeecstud.core_db.database.DatabaseConfig
//import com.girrafeecstud.core_db.database.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

//    @Provides
//    @Singleton
//    fun provideMainDatabase(context: Context): MainDatabase {
//        return Room.databaseBuilder(
//            context,
//            MainDatabase::class.java,
//            DatabaseConfig.DATABASE_NAME,
//        ).allowMainThreadQueries().build()
//    }

}