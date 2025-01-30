package com.mjtech.mentoria.favoriteAdvice.presentation


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.favoriteAdvice.presentation.components.FavoritesAdviceContent
import com.mjtech.mentoria.favoriteAdvice.presentation.state.FavoriteAdviceState

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