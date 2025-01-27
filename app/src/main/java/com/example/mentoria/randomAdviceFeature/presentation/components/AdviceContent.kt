package com.example.mentoria.randomAdviceFeature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mentoria.core.utils.createImageFromText
import com.example.mentoria.core.utils.shareImage
import com.example.mentoria.core.utils.translateText
import com.example.mentoria.randomAdviceFeature.domain.model.Advice

@Composable
fun AdviceContent(
    modifier: Modifier = Modifier,
    advice: Advice,
    paddingValues: PaddingValues,
    refreshClick: () -> Unit,
    error: String,
    isLoading: Boolean
) {
    val localContext = LocalContext.current

    var translatedText by remember { mutableStateOf("") }


    LaunchedEffect(advice.slip.advice) {
        translateText(advice.slip.advice, onSuccess = { translated ->
            translatedText = translated
        }, onFailure = { errorMessage ->
            translatedText = errorMessage
        })
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(24.dp)
        ) {
            AdviceItem(
                modifier = Modifier.padding(16.dp),
                advice = translatedText,
                error = error,
                refreshClick = refreshClick,
                isLoading = isLoading
            )
            Spacer(modifier = Modifier.height(24.dp))

            AdviceButtons(
                modifier = Modifier.fillMaxWidth(),
                shareClick = {
                    val imageFile = createImageFromText(translatedText)
                    shareImage(localContext, imageFile)
                }
            )
        }
    }
}
