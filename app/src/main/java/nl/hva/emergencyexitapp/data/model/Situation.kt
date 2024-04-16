package nl.hva.emergencyexitapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "situation")
data class Situation(
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "instruction")
    var instruction: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
)
