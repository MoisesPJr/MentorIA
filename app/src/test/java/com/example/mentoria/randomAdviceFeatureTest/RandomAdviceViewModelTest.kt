package com.example.mentoria.randomAdviceFeatureTest

import com.example.mentoria.Service
import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.example.mentoria.randomAdviceFeature.data.model.SlipRemote
import com.example.mentoria.randomAdviceFeature.data.service.AdviceApi
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.mock

class RandomAdviceViewModelTest {


    private val api = mock<AdviceApi>()

    private val service = Service(api)


    @Test
    fun `when getRandomAdvice return advice`() = runBlocking {
        val expectedAdvice = AdviceRemote(
            SlipRemote(
                12,
                "Remember that spiders are more afraid of you, than you are of them."
            )
        )

        whenever(api.getAdvice()).thenReturn(expectedAdvice)

        val advice = runBlocking { service.getAdvice() }

        assertEquals(advice, expectedAdvice)

    }

}