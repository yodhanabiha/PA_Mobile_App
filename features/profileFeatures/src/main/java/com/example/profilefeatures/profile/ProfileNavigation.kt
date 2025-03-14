package com.example.profilefeatures.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.nabiha.common.utils.NavRoute

const val profileRoute = NavRoute.ProfileScreenRoute

fun NavGraphBuilder.profileScreen(
    navController: NavHostController,
) {
    composable(route = profileRoute) {
        ProfileScreenRoute(navController)
    }
}