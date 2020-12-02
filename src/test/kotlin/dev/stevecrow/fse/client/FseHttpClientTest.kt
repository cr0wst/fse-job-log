package dev.stevecrow.fse.client

import dev.stevecrow.fse.buildFlightLog
import dev.stevecrow.fse.import.client.FseHttpClient
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.slot
import io.mockk.verify
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class FseHttpClientTest {
    @RelaxedMockK
    lateinit var response: Response

    @RelaxedMockK
    lateinit var httpHandler: HttpHandler

    @InjectMockKs
    lateinit var httpClient: FseHttpClient

    @Test
    fun `retrieveFlightLog requests data from correct url using the correct method`() {
        val request = slot<Request>()
        every { response.bodyString() } returns buildFlightLog()
        every { httpHandler.invoke(capture(request)) } returns response

        httpClient.retrieveFlightLog("9B48C18AD5CC0E31", "9B48C18AD5CC0E31", 5)

        verify { httpHandler.invoke(any()) }
        assertEquals(Method.GET, request.captured.method)
        assertEquals(
            "https://server.fseconomy.net/data?format=xml&query=flightlogs&search=id&readaccesskey=9B48C18AD5CC0E31&userkey=9B48C18AD5CC0E31&fromid=5",
            request.captured.uri.toString()
        )
    }
}
