package kg.internlabs.xiomicalculator

import android.app.Application
import androidx.room.Room
import kg.internlabs.xiomicalculator.model.data.AppDatabase

class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "AppDataBase"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}