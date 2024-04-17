package nl.hva.emergencyexitapp.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import nl.hva.emergencyexitapp.data.model.Situation

@Dao
interface SituationDao {

    @Query("SELECT * FROM situation")
    fun getAll(): LiveData<List<Situation>>

    @Insert
    suspend fun insert(item: Situation)

    @Delete
    suspend fun delete(item: Situation)

    @Query("DELETE FROM situation")
    suspend fun deleteAll()

    @Update
    suspend fun update(item: Situation)


}