package com.example.mentoria.randomAdviceFeature.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentoria.coreUi.LoadingScreen
import com.example.mentoria.randomAdviceFeature.domain.model.Advice

@Composable
fun AdviceItem(
    modifier: Modifier = Modifier,
    advice: String,
    error: String,
    isLoading: Boolean
) {

    Box(
        modifier = modifier.fillMaxWidth().height(200.dp)
    ) {
        if (isLoading) {
            LoadingScreen()
        } else {
            Text(
                text = error.ifEmpty { advice },
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (error.isBlank()) Color.Black else MaterialTheme.colorScheme.error,
                overflow = TextOverflow.Clip
            )
        }
    }
}