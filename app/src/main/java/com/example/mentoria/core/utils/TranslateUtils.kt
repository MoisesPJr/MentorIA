package com.example.mentoria.core.utils

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