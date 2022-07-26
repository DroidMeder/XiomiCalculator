package kg.internlabs.xiomicalculator.model.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_history_items")
data class History(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    val input: String,
    val result: String
)