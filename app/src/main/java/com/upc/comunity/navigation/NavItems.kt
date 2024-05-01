package com.upc.comunity.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String,
)
val listOfNavItem= listOf(
    NavItem(
        label = "Home",
        icon= Icons.Default.Home,
        route= Screens.Home.name
    ),
    NavItem(
        label = "Community",
        icon= Icons.Default.Person,
        route= Screens.Community.name
    ),
    NavItem(
        label = "Home",
        icon= Icons.Default.ShoppingCart,
        route= Screens.Pay.name
    ),

)

