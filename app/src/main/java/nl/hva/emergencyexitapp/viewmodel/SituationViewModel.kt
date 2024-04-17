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

    fun insertDummyData() {
        val situation = Situation(title = "Avalanche", instruction = "Hide.")

        val situation1 = Situation(title = "Air strike", instruction = "Hide.")

        val situation2 = Situation (title = "Earthquake", instruction = "Drop down onto your hands and knees to prevent being knocked over.\n" +
                "Cover your head and neck with your arms to protect yourself from falling debris.\n" +
                "Hold onto any sturdy furniture or cover to shield yourself.\n" +
                "If indoors, stay indoors. If outdoors, move to an open area away from buildings, trees, streetlights, and utility wires.")

        val situation3 = Situation(title = "Fire", instruction = "Alert everyone in the building by shouting \"Fire!\" and activating the fire alarm if available.\n" +
                "If your clothes catch fire, stop, drop to the ground, and roll to smother the flames.\n" +
                "Use the nearest fire extinguisher to extinguish small fires if it's safe to do so.\n" +
                "Evacuate the building via the nearest safe exit, never use elevators during a fire.")

        val situation4 = Situation(title = "Flood", instruction = "Move to higher ground immediately if you're in a flood-prone area.\n" +
                "Avoid walking or driving through flooded areas; just six inches of fast-flowing water can knock you over.\n" +
                "Turn off utilities like gas, electricity, and water if instructed to do so.\n" +
                "Listen to local authorities for evacuation orders and follow their instructions.")

        val situation5 = Situation(title = "Hurricane", instruction = "Stay indoors and away from windows during the storm.\n" +
                "Secure loose outdoor objects that could become projectiles in high winds.\n" +
                "Evacuate if you're in a coastal or low-lying area prone to flooding.\n" +
                "Keep listening to weather updates and follow advice from local authorities.")

        val situation6 = Situation(title = "Tornado", instruction = "Seek shelter in a sturdy building, preferably in a basement or storm cellar.\n" +
                "If there's no basement, go to an interior room on the lowest floor, away from windows.\n" +
                "Cover yourself with a mattress or heavy blankets to protect against flying debris.\n" +
                "If you're outdoors and can't get to shelter, lie flat in a nearby ditch or depression and cover your head.")

        val situation7 = Situation(title = "Medical Emergency", instruction = "Call emergency services (911 or your local emergency number) immediately.\n" +
                "Stay with the person in need and provide reassurance and comfort.\n" +
                "If trained, administer first aid or CPR if necessary until help arrives.\n" +
                "Follow any instructions given by emergency dispatchers.")

        val situation8 = Situation(title = "Power Outage", instruction = "Use flashlights rather than candles to avoid fire hazards.\n" +
                "Turn off electrical appliances to prevent damage from power surges when the power returns.\n" +
                "Keep refrigerator and freezer doors closed to maintain food freshness.\n" +
                "Check on neighbors, especially those who may require assistance.")

        val situation9 = Situation(title = "Chemical Spill", instruction = "Evacuate the area immediately if you smell strong, unusual odors or see a vapor cloud.\n" +
                "Move upwind and uphill to avoid exposure to hazardous chemicals.\n" +
                "Cover your mouth and nose with a cloth to prevent inhalation of toxic fumes.\n" +
                "Call emergency services and report the spill, providing as much detail as possible.")

        insert(situation)
        insert(situation1)
        insert(situation2)
        insert(situation3)
        insert(situation4)
        insert(situation5)
        insert(situation6)
        insert(situation7)
        insert(situation8)
        insert(situation9)

    }
}