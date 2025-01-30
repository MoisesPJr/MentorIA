package com.mjtech.mentoria.favoriteAdvice.presentation


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.favoriteAdvice.presentation.components.FavoritesAdviceContent
import com.mjtech.mentoria.favoriteAdvice.presentation.state.FavoriteAdviceState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesAdviceScreen(
    uiState: FavoriteAdviceState,
    removeFavorite: (AdviceEntity) -> Unit,
) {

    val advices = uiState.advices


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Favoritos",
                        color = MaterialTheme.colorScheme.primary
                    )
                },
            )
        },
        content = { paddingValues ->
            FavoritesAdviceContent(
                paddingValues,
                advices,
                removeFavorite,
            )
        }
    )
}