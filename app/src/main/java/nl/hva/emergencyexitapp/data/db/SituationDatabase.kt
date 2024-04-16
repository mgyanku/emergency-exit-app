package nl.hva.emergencyexitapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nl.hva.emergencyexitapp.data.model.Situation

@Database(entities = [Situation::class], version = 1, exportSchema = false)
abstract class SituationDatabase : RoomDatabase() {

    abstract fun dao(): SituationDao

    companion object {
        private const val DATABASE_NAME = "SITUATION_DATABASE"

        @Volatile
        private var INSTANCE: SituationDatabase? = null

        fun getDatabase(context: Context): SituationDatabase? {
            if (INSTANCE == null) {
                synchronized(SituationDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            SituationDatabase::class.java, DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }

    }
}