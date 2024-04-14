package nl.hva.emergencyexitapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "speed_dial")
data class SpeedDial(
    @ColumnInfo(name = "number")
    var number: Number,
    )
