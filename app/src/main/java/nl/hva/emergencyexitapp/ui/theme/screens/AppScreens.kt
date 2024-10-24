package nl.hva.emergencyexitapp.ui.theme.screens

import androidx.annotation.StringRes
import nl.hva.emergencyexitapp.R

sealed class AppScreens (
    val route: String,
    @StringRes val resourceId: Int,
    val icon: Int
) {
    object HomeScreen: AppScreens("home_screen", R.string.home , R.drawable.home)
    object SearchScreen: AppScreens("search_screen", R.string.search , R.drawable.search)
    object InstructionScreen: AppScreens("instruction_screen", R.string.search , R.drawable.instruction)
    object AddScreen: AppScreens("add_screen", R.string.add , R.drawable.add)
    object SettingsScreen: AppScreens("settings_screen", R.string.settings , R.drawable.settings)

}
