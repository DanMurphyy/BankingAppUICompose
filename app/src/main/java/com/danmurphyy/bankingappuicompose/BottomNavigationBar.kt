package com.danmurphyy.bankingappuicompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danmurphyy.bankingappuicompose.data.BottomNavigation


var items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Default.Home
    ),
    BottomNavigation(
        title = "Wallet",
        icon = Icons.Default.Wallet
    ),
    BottomNavigation(
        title = "Notifications",
        icon = Icons.Default.Notifications
    ),
    BottomNavigation(
        title = "Account",
        icon = Icons.Default.AccountCircle
    ),
)

@Composable
fun BottomNavigationBar() {

    NavigationBar() {
        Row(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, items ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = items.icon,
                            contentDescription = items.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = items.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }

        }

    }

}