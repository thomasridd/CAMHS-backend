# Datalino
A lightweight server for prototype data development

Add a .json file to the resources folder to add that endpoint

### Example

These examples come from the sample project's names.json

- https://datalino.herokuapp.com/names
- https://datalino.herokuapp.com/names?Rank=1
- https://datalino.herokuapp.com/names?Sex=Male
- https://datalino.herokuapp.com/names?jsonpath=$..Name
- https://datalino.herokuapp.com/names?jsonpath=[?(@.Rank%3C=10)][?(@.Rank%3E5)]&Sex=Male

## Getting Started

### Running locally
```
./run.sh
```

### Deploy to Heroku
```
heroku login
heroku create [some name]
git push heroku master
```
Repeat with
```
git push heroku master
```

### Dependencies

- JsonPath https://github.com/jayway/JsonPath
- Restolino https://github.com/davidcarboni/restolino