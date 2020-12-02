package dev.stevecrow.fse

fun buildFlightLog(content: String = "", total: Long = 0) =
    """<FlightLogsFromId xmlns="https://server.fseconomy.net" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:schemaLocation="https://server.fseconomy.net/static/xsd/datafeed_FlightLogs.xsd" total="$total">$content</FlightLogsFromId>"""

fun buildFlightEntryWithGroup() =
    """
            <FlightLog>
            <Id>12463018</Id>
            <Type>flight</Type>
            <Time>2020/10/20 21:16:33</Time>
            <Distance>87</Distance>
            <Pilot>cr0wst</Pilot>
            <SerialNumber>12090</SerialNumber>
            <Aircraft>MMS4951</Aircraft>
            <MakeModel>Cessna 208 Caravan</MakeModel>
            <From>KGRR</From>
            <To>3TE</To>
            <TotalEngineTime>1084:04</TotalEngineTime>
            <FlightTime>0:40</FlightTime>
            <GroupName>Above Alaska Aviation, LLC</GroupName>
            <Income>4110.00</Income>
            <PilotFee>2880.00</PilotFee>
            <CrewCost>0.00</CrewCost>
            <BookingFee>493.20</BookingFee>
            <Bonus>0.00</Bonus>
            <FuelCost>0.00</FuelCost>
            <GCF>411.00</GCF>
            <RentalPrice>0.00</RentalPrice>
            <RentalType>hobbs</RentalType>
            <RentalUnits>0:40</RentalUnits>
            <RentalCost>0.00</RentalCost>
            </FlightLog>
    """.trimIndent()

fun buildFlightEntryWithoutGroup() =
    """
            <FlightLog>
            <Id>12431430</Id>
            <Type>flight</Type>
            <Time>2020/10/17 16:35:01</Time>
            <Distance>25</Distance>
            <Pilot>cr0wst</Pilot>
            <SerialNumber>49788</SerialNumber>
            <Aircraft>US-C172-01</Aircraft>
            <MakeModel>Cessna 172 Skyhawk</MakeModel>
            <From>KFDY</From>
            <To>KAOH</To>
            <TotalEngineTime>26:24</TotalEngineTime>
            <FlightTime>0:19</FlightTime>
            <GroupName/>
            <Income>813.00</Income>
            <PilotFee>0.00</PilotFee>
            <CrewCost>0.00</CrewCost>
            <BookingFee>0.00</BookingFee>
            <Bonus>-24.59</Bonus>
            <FuelCost>14.56</FuelCost>
            <GCF>81.30</GCF>
            <RentalPrice>280.00</RentalPrice>
            <RentalType>hobbs</RentalType>
            <RentalUnits>0:19</RentalUnits>
            <RentalCost>88.36</RentalCost>
            </FlightLog>
    """.trimIndent()

fun buildRefuelEntry() =
    """
            <FlightLog>
            <Id>12759473</Id>
            <Type>refuel</Type>
            <Time>2020/11/27 19:31:21</Time>
            <Distance>0</Distance>
            <Pilot>cr0wst</Pilot>
            <SerialNumber>48875</SerialNumber>
            <Aircraft>R-OMA6</Aircraft>
            <MakeModel>Diamond DA62</MakeModel>
            <From/>
            <To/>
            <TotalEngineTime>0:00</TotalEngineTime>
            <FlightTime>0:00</FlightTime>
            <GroupName/>
            <Income>0.00</Income>
            <PilotFee>0.00</PilotFee>
            <CrewCost>0.00</CrewCost>
            <BookingFee>0.00</BookingFee>
            <Bonus>0.00</Bonus>
            <FuelCost>290.44</FuelCost>
            <GCF>0.00</GCF>
            <RentalPrice>0.00</RentalPrice>
            <RentalType>hobbs</RentalType>
            <RentalUnits>0:00</RentalUnits>
            <RentalCost>0.00</RentalCost>
            </FlightLog>
    """.trimIndent()
