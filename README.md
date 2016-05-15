# CAMHS-api


### End points

##### Trusts
- https://camhs-api.herokuapp.com/trust/{trust_id}
- https://camhs-api.herokuapp.com/trusts

##### Bed requests
- https://camhs-api.herokuapp.com/request/{request_id}
- https://camhs-api.herokuapp.com/request/{request_id}/reject
- https://camhs-api.herokuapp.com/request/{request_id}/accept
- https://camhs-api.herokuapp.com/request/{request_id}/cancel

##### POST Request
- https://camhs-api.herokuapp.com/requests
```
  {
    originId: RV01,         <- Requesting trust id
    destinationId: RV1C2,   <- Provider trust id
    patient: "Tom Ridd"     <- Patient name
    beds_type1: = 1,        <- Beds requested (0 or 1)
    beds_type2: = 0,
    beds_type3: = 0,
    referredBy: "Dr Moghraby" <- Doctor name
    nhsNumber: 09101313     <- Patient nhs number
    age: 16,
    gender: Male,           <- (Male/Female)
   }
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