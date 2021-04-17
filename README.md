# ActivityTracker

Implementation of the backend of an application which can track availability of drivers near to a
location. It can also track locations of all drivers in real-time, along with returning all drivers
withing a particular radius.

### Assumptions:

Area is a 10x10 grid in which 20 drivers are currently present, their location changes every 5
seconds randomly and at any time we can get any driver near us using the below endpoints.

## Endpoints:

### GET:

<ul>
<li><b>localhost:8080/availability/location/driver/all</b>
<br> Get location coordinates of all drivers.<br>
sample response: [
    {
        "driverId": 1,
        "xCoordinate": 3,
        "yCoordinate": 8
    },
    {
        "driverId": 2,
        "xCoordinate": 5,
        "yCoordinate": 0
    }]
</li>
<br>
<li><b>localhost:8080/availability/location/driver/{driverId}</b>
<br>Get location of a particular driver (Currently only 20 drivers in db so driverId from 1 to 20)<br>
Sample Response: {
    "driverId": 13,
    "xCoordinate": 6,
    "yCoordinate": 5
}</li><br>
<li><b>localhost:8080/availability/location/nearMe?x={int}&y={int} </b><br>
Get all locations near the given coordinates.(keep x and y from 0 to 10)<br>
Sample Response: [
    {
        "driverId": 1,
        "xCoordinate": 6,
        "yCoordinate": 9
    },
    {
        "driverId": 6,
        "xCoordinate": 6,
        "yCoordinate": 8
    },
    {
        "driverId": 17,
        "xCoordinate": 8,
        "yCoordinate": 9
    }
]
</li>
<br>
</ul>

## Database:

Go to `localhost:8080/h2-console` to check the database, with the following details:<br>
JDBC url : jdbc:h2:mem:availability_tracker <br>
Driver class: org.h2.Driver <br>
User name: sa<br>
