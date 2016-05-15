# CAMHS-api
Backend api for CAMHS Bedfinder @NHSHackday 13

- Bed Manager: http://nhshd-bed-finder.github.io/bed-finder/


- Dashboard: https://bedfinder-dashboard.herokuapp.com/

### End points

##### Trusts
- https://camhs-api.herokuapp.com/trust/{trust_id}
- https://camhs-api.herokuapp.com/trusts

##### Bed requests
- https://camhs-api.herokuapp.com/request/{request_id}
- https://camhs-api.herokuapp.com/request/{request_id}/reject
- https://camhs-api.herokuapp.com/request/{request_id}/accept
- https://camhs-api.herokuapp.com/request/{request_id}/cancel

##### Add a request
This is currently done using a parameter based get request to the postrequest endpoint

The request does a search for the closest hospitals with available beds and posts them a bed request
- https://camhs-api.herokuapp.com/postrequest?originId=RV01 ...
```
    originId: RV01,         <- Requesting trust id
    patient: "Tom"          <- Patient name
    beds_type: = 1,         <- Bed type requested (1, 2, 3)
    referredBy: "Dr Moghraby" <- Doctor name
    nhsNumber: 09101313     <- Patient nhs number
    age: 16,                <- Patient age
    gender: Male,           <- (Male/Female)
```
##### Inbox and outbox
- https://camhs-api.herokuapp.com/requests/sent/{trust_id}
- https://camhs-api.herokuapp.com/requests/received/{trust_id}
- ?status=active ?status=rejected ?status=accepted ?status=cancelled

##### Beds of various types
- https://camhs-api.herokuapp.com/beds/{trust_id}/{bed_type}
- https://camhs-api.herokuapp.com/beds/{trust_id}/{bed_type}/plus
- https://camhs-api.herokuapp.com/beds/{trust_id}/{bed_type}/minus

##### Search
- https://camhs-api.herokuapp.com/search/{trust_id}/{bed_type}


## Getting Started

### Running locally
```
./run.sh
```

### Dependencies

- JsonPath https://github.com/jayway/JsonPath
- Restolino https://github.com/davidcarboni/restolino