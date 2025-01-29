package com.example.mentoria.favoriteAdvice.presentation


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.favoriteAdvice.presentation.components.FavoritesAdviceContent
import com.example.mentoria.favoriteAdvice.presentation.state.FavoriteAdviceState

@Composable
fun FavoritesAdviceScreen(
    uiState: FavoriteAdviceState,
    removeFavorite: (AdviceEntity) -> Unit,
) {

    val advices = uiState.advices


    Scaffold(
        content = { paddingValues ->
            FavoritesAdviceContent(
                paddingValues,
                advices,
                removeFavorite,
            )
        }
    )
}