package kg.internlabs.xiomicalculator.model.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.internlabs.xiomicalculator.model.data.models.History

@Database(entities = [History::class], version = 3, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun historyListDao() : HistoryListDao

}