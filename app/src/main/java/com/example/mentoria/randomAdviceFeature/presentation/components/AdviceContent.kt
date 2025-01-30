package com.example.mentoria.randomAdviceFeature.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mentoria.core.utils.createImageFromText
import com.example.mentoria.core.utils.shareImage
import com.example.mentoria.core.utils.translateText
import com.example.mentoria.core.utils.translateTexts
import com.example.mentoria.coreUi.AdvicesListScreen
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.favoriteAdvice.domain.mapper.toAdvice
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.model.Slip

@Composable
fun AdviceContent(
    modifier: Modifier = Modifier,
    advice: Advice,
    paddingValues: PaddingValues,
    refreshClick: () -> Unit,
    error: String,
    isLoading: Boolean,
    setFavoriteAdvice: (Advice) -> Unit,
    navigateToFavoriteScreen: () -> Unit,
    advices: List<AdviceEntity>
) {
    val localContext = LocalContext.current

    var translatedText by remember { mutableStateOf("") }
    var translatedAdvices by remember { mutableStateOf(emptyList<AdviceEntity>()) }
    LaunchedEffect(advice.slip.advice) {
        translateText(advice.slip.advice, onSuccess = { translated ->
            translatedText = translated
        }, onFailure = { errorMessage ->
            translatedText = errorMessage
        })
    }

    LaunchedEffect(advices) {
        translateTexts(advices, onSuccess = { translated ->
            translatedAdvices = translated
        }, onFailure = { errorMessage ->
            translatedText = errorMessage
        })
    }

    Column(modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { navigateToFavoriteScreen() },
                modifier = Modifier.padding(16.dp),
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Ver Favoritos",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            AdviceItem(
                modifier = Modifier.padding(16.dp),
                advice = Advice(Slip(id = advice.slip.id, advice = translatedText)),
                error = error,
                refreshClick = refreshClick,
                isLoading = isLoading,
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

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.weight(1f)) {
            AdvicesListScreen(
                paddingValues = paddingValues,
                action = { adviceFavorite ->
                    setFavoriteAdvice(adviceFavorite.toAdvice())
                },
                actionIcon = Icons.Default.Favorite,
                advices = translatedAdvices
            )
        }
    }
}