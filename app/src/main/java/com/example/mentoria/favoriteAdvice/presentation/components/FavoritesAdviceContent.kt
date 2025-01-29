package com.example.mentoria.favoriteAdvice.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mentoria.core.utils.createImageFromText
import com.example.mentoria.core.utils.shareImage
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity

@Composable
fun FavoritesAdviceContent(
    paddingValues: PaddingValues,
    advices: List<AdviceEntity>,
    removeFavorite: (AdviceEntity) -> Unit,
) {

    val localContext = LocalContext.current

    Box {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = paddingValues,
            content = {
                items(
                    items = advices,
                    key = { item: AdviceEntity -> item.id }
                ) { advice ->
                    FavoriteAdviceItem(
                        item = advice,
                        removeFavorite = { removeFavorite(advice) },
                        shareAdvice = {
                            val imageFile = createImageFromText(advice.advice)
                            shareImage(localContext, imageFile)
                        }
                    )
                }
            }
        )
    }


}