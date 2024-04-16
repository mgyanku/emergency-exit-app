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
    fun getAll(): LiveData<List<Situation>> {
        // Returning dummy data
        return MutableLiveData(dummySituationData)
    }

    @Insert
    suspend fun insert(item: Situation)

    @Delete
    suspend fun delete(item: Situation)

    @Query("DELETE FROM situation")
    suspend fun deleteAll()

    @Update
    suspend fun update(item: Situation)


}

// Dummy data
val dummySituationData = listOf(
    Situation(id = 1, title = "Situation", instruction = "Description"),

    Situation (id = 2, title = "Earthquake", instruction = "Drop down onto your hands and knees to prevent being knocked over.\n" +
            "Cover your head and neck with your arms to protect yourself from falling debris.\n" +
            "Hold onto any sturdy furniture or cover to shield yourself.\n" +
            "If indoors, stay indoors. If outdoors, move to an open area away from buildings, trees, streetlights, and utility wires."),

    Situation(id = 3, title = "Fire", instruction = "Alert everyone in the building by shouting \"Fire!\" and activating the fire alarm if available.\n" +
            "If your clothes catch fire, stop, drop to the ground, and roll to smother the flames.\n" +
            "Use the nearest fire extinguisher to extinguish small fires if it's safe to do so.\n" +
            "Evacuate the building via the nearest safe exit, never use elevators during a fire."),

    Situation(id = 4, title = "Flood", instruction = "Move to higher ground immediately if you're in a flood-prone area.\n" +
            "Avoid walking or driving through flooded areas; just six inches of fast-flowing water can knock you over.\n" +
            "Turn off utilities like gas, electricity, and water if instructed to do so.\n" +
            "Listen to local authorities for evacuation orders and follow their instructions."),

    Situation(id = 5, title = "Hurricane", instruction = "Stay indoors and away from windows during the storm.\n" +
            "Secure loose outdoor objects that could become projectiles in high winds.\n" +
            "Evacuate if you're in a coastal or low-lying area prone to flooding.\n" +
            "Keep listening to weather updates and follow advice from local authorities."),

    Situation(id = 6, title = "Tornado", instruction = "Seek shelter in a sturdy building, preferably in a basement or storm cellar.\n" +
            "If there's no basement, go to an interior room on the lowest floor, away from windows.\n" +
            "Cover yourself with a mattress or heavy blankets to protect against flying debris.\n" +
            "If you're outdoors and can't get to shelter, lie flat in a nearby ditch or depression and cover your head."),

    Situation(id = 7, title = "Medical Emergency", instruction = "Call emergency services (911 or your local emergency number) immediately.\n" +
            "Stay with the person in need and provide reassurance and comfort.\n" +
            "If trained, administer first aid or CPR if necessary until help arrives.\n" +
            "Follow any instructions given by emergency dispatchers."),

    Situation(id = 8, title = "Power Outage", instruction = "Use flashlights rather than candles to avoid fire hazards.\n" +
            "Turn off electrical appliances to prevent damage from power surges when the power returns.\n" +
            "Keep refrigerator and freezer doors closed to maintain food freshness.\n" +
            "Check on neighbors, especially those who may require assistance."),

    Situation(id = 9, title = "Chemical Spill", instruction = "Evacuate the area immediately if you smell strong, unusual odors or see a vapor cloud.\n" +
            "Move upwind and uphill to avoid exposure to hazardous chemicals.\n" +
            "Cover your mouth and nose with a cloth to prevent inhalation of toxic fumes.\n" +
            "Call emergency services and report the spill, providing as much detail as possible."),

    )