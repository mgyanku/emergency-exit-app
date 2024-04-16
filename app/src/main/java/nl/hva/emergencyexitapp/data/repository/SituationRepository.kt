package nl.hva.emergencyexitapp.data.repository

import android.content.Context
import nl.hva.emergencyexitapp.data.db.SituationDao
import nl.hva.emergencyexitapp.data.db.SituationDatabase
import nl.hva.emergencyexitapp.data.model.Situation

class SituationRepository(context: Context) {
    private val dao: SituationDao

    init {
        val database = SituationDatabase.getDatabase(context)
        dao = database!!.dao()
    }

    fun getAll() = dao.getAll()

    suspend fun insert(item: Situation) = dao.insert(item)

    suspend fun delete(item: Situation) = dao.delete(item)

    suspend fun deleteAll() = dao.deleteAll()


}