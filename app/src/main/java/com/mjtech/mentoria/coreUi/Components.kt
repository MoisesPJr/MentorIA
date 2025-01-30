package com.mjtech.mentoria.coreUi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mjtech.mentoria.core.utils.createImageFromText
import com.mjtech.mentoria.core.utils.shareImage
import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.favoriteAdvice.presentation.components.FavoriteAdviceItem

@Composable
fun LoadingScreen(message: String = "Carregando...") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 6.dp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun AdvicesListScreen(
    paddingValues: PaddingValues,
    advices: List<AdviceEntity>,
    action: (AdviceEntity) ->Unit,
    actionIcon: ImageVector,
    modifier: Modifier = Modifier
) {

    val localContext = LocalContext.current

    Box(modifier = Modifier.padding(16.dp)) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = paddingValues,
            content = {
                items(
                    items = advices,
                    key = { item: AdviceEntity -> item.id }
                ) { advice ->
                    FavoriteAdviceItem(
                        item = advice,
                        action = { action(advice) },
                        actionIcon = actionIcon,
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