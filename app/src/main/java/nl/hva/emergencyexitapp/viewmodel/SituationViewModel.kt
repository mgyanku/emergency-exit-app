package nl.hva.emergencyexitapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nl.hva.emergencyexitapp.data.model.Situation
import nl.hva.emergencyexitapp.data.repository.SituationRepository

class SituationViewModel(application: Application) : AndroidViewModel(application){
    private val repository = SituationRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val backlog =
        repository.getAll()


    /**
     * insert situation
     */
    fun insert(item: Situation) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                repository.insert(item)
            }
        }
    }

    /**
     * delete situation
     */
    fun delete(item: Situation) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                repository.delete(item)
            }
        }
    }
}