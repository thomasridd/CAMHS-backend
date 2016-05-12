# Datalino
A lightweight server for prototype data development

Add a .json file to the resources folder to add that endpoint

### Example

These examples come from the sample project's names.json

- https://datalino.herokuapp.com/names
- https://datalino.herokuapp.com/names?Rank=1
- https://datalino.herokuapp.com/names?jsonpath=$..Name

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
