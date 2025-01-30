package com.example.mentoria.favoriteAdvice.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun FavoritesAdviceOptions(
    action: () -> Unit,
    shareAdvice: () -> Unit,
    actionIcon: ImageVector
) {
    Column {
        IconButton(
            onClick = {
                action()
            },
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                imageVector = actionIcon ,
                contentDescription = "Action",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        IconButton(
            onClick = {
                shareAdvice()
            },
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}