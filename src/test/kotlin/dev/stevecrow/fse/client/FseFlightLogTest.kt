package dev.stevecrow.fse.client

import dev.stevecrow.fse.buildFlightEntryWithGroup
import dev.stevecrow.fse.buildFlightEntryWithoutGroup
import dev.stevecrow.fse.buildFlightLog
import dev.stevecrow.fse.buildRefuelEntry
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month

class FseFlightLogTest {
    @Test
    fun `xml with no flight log entries`() {
        val xml = buildFlightLog()

        val result = FseFlightLog.fromString(xml)

        assertEquals(0, result.total)
        assertEquals(0, result.entries.size)
    }

    @Test
    fun `xml with single flight log refuel entry`() {
        val xml = buildFlightLog(buildRefuelEntry(), 1)

        val result = FseFlightLog.fromString(xml)

        assertEquals(1, result.total)
        assertEquals(1, result.entries.size)

        assertEquals(12759473, result.entries[0].id)
        assertEquals("refuel", result.entries[0].type)
        assertEquals(LocalDateTime.of(2020, Month.NOVEMBER, 27, 19, 31, 21), result.entries[0].time)
        assertEquals(0, result.entries[0].distance)
        assertEquals("cr0wst", result.entries[0].pilot)
        assertEquals("48875", result.entries[0].serialNumber)
        assertEquals("R-OMA6", result.entries[0].aircraft)
        assertEquals("Diamond DA62", result.entries[0].makeModel)
        assertNull(result.entries[0].from)
        assertNull(result.entries[0].to)
        assertEquals("0:00", result.entries[0].totalEngineTime)
        assertEquals("0:00", result.entries[0].flightTime)
        assertNull(result.entries[0].groupName)
        assertEquals(BigDecimal("0.00"), result.entries[0].income)
        assertEquals(BigDecimal("0.00"), result.entries[0].pilotFee)
        assertEquals(BigDecimal("0.00"), result.entries[0].crewCost)
        assertEquals(BigDecimal("0.00"), result.entries[0].bookingFee)
        assertEquals(BigDecimal("0.00"), result.entries[0].bonus)
        assertEquals(BigDecimal("290.44"), result.entries[0].fuelCost)
        assertEquals(BigDecimal("0.00"), result.entries[0].gcf)
        assertEquals(BigDecimal("0.00"), result.entries[0].rentalPrice)
        assertEquals("hobbs", result.entries[0].rentalType)
        assertEquals("0:00", result.entries[0].rentalUnits)
        assertEquals(BigDecimal("0.00"), result.entries[0].rentalCost)
    }

    @Test
    fun `xml with single flight log flight entry outside of group`() {
        val xml = buildFlightLog(buildFlightEntryWithoutGroup(), 1)

        val result = FseFlightLog.fromString(xml)

        assertEquals(1, result.total)
        assertEquals(1, result.entries.size)

        assertEquals(12431430, result.entries[0].id)
        assertEquals("flight", result.entries[0].type)
        assertEquals(LocalDateTime.of(2020, Month.OCTOBER, 17, 16, 35, 1), result.entries[0].time)
        assertEquals(25, result.entries[0].distance)
        assertEquals("cr0wst", result.entries[0].pilot)
        assertEquals("49788", result.entries[0].serialNumber)
        assertEquals("US-C172-01", result.entries[0].aircraft)
        assertEquals("Cessna 172 Skyhawk", result.entries[0].makeModel)
        assertEquals("KFDY", result.entries[0].from)
        assertEquals("KAOH", result.entries[0].to)
        assertEquals("26:24", result.entries[0].totalEngineTime)
        assertEquals("0:19", result.entries[0].flightTime)
        assertNull(result.entries[0].groupName)
        assertEquals(BigDecimal("813.00"), result.entries[0].income)
        assertEquals(BigDecimal("0.00"), result.entries[0].pilotFee)
        assertEquals(BigDecimal("0.00"), result.entries[0].crewCost)
        assertEquals(BigDecimal("0.00"), result.entries[0].bookingFee)
        assertEquals(BigDecimal("-24.59"), result.entries[0].bonus)
        assertEquals(BigDecimal("14.56"), result.entries[0].fuelCost)
        assertEquals(BigDecimal("81.30"), result.entries[0].gcf)
        assertEquals(BigDecimal("280.00"), result.entries[0].rentalPrice)
        assertEquals("hobbs", result.entries[0].rentalType)
        assertEquals("0:19", result.entries[0].rentalUnits)
        assertEquals(BigDecimal("88.36"), result.entries[0].rentalCost)
    }

    @Test
    fun `xml with single flight log flight entry flown for group`() {
        val xml = buildFlightLog(buildFlightEntryWithGroup(), 1)

        val result = FseFlightLog.fromString(xml)

        assertEquals(1, result.total)
        assertEquals(1, result.entries.size)

        assertEquals(12463018, result.entries[0].id)
        assertEquals("flight", result.entries[0].type)
        assertEquals(LocalDateTime.of(2020, Month.OCTOBER, 20, 21, 16, 33), result.entries[0].time)
        assertEquals(87, result.entries[0].distance)
        assertEquals("cr0wst", result.entries[0].pilot)
        assertEquals("12090", result.entries[0].serialNumber)
        assertEquals("MMS4951", result.entries[0].aircraft)
        assertEquals("Cessna 208 Caravan", result.entries[0].makeModel)
        assertEquals("KGRR", result.entries[0].from)
        assertEquals("3TE", result.entries[0].to)
        assertEquals("1084:04", result.entries[0].totalEngineTime)
        assertEquals("0:40", result.entries[0].flightTime)
        assertEquals("Above Alaska Aviation, LLC", result.entries[0].groupName)
        assertEquals(BigDecimal("4110.00"), result.entries[0].income)
        assertEquals(BigDecimal("2880.00"), result.entries[0].pilotFee)
        assertEquals(BigDecimal("0.00"), result.entries[0].crewCost)
        assertEquals(BigDecimal("493.20"), result.entries[0].bookingFee)
        assertEquals(BigDecimal("0.00"), result.entries[0].bonus)
        assertEquals(BigDecimal("0.00"), result.entries[0].fuelCost)
        assertEquals(BigDecimal("411.00"), result.entries[0].gcf)
        assertEquals(BigDecimal("0.00"), result.entries[0].rentalPrice)
        assertEquals("hobbs", result.entries[0].rentalType)
        assertEquals("0:40", result.entries[0].rentalUnits)
        assertEquals(BigDecimal("0.00"), result.entries[0].rentalCost)
    }
}
