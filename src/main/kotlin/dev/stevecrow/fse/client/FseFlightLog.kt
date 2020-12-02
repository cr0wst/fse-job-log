package dev.stevecrow.fse.client

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.xml.bind.annotation.XmlRootElement
import kotlin.time.ExperimentalTime

@XmlRootElement(name = "FlightLogsFromId")
data class FseFlightLog(
    @JacksonXmlProperty(isAttribute = true)
    val total: Long = 0,
    @JsonProperty(value = "FlightLog")
    @JacksonXmlElementWrapper(useWrapping = false)
    val entries: List<Entry> = emptyList()
) {
    companion object {
        private val objectMapper: ObjectMapper = XmlMapper().registerKotlinModule().registerModule(JavaTimeModule())

        fun fromString(string: String): FseFlightLog {
            return objectMapper.readValue(string, FseFlightLog::class.java)
        }
    }

    data class Entry @ExperimentalTime constructor(
        @get:JsonProperty(value = "Id")
        val id: Long = 0,

        @get:JsonProperty(value = "Type")
        val type: String = "",

        @get:JsonProperty(value = "Time")
        @get:JsonDeserialize(using = LocalDateTimeDeserializer::class)
        @get:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
        val time: LocalDateTime = LocalDateTime.now(),

        @get:JsonProperty(value = "Distance")
        val distance: Long = 0,

        @get:JsonProperty(value = "Pilot")
        val pilot: String = "",

        @get:JsonProperty(value = "SerialNumber")
        val serialNumber: String = "",

        @get:JsonProperty(value = "Aircraft")
        val aircraft: String = "",

        @get:JsonProperty(value = "MakeModel")
        val makeModel: String = "",

        @get:JsonProperty(value = "From")
        val from: String? = "",

        @get:JsonProperty(value = "To")
        val to: String? = "",

        @get:JsonProperty(value = "TotalEngineTime")
        val totalEngineTime: String = "",

        @get:JsonProperty(value = "FlightTime")
        val flightTime: String = "",

        @get:JsonProperty(value = "GroupName")
        val groupName: String? = "",

        @get:JsonProperty(value = "Income")
        val income: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "PilotFee")
        val pilotFee: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "CrewCost")
        val crewCost: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "BookingFee")
        val bookingFee: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "Bonus")
        val bonus: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "FuelCost")
        val fuelCost: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "GCF")
        val gcf: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "RentalPrice")
        val rentalPrice: BigDecimal = BigDecimal.ZERO,

        @get:JsonProperty(value = "RentalType")
        val rentalType: String = "",

        @get:JsonProperty(value = "RentalUnits")
        val rentalUnits: String = "",

        @get:JsonProperty(value = "RentalCost")
        val rentalCost: BigDecimal = BigDecimal.ZERO
    )
}
