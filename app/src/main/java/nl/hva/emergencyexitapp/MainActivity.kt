package nl.hva.emergencyexitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nl.hva.emergencyexitapp.data.model.Situation
import nl.hva.emergencyexitapp.ui.theme.EmergencyExitAppTheme
import nl.hva.emergencyexitapp.ui.theme.coralPink
import nl.hva.emergencyexitapp.ui.theme.screens.AppScreens
import nl.hva.emergencyexitapp.ui.theme.screens.HomeScreen
import nl.hva.emergencyexitapp.ui.theme.screens.InstructionScreen
import nl.hva.emergencyexitapp.ui.theme.screens.SearchScreen
import nl.hva.emergencyexitapp.ui.theme.white
import nl.hva.emergencyexitapp.viewmodel.SituationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            EmergencyExitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call base scaffold
                    AppScaffold()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = white
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = coralPink)
            )
        },
        bottomBar = {
            BottomNav(navController)
        },
        content = { innerPadding ->
            AppNavHost(
                navController, modifier = Modifier.padding(innerPadding)
            )
        },
    )

}



/**
 * You can see this as a nav_graph.xml in compose environment.
 */
@Composable
private fun AppNavHost(navController: NavHostController, modifier: Modifier) {
    val viewModel: SituationViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route,
        modifier = modifier
    ) {
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = AppScreens.SearchScreen.route) {
            SearchScreen(navController, viewModel)
        }
        composable(route = "${AppScreens.InstructionScreen.route}/{situationId}") { backStackEntry ->
            val situationId = backStackEntry.arguments?.getInt("situationId")
            if (situationId != null) {
                InstructionScreen(navController, viewModel, situationId)
            } else {
                // Screen will catch this error
                InstructionScreen(navController, viewModel, -1)
            }
        }
    }
}

@Composable
fun BottomNav(navController: NavHostController) {
    val items = listOf(
        AppScreens.HomeScreen,
        AppScreens.SearchScreen)
    BottomNavigation(
        modifier = Modifier,
        backgroundColor = coralPink
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null
                    )
                },
                label = { Text(stringResource(screen.resourceId)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                selectedContentColor = white,
                unselectedContentColor = coralPink,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}