# CAMHS-api
A lightweight server for prototype data development

Quick data server to get us up and running

### End points

##### Trusts
- https://camhs-api.herokuapp.com/trust/{trust_id}
- https://camhs-api.herokuapp.com/trusts

##### Bed requests
- https://camhs-api.herokuapp.com/request/{request_id}
- https://camhs-api.herokuapp.com/request/{request_id}/reject
- https://camhs-api.herokuapp.com/request/{request_id}/accept
- https://camhs-api.herokuapp.com/request/{request_id}/cancel

##### Inbox and outbox
- https://camhs-api.herokuapp.com/requests/sent/{trust_id}
- https://camhs-api.herokuapp.com/requests/received/{trust_id}
- ?status=active ?status=rejected ?status=accepted ?status=cancelled

##### Beds of various types
- https://camhs-api.herokuapp.com/beds/{trust_id}/{bed_type}
- https://camhs-api.herokuapp.com/beds/{trust_id}/{bed_type}/plus
- https://camhs-api.herokuapp.com/beds/{trust_id}/{bed_type}/minus


## Getting Started

### Running locally
```
./run.sh
```

### Dependencies

- JsonPath https://github.com/jayway/JsonPath
- Restolino https://github.com/davidcarboni/restolino