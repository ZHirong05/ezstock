package com.example.ezstock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ezstock.ui.theme.EzStockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EzStockTheme {
                MainTabScreen()
            }
        }
    }
}

@Composable
fun MainTabScreen() {
    val tabItems = listOf("Dashboard", "Inventory", "Scan", "Tracking", "Profile")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabItems.forEachIndexed { index, title ->
                    NavigationBarItem(
                        icon = {}, // Optional: Add icons here
                        label = { Text(title) },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            when (selectedTabIndex) {
                0 -> DashboardScreen()
                1 -> InventoryScreen()
                2 -> ScanScreen()
                3 -> TrackingScreen()
                4 -> ProfileScreen()
            }
        }
    }
}
@Composable fun DashboardScreen() {
    CenterText("Dashboard")
}
@Composable fun InventoryScreen() {
    CenterText("Inventory")
}
@Composable fun ScanScreen() {
    CenterText("Scan")
}
@Composable fun TrackingScreen() {
    CenterText("Tracking")
}
@Composable fun ProfileScreen() {
    CenterText("Profile")
}

@Composable
fun CenterText(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = MaterialTheme.typography.headlineMedium)
    }
}