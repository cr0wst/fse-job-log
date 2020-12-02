package dev.stevecrow.fse.import.client

import dev.stevecrow.fse.client.FseFlightLog
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.springframework.stereotype.Service

private const val DATAFEED_BASE_URL = "https://server.fseconomy.net/data"
private const val DATAFEED_FLIGHT_LOG_URL = "$DATAFEED_BASE_URL?format=xml&query=flightlogs&search=id"

@Service
class FseHttpClient(private val client: HttpHandler) {
    fun retrieveFlightLog(readAccessKey: String, userKey: String, fromId: Long = 0): FseFlightLog {
        val request = Request(Method.GET, DATAFEED_FLIGHT_LOG_URL)
            .query("readaccesskey", readAccessKey)
            .query("userkey", userKey)
            .query("fromid", fromId.toString())

        val response = client(request)

        return FseFlightLog.fromString(response.bodyString())
    }
}
