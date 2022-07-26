package kg.internlabs.xiomicalculator.model.data

import androidx.room.*
import kg.internlabs.xiomicalculator.model.data.models.History

@Dao
interface HistoryListDao {

    @Query("SELECT * FROM table_history_items ORDER BY id DESC")
    fun getAllHistoryItems(): List<History>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHistoryItem(history: History)

    @Delete
    fun deleteHistoriesItem(histories: List<History>)
}