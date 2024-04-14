package nl.hva.emergencyexitapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "situation")
data class Situation(
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "instruction")
    var instruction: String
)
