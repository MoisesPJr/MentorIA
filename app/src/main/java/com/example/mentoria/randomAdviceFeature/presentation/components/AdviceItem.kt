package com.example.mentoria.randomAdviceFeature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentoria.coreUi.LoadingScreen
import com.example.mentoria.randomAdviceFeature.domain.model.Advice

@Composable
fun AdviceItem(
    modifier: Modifier = Modifier,
    advice: Advice,
    error: String,
    isLoading: Boolean,
    refreshClick: () -> Unit,
    setFavorite: ( Advice) -> Unit,
    isFavorite: Boolean
) {

    Box(
        modifier = modifier.fillMaxWidth().height(200.dp)
    ) {
        if (isLoading) {
            LoadingScreen()
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = error.ifEmpty { advice.slip.advice },
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (error.isBlank()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
                    overflow = TextOverflow.Clip
                )
            }

            Row(
                modifier = Modifier.align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {
                IconButton(
                    onClick = {
                        refreshClick()
                    },

                    ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                if(!isFavorite){
                    IconButton(
                        onClick = {
                            setFavorite(advice)
                        },

                        ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}