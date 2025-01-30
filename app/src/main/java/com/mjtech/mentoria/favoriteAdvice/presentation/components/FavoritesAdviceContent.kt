package com.mjtech.mentoria.favoriteAdvice.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mjtech.mentoria.coreUi.AdvicesListScreen
import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity

@Composable
fun FavoritesAdviceContent(
    paddingValues: PaddingValues,
    advices: List<AdviceEntity>,
    removeFavorite: (AdviceEntity) -> Unit,
) {

    if (advices.isEmpty()) {
        EmptyFavoritesScreen()
    } else {

        AdvicesListScreen(
            paddingValues = paddingValues,
            advices = advices,
            action = { advice ->
                removeFavorite(advice)
            },
            actionIcon = Icons.Default.Delete,
            modifier = Modifier.fillMaxSize(),
        )

    }
}