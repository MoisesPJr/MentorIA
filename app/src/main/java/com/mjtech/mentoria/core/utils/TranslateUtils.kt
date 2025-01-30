package com.mjtech.mentoria.core.utils

import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions


fun translateText(
    text: String,
    onSuccess: (String) -> Unit,
    onFailure: (String) -> Unit
) {
    val options = FirebaseTranslatorOptions.Builder()
        .setSourceLanguage(FirebaseTranslateLanguage.EN)
        .setTargetLanguage(FirebaseTranslateLanguage.PT)
        .build()

    val portugueseTranslator = FirebaseNaturalLanguage.getInstance().getTranslator(options)

    portugueseTranslator.downloadModelIfNeeded()
        .addOnSuccessListener {
            portugueseTranslator.translate(text)
                .addOnSuccessListener { translatedText ->
                    onSuccess(translatedText)
                }
                .addOnFailureListener {
                    onFailure("Não foi possível traduzir o texto")
                }
        }
        .addOnFailureListener {
            onFailure("Não foi possível baixar o modelo de tradução")
        }
}

fun translateTexts(
    advices: List<AdviceEntity>,
    onSuccess: (List<AdviceEntity>) -> Unit,
    onFailure: (String) -> Unit
) {
    val options = FirebaseTranslatorOptions.Builder()
        .setSourceLanguage(FirebaseTranslateLanguage.EN)
        .setTargetLanguage(FirebaseTranslateLanguage.PT)
        .build()

    val translator = FirebaseNaturalLanguage.getInstance().getTranslator(options)


    translator.downloadModelIfNeeded()
        .addOnSuccessListener {
            val translatedAdvices =  mutableListOf<AdviceEntity>()
            advices.forEachIndexed { index, advice ->
                translator.translate(advice.advice)
                    .addOnSuccessListener { translatedText ->
                        translatedAdvices.add(AdviceEntity(advice.id, translatedText))
                        if (translatedAdvices.size == advices.size) {
                            onSuccess(translatedAdvices)
                        }
                    }
                    .addOnFailureListener {
                        onFailure("Não foi possível traduzir o texto: ${advice.advice}")
                    }
            }
        }
        .addOnFailureListener {
            onFailure("Não foi possível baixar o modelo de tradução")
        }
}
