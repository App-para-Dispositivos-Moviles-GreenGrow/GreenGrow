package com.upc.comunity.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.upc.comunity.ui.screens.Article
import com.upc.comunity.ui.screens.Community
import com.upc.comunity.ui.screens.Courses
import com.upc.comunity.ui.screens.Home
import com.upc.comunity.ui.screens.Pay

@Composable
fun Navigation(){
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                
            )
            {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItem.forEach {
                    navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any {
                            it.route == navItem.route
                        } == true,
                        onClick = {
                                  navController.navigate(navItem.route){
                                      popUpTo(navController.graph.findStartDestination().id){
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        icon = {
                               Icon(
                                   imageVector = navItem.icon,
                                   contentDescription = null
                               )
                        },
                        label = {

                        }
                    )
                }
            }

        }
    ){
        paddingValues -> NavHost(
        navController = navController ,
        startDestination = Screens.Home.name,
        modifier = Modifier
        .padding(paddingValues)) {

            composable(route = Screens.Home.name){
                Home()
            }
            composable(route = Screens.Pay.name){
                Pay()
            }
            composable(route = Screens.Community.name){
                Community()
            }
            composable(route = Screens.Courses.name){
                Courses()
            }
            composable(route = Screens.Article.name){
                Article()
            }
        }

    }
}



